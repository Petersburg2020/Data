package nx.peter.java.util.data;

public class Texts extends ISentence<Texts> {

    public Texts() {
        this("");
    }

    public Texts(CharSequence paragraph) {
        super(paragraph);
    }

    @Override
    public DataType getType() {
        return DataType.Texts;
    }

}
