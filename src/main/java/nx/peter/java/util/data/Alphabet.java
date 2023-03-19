package nx.peter.java.util.data;

import nx.peter.java.util.Random;

public class Alphabet extends Letter<Alphabet> {

    public Alphabet() {
        super();
    }

    public Alphabet(CharSet charSet) {
        this(charSet, "");
    }

    public Alphabet(char alphabet) {
        super(alphabet);
    }

    public Alphabet(CharSet charSet, char alphabet) {
        this(charSet, alphabet + "");
    }

    public Alphabet(CharSequence alphabet) {
        super(alphabet);
    }

    public Alphabet(CharSet charSet, CharSequence alphabet) {
        super(alphabet);
        setCharSet(charSet);
    }

    @Override
    public Alphabet set(CharSequence alphabet) {
        if (DataManager.isAlphabet(charSet, alphabet))
            this.data = alphabet.toString();
        return this;
    }

    public boolean isAlphabet() {
        return DataManager.isAlphabet(data);
    }

    public int toNumber() {
        return DataManager.toNumber(data);
    }

    public static Alphabet generate() {
        return new Alphabet(DataManager.ALPHABETS_ENGLISH.charAt(Random.nextInt(DataManager.ALPHABETS_ENGLISH.length() - 1)));
    }

    @Override
    public DataType getType() {
        return DataType.Alphabet;
    }

}
