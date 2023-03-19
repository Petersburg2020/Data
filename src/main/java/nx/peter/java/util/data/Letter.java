package nx.peter.java.util.data;

import java.nio.charset.StandardCharsets;

public class Letter<L extends Letter> extends Data<L> {
	protected int index;
	protected CharSet charSet;
	
	public Letter() {
		super();
	}

	public Letter(CharSet charSet) {
		this(charSet, "");
	}

	public Letter(char letter) {
		super(letter);
	}

	public Letter(CharSet charSet, char alphabet) {
		this(charSet, alphabet + "");
	}

	public Letter(CharSequence letter) {
		super(letter);
	}

	public Letter(CharSet charSet, CharSequence alphabet) {
		super(alphabet);
		setCharSet(charSet);
	}

	public Letter(char letter, int index) {
		super(letter);
		this.index = index;
	}
	
	public Letter(Letter<?> another) {
		this(another != null ? another.charSet : CharSet.English, another != null ? another.get() : "", another != null ? another.getIndex() : -1);
	}
	
	public Letter(CharSequence letter, int index) {
		super(letter);
		this.index = index;
	}

	public Letter(CharSet charSet, CharSequence letter, int index) {
		super(letter);
		this.index = index;
		setCharSet(charSet);
	}

	public CharSet getCharSet() {
		return charSet;
	}

	public L setCharSet(CharSet charSet) {
		this.charSet = charSet;
		return set(data);
	}

	public int getIndex() {
		return index;
	}

	@Override
	public L reset() {
		super.reset();
		index = -1;
		setCharSet(CharSet.English);
		return (L) this;
	}
	
	public L set(char data) {
		return super.set(data);
	}

	@Override
	public L set(CharSequence data) {
		if (data != null && data.length() == 1)
			super.set(data);
		return (L) this;
	}
	
	public char[] toCharArray() {
		return data.toCharArray();
	}
	
	public L toUpperCase() {
		data = data.toUpperCase();
		return (L) this;
	}
	
	public L toLowerCase() {
		data = data.toLowerCase();
		return (L) this;
	}
	
	public boolean isUpperCase() {
		return DataManager.isUpperCase(data);
	}
	
	public boolean isLowerCase() {
		return DataManager.isLowerCase(data);
	}
	
	public boolean isConsonant() {
		return DataManager.isConsonant(data);
	}
	
	public boolean isVowel() {
		return DataManager.isVowel(data);
	}

	@Override
	public boolean isValid() {
		return super.isValid() && index > -1;
	}

	@Override
	public DataType getType() {
		return DataType.Letter;
	}
	
	public boolean equalsIgnoreCase(Letter<?> another) {
		return another != null && DataManager.equalsIgnoreCaseAlphabet(another.get(), get());
	}

	@Override
	public boolean equalsIgnoreCase(IData<?> another) {
		return another instanceof Letter && equalsIgnoreCase((Letter<?>) another);
	}

	@Override
	public boolean equalsIgnoreType(IData<?> another) {
		return another != null && DataManager.equalsIgnoreCaseAlphabet(another.get(), get());
	}

	protected CharSequence toUtf8(CharSequence what) {
		return charSet.equals(IData.CharSet.Latin) ? super.toUtf8(what) : what;
	}

	@Override
	public boolean equals(IData<?> another) {
		return another instanceof Letter && ((Letter<?>) another).index == index && equalsIgnoreType(another);
	}
	

}
