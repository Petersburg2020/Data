package nx.peter.java.util.data;

public class Texts extends ISentence<Texts> {

    public Texts() {
        this("");
    }

    public Texts(CharSequence paragraph) {
        super(paragraph);
    }

    public Texts(CharSet charSet) {
        super(charSet);
    }

    public Texts(CharSet charSet, CharSequence letters) {
        super(charSet, letters);
    }

    @Override
    public DataType getType() {
        return DataType.Texts;
    }

}
