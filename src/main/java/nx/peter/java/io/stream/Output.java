package nx.peter.java.io.stream;

import nx.peter.java.io.Stream;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public interface Output {
    Result<Boolean> write(byte[] bytes);

    Result<Boolean> write(Object what);

    Result<Boolean> write(CharSequence what);

    Result<Boolean> write(List<String> lines);

    Result<Boolean> append(byte[] bytes);

    Result<Boolean> append(Object what);

    Result<Boolean> append(CharSequence what);

    Result<Boolean> append(List<String> lines);

    Result<Boolean> copy(InputStream src, CharSequence dest);

    Result<Boolean> copy(CharSequence src, OutputStream dest);

    Result<Boolean> copy(InputStream src, OutputStream dest);

    Result<Boolean> copy(CharSequence src, CharSequence dest);

    Result<Boolean> close();

    Result<Boolean> delete();

    Stream getSource();

    Input getInput();

    void closeQuietly();

    boolean isClosed();
}
