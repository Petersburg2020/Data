package nx.peter.java.util.data;

public class Sentence extends ISentence<Sentence> {

	public Sentence() {
		super();
	}

	public Sentence(CharSequence sentence) {
		super(sentence);
	}

	public Sentence(CharSet charSet) {
		super(charSet);
	}

	public Sentence(CharSet charSet, CharSequence letters) {
		super(charSet, letters);
	}

	@Override
	public DataType getType() {
		return DataType.Sentence;
	}

}
