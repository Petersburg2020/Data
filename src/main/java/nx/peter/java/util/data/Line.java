package nx.peter.java.util.data;

//
public class Line extends Letters<Line> {

    public Line() {
    }

    public Line(char... letters) {
        super(letters);
    }

    public Line(CharSequence letters) {
        super(letters);
    }

    @Override
    public Line set(CharSequence letters) {
        if (new Texts(letters).extractSentences().size() == 1)
            return super.set(letters);
        return this;
    }

    @Override
    public DataType getType() {
        return DataType.Line;
    }
}
