package nx.peter.java.util.data;

//
public class Line extends Letters<Line> {
    protected int number;

    public Line(int number) {
        super();
        setNumber(number);
    }

    public Line(int number, char... letters) {
        super(letters);
        setNumber(number);
    }

    public Line(int number, CharSequence letters) {
        super(letters);
        setNumber(number);
    }

    public Line setNumber(int number) {
        this.number = number;
        return this;
    }

    public int getNumber() {
        return number;
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
