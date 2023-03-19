package nx.peter.java.util.data;

import java.nio.charset.StandardCharsets;

public abstract class Data<D extends Data> implements IData<D> {
    protected String data;
    protected int index;

    public Data() {
        reset();
    }

    public Data(char... data) {
        this(new String(data));
    }

    public Data(int index, char... data) {
        this(index, new String(data));
    }

    public Data(int index, CharSequence data) {
        reset();
        set(index, data);
    }

    public Data(D data) {
        reset();
        set(data);
    }

    public Data(CharSequence data) {
        reset();
        set(data);
    }

    @Override
    public D reset() {
        data = "";
        index = 0;
        return (D) this;
    }

    @Override
    public D set(D data) {
        if (data != null)
            set(data.get());
        return (D) this;
    }

    @Override
    public D set(char... data) {
        return set(new String(data));
    }

    @Override
    public D set(CharSequence data) {
        if (data != null)
            this.data = data.toString();
        return (D) this;
    }

    @Override
    public D set(int index, char... data) {
        return set(index, new String(data));
    }

    @Override
    public D set(int index, CharSequence data) {
        this.index = index;
        if (data != null)
            this.data = data.toString();
        return (D) this;
    }

    @Override
    public char charAt(int index) {
        return data.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return data.subSequence(start, end);
    }

    @Override
    public int count(int data) {
        return count(data + "");
    }

    @Override
    public int count(long data) {
        return count(data + "");
    }

    @Override
    public int count(char data) {
        return count(data + "");
    }

    @Override
    public int count(boolean data) {
        return count(data + "");
    }

    @Override
    public int count(double data) {
        return count(data + "");
    }

    @Override
    public int count(IData<?> data) {
        return count(data != null ? data.get() : null);
    }

    @Override
    public int count(CharSequence data) {
        if (data == null)
            return 0;
        int count = 0, index;
        String temp = this.data;
        while (true) {
            index = temp.indexOf(toUtf8(data).toString());
            if (index == -1)
                break;
            count++;
            temp = temp.substring(index + data.length());
        }
        return count;
    }

    protected CharSequence toUtf8(CharSequence data) {
        return data != null ? new String(data.toString().getBytes(StandardCharsets.UTF_8)) : "";
    }

    @Override
    public int compareTo(D data) {
        return this.data.compareTo(data != null ? data.data : "");
    }

    @Override
    public <O> D append(O word, int index) {
        return append(word != null ? word.toString() : "", index);
    }

    @Override
    public D append(IData<?> data, int index) {
        return append(data != null ? data.get() : null, index);
    }

    @Override
    public D append(CharSequence word, int index) {
        if (length() > index && index > 0) {
            String start = data.substring(0, index);
            String end = data.substring(index);
            set(start + word.toString() + end);
        } else if (index == 0)
            set(word.toString() + data);
        else if (index == length())
            set(data + word.toString());
        return (D) this;
    }

    @Override
    public <O> D append(O word) {
        return append(word != null ? word.toString() : "");
    }

    @Override
    public D append(IData<?> data) {
        return append(data != null ? data.get() : null);
    }

    @Override
    public D append(CharSequence word) {
        return append(word, length());
    }

    @Override
    public int length() {
        return data.length();
    }

    @Override
    public String get() {
        return data;
    }

    @Override
    public boolean isValid() {
        return !data.isEmpty();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isNotEmpty() {
        return !isEmpty();
    }

    @Override
    public boolean isLetter() {
        return isAlphabet() || isCharacter();
    }

    @Override
    public boolean isLetters() {
        return isWord() || isSentence() || isParagraph() || isTexts();
    }

    @Override
    public boolean isWord() {
        return getType().equals(DataType.Word) || DataManager.extractWords(data).size() == 1;
    }

    @Override
    public boolean isLine() {
        return getType().equals(DataType.Line);
    }

    @Override
    public boolean isIndex() {
        return getType().equals(DataType.Index) || DataManager.isIndex(data);
    }

    @Override
    public boolean isFraction() {
        return getType().equals(DataType.Fraction) || DataManager.isFraction(data);
    }

    @Override
    public boolean isAlphabet() {
        return isAlphabet(CharSet.English);
    }

    @Override
    public boolean isAlphabet(CharSet charSet) {
        return getType().equals(DataType.Alphabet) || DataManager.isAlphabet(charSet, data);
    }

    @Override
    public boolean isNumber() {
        return getType().equals(DataType.Number) || DataManager.isNumberOnly(data);
    }

    @Override
    public boolean isCharacter() {
        return getType().equals(DataType.Character) || DataManager.isCharacter(data);
    }

    @Override
    public boolean isSentence() {
        return getType().equals(DataType.Sentence);
    }

    @Override
    public boolean isTexts() {
        return getType().equals(DataType.Texts) || isParagraph() || isSentence() || isWord();
    }

    @Override
    public boolean isParagraph() {
        return getType().equals(DataType.Paragraph);
    }

    @Override
    public <O> int indexOf(O data) {
        return indexOf(data + "");
    }

    @Override
    public int indexOf(IData<?> data) {
        return indexOf(data != null ? data.get() : null);
    }

    @Override
    public int indexOf(CharSequence data) {
        return data != null ? this.data.indexOf(data.toString()) : -1;
    }

    @Override
    public <O> int indexOf(O data, int start) {
        return indexOf(data != null ? data.toString() : "", start);
    }

    @Override
    public int indexOf(IData<?> data, int start) {
        return indexOf(data != null ? data.toString() : null, start);
    }

    @Override
    public int indexOf(CharSequence data, int start) {
        return data != null && start >= 0 && start < length() ? this.data.indexOf(data.toString(), start) : -1;
    }


    @Override
    public <O> int indexBefore(O data) {
        return indexBefore(data != null ? data.toString() : "");
    }

    @Override
    public int indexBefore(IData<?> data) {
        return indexBefore(data != null ? data.get() : (String) null);
    }

    @Override
    public int indexBefore(CharSequence data) {
        return data != null && contains(data) ? this.data.indexOf(data.toString()) + data.length() : -1;
    }


    @Override
    public <O> int indexAfter(O data) {
        return indexAfter(data + "");
    }

    @Override
    public int indexAfter(IData<?> data) {
        return indexAfter(data != null ? data.get() : null);
    }

    @Override
    public int indexAfter(CharSequence data) {
        return data != null && contains(data) ? this.data.indexOf(data.toString()) + data.length() : -1;
    }


    @Override
    public D getData() {
        return (D) this;
    }

    @Override
    public <O> boolean contains(O data) {
        return contains(data != null ? data.toString() : "");
    }

    @Override
    public boolean contains(IData<?> data) {
        return contains(data + "");
    }

    @Override
    public boolean contains(CharSequence data) {
        return data != null && this.data.contains(data);
    }

    @Override
    public <O> int comparesTo(O data) {
        return comparesTo(String.valueOf(data));
    }

    @Override
    public int comparesTo(IData<?> data) {
        return comparesTo(data != null ? data.get() : "");
    }

    @Override
    public int comparesTo(CharSequence data) {
        return this.data.compareTo(data.toString());
    }

    @Override
    public boolean equals(IData<?> another) {
        return another != null && another.getClass().equals(getClass()) && equalsIgnoreType(another) && another.getType().equals(getType());
    }

    @Override
    public boolean equalsIgnoreCase(IData<?> another) {
        return another != null && equalsIgnoreCase(another.get());
    }

    @Override
    public boolean equalsIgnoreCase(CharSequence another) {
        return another != null && data.equalsIgnoreCase(another.toString());
    }

    @Override
    public boolean equalsIgnoreType(IData<?> another) {
        return another != null && equalsIgnoreType(another.get());
    }

    @Override
    public boolean equalsIgnoreType(CharSequence another) {
        return another != null && data.contentEquals(another);
    }

    @Override
    public String toString() {
        return data;
    }

}
