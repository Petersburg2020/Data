package nx.peter.java.util.data;

//
public class Line extends Letters<Line> {
    protected int number;

    public Line(int number) {
        this(CharSet.English, number);
    }

    public Line(int number, char... letters) {
        this(CharSet.English, number, letters);
    }

    public Line(int number, CharSequence letters) {
        this(CharSet.English, number, letters);
    }

    public Line(CharSet charSet, int number) {
        super(charSet);
        setNumber(number);
    }

    public Line(CharSet charSet, int number, char... letters) {
        super(charSet, letters);
        setNumber(number);
    }

    public Line(CharSet charSet, int number, CharSequence letters) {
        super(charSet, letters);
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
        // System.out.println(letters);
        if (new Texts(letters).extractSentences().size() == 1)
            return super.set(letters);
        return this;
    }


    @Override
    public DataType getType() {
        return DataType.Line;
    }
}
