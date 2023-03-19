package nx.peter.java.io.stream;

import nx.peter.java.io.Stream;
import nx.peter.java.util.data.ISentence;

import java.io.InputStream;

public interface Input {
    Result<ISentence.Lines> readLines();

    Result<ISentence.Lines> readSizeLines(long size);

    Result<String> readText();

    Result<String> readSizeText(long size);

    Result<Boolean> close();

    Stream getSource();

    InputStream getStream();

    void closeQuietly();
}
