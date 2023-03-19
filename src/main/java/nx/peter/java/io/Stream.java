package nx.peter.java.io;

import nx.peter.java.io.memory.Settings;
import nx.peter.java.io.stream.Input;
import nx.peter.java.io.stream.Output;
import nx.peter.java.io.stream.Result;

import java.io.OutputStream;

public interface Stream {
    Result<Boolean> setPath(CharSequence path);

    CharSequence getPath();

    void setMaxMemoryBytes(long maxBytes);

    void setMemoryUsageSettings(MemoryUsageType usageType, long maxBytes);

    MemoryUsageType getMemoryUsageType();

    long getMaxMemoryBytes();

    Output getOutputStream();

    Input getInputStream();

    Result<Boolean> copy(OutputStream destination);

    Result<Boolean> copy(CharSequence destination);

    Result<Boolean> flush();

    Result<Boolean> close();

    void closeQuietly();

    boolean isClosed();

    boolean isInClosed();

    boolean isOutClosed();

    long getSize();

    int getLineCount();

    Settings getMemoryUsageSettings();


    enum MemoryUsageType {
        MainFileOnly,
        TempFileOnly,
        MixedFiles
    }

}
