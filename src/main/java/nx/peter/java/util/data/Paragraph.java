package nx.peter.java.util.data;

public class Paragraph extends ISentence<Paragraph> {

    public Paragraph() {
        this("");
    }

    public Paragraph(CharSequence paragraph) {
        super(paragraph);
    }

    public Paragraph(CharSet charSet) {
        super(charSet);
    }

    public Paragraph(CharSet charSet, CharSequence letters) {
        super(charSet, letters);
    }

    @Override
    public DataType getType() {
        return DataType.Paragraph;
    }
}
