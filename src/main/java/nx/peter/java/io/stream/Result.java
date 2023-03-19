package nx.peter.java.io.stream;

public interface Result<R> {
    String getMessage();
    R getResult();
    boolean equals(Result<?> result);
}
