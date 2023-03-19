package nx.peter.java.io;

import nx.peter.java.io.memory.Settings;
import nx.peter.java.io.stream.Input;
import nx.peter.java.io.stream.Output;
import nx.peter.java.io.stream.Result;
import nx.peter.java.util.Util;
import nx.peter.java.util.data.ISentence;
import nx.peter.java.util.data.Line;
import nx.peter.java.util.data.Texts;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class IStream implements Stream {
    protected OutputStream output, tempOutput;
    protected InputStream input, tempInput;
    protected MemoryUsageType usageType;
    protected MemoryUsageSetting setting;

    protected CharSequence source;
    protected boolean isPath, inClosed, outClosed;

    IStream(CharSequence source, boolean isPath) {
        setup(source, isPath);
        setMemoryUsageSettings(MemoryUsageType.TempFileOnly, IOManager.getBytes(input));
    }

    public IStream(CharSequence path) {
        this(path, true);
    }

    protected void reset() {
        setup(source, isPath);
    }

    @Override
    public Result<Boolean> setPath(CharSequence path) {
        return setup(path, true);
    }

    protected Result<Boolean> setupInput(CharSequence source, boolean isPath) {
        String message = "";
        boolean result = false;
        if (isPath && source != null) {
            try {
                input = new FileInputStream(source.toString());
                message += "Input Stream opened successfully!";
                result = true;
            } catch (FileNotFoundException e) {
                input = null;
                message += e.getMessage();
            }
        } else {
            byte[] bytes = (source != null ? source.toString() : "").getBytes();
            input = new ByteArrayInputStream(bytes);
            result = true;
            message = "Input Stream opened successfully!";
        }
        return new ResultImpl<>(message, result);
    }

    protected Result<Boolean> setupOutput(CharSequence source, boolean isPath) {
        String message = "";
        boolean result = false;
        if (isPath && source != null) {
            try {
                output = new FileOutputStream(source.toString());
                message = " - Output Stream opened successfully!";
                result = true;
            } catch (FileNotFoundException e) {
                output = null;
                message = " - " + e.getMessage();
            }
        } else {
            byte[] bytes = (source != null ? source.toString() : "").getBytes();
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            b.writeBytes(bytes);
            output = b;
            result = true;
            message = "Output Stream opened successfully!";
        }
        return new ResultImpl<>(message, result);
    }

    protected Result<Boolean> setup(CharSequence source, boolean isPath) {
        this.source = source;
        this.isPath = isPath;

        Result<Boolean> resIn = setupInput(source, isPath);
        Result<Boolean> resOut = setupOutput(source, isPath);

        String message = resIn.getMessage() + " - " + resOut.getMessage();
        boolean result = resIn.getResult() && resOut.getResult();

        tempInput = input;
        tempOutput = output;
        inClosed = false;
        return new ResultImpl<>(message, result);
    }

    public Result<Boolean> flush() {
        try {
            if (output != null) output.flush();
            return new ResultImpl<>("The Stream was Closed Successfully!", true);
        } catch (IOException e) {
            return new ResultImpl<>(e.getMessage(), false);
        }
    }

    public Result<Boolean> close() {
        Result<Boolean> in = closeInput();
        Result<Boolean> out = closeOutput();
        source = null;
        isPath = false;
        setting.close();
        return new ResultImpl<>(in.getMessage() + " - " + out.getMessage(), in.getResult() && out.getResult());
    }

    public boolean isInClosed() {
        return inClosed;
    }

    public boolean isOutClosed() {
        return outClosed;
    }

    @Override
    public long getSize() {
        return getInputStream().readText().getResult().length() - getLineCount() - 1;
    }

    @Override
    public int getLineCount() {
        return getInputStream().readLines().getResult().size();
    }

    @Override
    public boolean isClosed() {
        return inClosed && outClosed;
    }

    public Result<Boolean> closeInput() {
        try {
            if (source == null || input == null || tempInput == null) throw new IOException("Cannot close a null Input Stream!");
            input.close();
            tempInput.close();
            inClosed = true;
            return new ResultImpl<>("Input Stream closed successfully!", true);
        } catch (IOException e) {
            return new ResultImpl<>(e.getMessage(), false);
        }
    }

    public Result<Boolean> closeOutput() {
        try {
            if (source == null || output == null || tempOutput == null) throw new IOException("Cannot close a null Output Stream!");
            output.close();
            tempOutput.close();
            outClosed = true;
            return new ResultImpl<>("Output Stream closed successfully!", true);
        } catch (IOException e) {
            return new ResultImpl<>(e.getMessage(), false);
        }
    }

    @Override
    public void closeQuietly() {
        close();
        inClosed = true;
        outClosed = true;
    }

    @Override
    public CharSequence getPath() {
        return source;
    }

    @Override
    public Settings getMemoryUsageSettings() {
        return setting.getSettings();
    }

    @Override
    public void setMaxMemoryBytes(long maxBytes) {
        setMemoryUsageSettings(usageType, maxBytes);
    }

    @Override
    public void setMemoryUsageSettings(MemoryUsageType usageType, long maxBytes) {
        this.usageType = usageType;
        switch (usageType) {
            case MainFileOnly:
                setting = MemoryUsageSetting.setupMainMemoryOnly(maxBytes);
                break;
            case TempFileOnly:
                setting = MemoryUsageSetting.setupTempFileOnly(maxBytes);
                break;
            case MixedFiles:
                setting = MemoryUsageSetting.setupMixed(maxBytes);
                break;
        }
        setting.setTempDirWithDefault("stream_");
        setting.getSettings().store();
    }

    @Override
    public MemoryUsageType getMemoryUsageType() {
        return usageType;
    }

    @Override
    public long getMaxMemoryBytes() {
        return setting.getMaxStorageBytes();
    }

    @Override
    public Output getOutputStream() {
        return new OutputImpl(this);
    }

    @Override
    public Input getInputStream() {
        return new InputImpl(this);
    }

    @Override
    public Result<Boolean> copy(OutputStream destination) {
        boolean copied = FileManager.copy(input, destination);
        return new ResultImpl<>("Stream was " + (copied ? "" : "not ") + "copied successfully!", copied);
    }

    @Override
    public Result<Boolean> copy(CharSequence destination) {
        boolean copied = FileManager.copy(input, destination);
        return new ResultImpl<>("Stream was " + (copied ? "" : "not ") + "copied successfully!", copied);
    }


    static class OutputImpl implements Output {
        IStream source;

        public OutputImpl(IStream source) {
            this.source = source;
        }

        @Override
        public Result<Boolean> write(byte[] bytes) {
            try {
                if (source.source == null) throw new IOException("A null file cannot be written to!");
                if (bytes == null) throw new IOException("A null byte cannot be written to stream!");
                BufferedWriter writer = new BufferedWriter(getWriter());
                writer.write(new String(bytes));
                return new ResultImpl<>("Bytes successfully written!", true);
            } catch (IOException e) {
                return new ResultImpl<>(e.getMessage(), false);
            }
        }

        @Override
        public Result<Boolean> write(Object what) {
            return write(what != null ? what.toString() : "");
        }

        @Override
        public boolean isClosed() {
            return source.isOutClosed();
        }

        @Override
        public Result<Boolean> write(CharSequence what) {
            return output(what, false);
        }

        protected Result<Boolean> output(CharSequence what, boolean appendable) {
            try {
                if (source.source == null)
                    throw new IOException("A null file cannot be " + (appendable ? "appended" : "written") + " to!");
                System.out.println(what);
                if (what == null)
                    throw new IOException("A null Object cannot be " + (appendable ? "appended" : "written") + " to stream!");

                OutputStreamWriter output = appendable ? getAppendableWriter() : getWriter();
                BufferedWriter writer = new BufferedWriter(output);
                writer.write(what.toString());
                writer.close();
                output.close();
                return new ResultImpl<>("Object was successfully " + (appendable ? "appended " : "written ") + "to Output Stream!", true);
            } catch (IOException e) {
                return new ResultImpl<>((appendable ? "Append: " : "Write: ") + e.getMessage(), false);
            }
        }

        @Override
        public Result<Boolean> write(List<String> lines) {
            return write(lines != null ? Util.toLines(lines) : "");
        }

        OutputStreamWriter getWriter() throws FileNotFoundException {
            return new OutputStreamWriter(new FileOutputStream(source.source.toString()));
        }

        OutputStreamWriter getAppendableWriter() throws FileNotFoundException {
            return new OutputStreamWriter(new FileOutputStream(source.source.toString(), true));
        }

        @Override
        public Result<Boolean> append(byte[] bytes) {
            return append(bytes != null ? new String(bytes) : "");
        }

        @Override
        public Result<Boolean> append(Object what) {
            return append(what != null ? what.toString() : "");
        }


        @Override
        public Result<Boolean> copy(CharSequence src, CharSequence dest) {
            try {
                return copy(new FileInputStream(src.toString()), new FileOutputStream(dest.toString()));
            } catch (IOException e) {
                return new ResultImpl<>(e.getMessage(), false);
            }
        }

        @Override
        public Result<Boolean> copy(InputStream src, CharSequence dest) {
            try {
                return copy(src, new FileOutputStream(dest.toString()));
            } catch (IOException e) {
                return new ResultImpl<>(e.getMessage(), false);
            }
        }

        @Override
        public Result<Boolean> copy(CharSequence src, OutputStream dest) {
            try {
                return copy(new FileInputStream(src.toString()), dest);
            } catch (IOException e) {
                return new ResultImpl<>(e.getMessage(), false);
            }
        }

        int line;

        @Override
        public Result<Boolean> copy(InputStream input, OutputStream output) {
            line = 0;
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                List<String> lines = new ArrayList<>();
                String text;
                while ((text = reader.readLine()) != null)
                    lines.add(text);

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
                writer.write(lines.stream().map(s -> s + (++line < lines.size() ? "\n" : "")).collect(Collectors.joining()));

                reader.close();
                writer.close();
                return new ResultImpl<>("Copied successfully!", true);
            } catch (IOException e) {
                return new ResultImpl<>(e.getMessage(), false);
            }
        }

        protected void reset() {
            source.reset();
        }

        @Override
        public Result<Boolean> append(CharSequence what) {
            return output(what, true);
        }

        @Override
        public Result<Boolean> append(List<String> lines) {
            return append(lines != null ? Util.toLines(lines) : "");
        }

        @Override
        public Result<Boolean> close() {
            return source.closeOutput();
        }

        @Override
        public Result<Boolean> delete() {
            boolean delete = source.source != null && FileManager.delete(source.source);
            return new ResultImpl<>(delete ? "Stream deleted successfully!" : "Cannot delete invalid Stream!", delete);
        }

        @Override
        public Stream getSource() {
            return source;
        }

        @Override
        public Input getInput() {
            return source.getInputStream();
        }

        @Override
        public void closeQuietly() {
            source.closeQuietly();
        }
    }

    static class InputImpl implements Input {
        IStream source;

        public InputImpl(IStream source) {
            this.source = source;
        }

        Texts getSrc() {
            InputStream stream = getStream();
            return new Texts(stream == null ? "" : FileManager.readString(stream));
        }

        @Override
        public Result<ISentence.Lines> readLines() {
            try {
                InputStream stream = getStream();
                if (source.source == null || stream == null) throw new IOException("A null file cannot be written to!");
                InputStreamReader input = new InputStreamReader(stream);
                BufferedReader reader = new BufferedReader(input);
                List<Line> lines = new ArrayList<>();
                int count = 0;
                String line;
                while ((line = reader.readLine()) != null) {
                    count++;
                    lines.add(new Line(count, line));
                }
                reader.close();
                input.close();
                return new ResultImpl<>("Lines Read successfully!", new ISentence.Lines(getSrc(), lines));
            } catch (IOException e) {
                reset();
                return new ResultImpl<>(e.getMessage(), new ISentence.Lines(getSrc(), new ArrayList<>()));
            }
        }


        @Override
        public Result<ISentence.Lines> readSizeLines(long size) {
            if (source.source == null)
                return new ResultImpl<>("Cannot read from a closed file!", new ISentence.Lines(getSrc(), new ArrayList<>()));
            if (size <= 0)
                return new ResultImpl<>(size + "byte is invalid!", new ISentence.Lines(getSrc(), new ArrayList<>()));

            // File size in length
            long fileSize = source.getSize();

            System.out.println(size + " " + (size > fileSize ? "> " : size < fileSize ? "< " : "== ") + fileSize);

            // Check if given size is greater than the file size
            if (size > fileSize)
                return new ResultImpl<>(size + "byte(s) is greater than file size!", new ISentence.Lines(getSrc(), new ArrayList<>()));

            // Get the total lines of the file and the accompanying message
            Result<ISentence.Lines> result = readLines();
            long linesSize = 0;
            ISentence.Lines lines = result.getResult();

            // A line list that collects the lines within the size given's scope
            List<Line> temp = new ArrayList<>();

            // Read each line and check if the given size falls on the line
            for (Line line : lines) {
                long currentLineSize = line.length();
                if (currentLineSize + linesSize >= size + lines.size() - 1) {
                    temp.add(new Line(line.getNumber(), currentLineSize + linesSize == size + lines.size() - 1 ? line.get() : line.subLetters(0, (int) (size + lines.size() - linesSize)).get()));
                    break;
                }
                linesSize += currentLineSize;
                temp.add(line);
            }
            return new ResultImpl<>(result.getMessage(), new ISentence.Lines(getSrc(), temp));
        }

        @Override
        public Result<String> readText() {
            Result<ISentence.Lines> result = readLines();
            return new ResultImpl<>(result.getMessage(), result.getResult().toString());
        }

        @Override
        public Result<String> readSizeText(long size) {
            Result<ISentence.Lines> result = readSizeLines(size);
            return new ResultImpl<>(result.getMessage(), result.getResult().toString());
        }

        public InputStream getStream() {
            try {
                if (source.source == null) throw new IOException("A null file cannot be written to!");
                source.input = new FileInputStream(source.source.toString());
                source.tempInput = source.input;
                return source.input;
            } catch (IOException e) {
                return null;
            }
        }

        @Override
        public Result<Boolean> close() {
            return source.close();
        }

        @Override
        public Stream getSource() {
            return source;
        }

        @Override
        public void closeQuietly() {
            source.closeQuietly();
        }


        protected void reset() {
            source.reset();
        }

    }

    static class ResultImpl<R> implements Result<R> {
        String message;
        R result;

        public ResultImpl(String message, R result) {
            this.message = message;
            this.result = result;
        }

        @Override
        public String getMessage() {
            return message;
        }

        @Override
        public R getResult() {
            return result;
        }

        @Override
        public boolean equals(Result<?> result) {
            return result != null && result.getResult().equals(this.result) && result.getMessage().contentEquals(message);
        }

        @Override
        public String toString() {
            return getResult().toString();
        }
    }

}
