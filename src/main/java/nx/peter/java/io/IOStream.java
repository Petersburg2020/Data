package nx.peter.java.io;

import nx.peter.java.io.stream.Input;
import nx.peter.java.io.stream.Output;

public class IOStream {
    private IOStream() {
    }

    public static Stream openStream(CharSequence path) {
        return new IStream(path);
    }

    public static Input openInputStream(CharSequence source) {
        return openStream(source).getInputStream();
    }

    public static Output openOutputStream(CharSequence source) {
        return openStream(source).getOutputStream();
    }

}
