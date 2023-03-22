package nx.peter.java.util.data;

import java.io.Serializable;

public interface IData<D extends IData> extends CharSequence, Comparable<D>, Serializable {
    D reset();

    D set(D data);

    D set(char... data);

    D set(CharSequence data);

    D set(int index, char... data);

    D set(int index, CharSequence data);

    int count(char data);

    int count(long data);

    int count(int data);

    int count(boolean data);

    int count(double data);

    int count(IData<?> data);

    int count(CharSequence data);

    String get();

    D getData();

    int length();

    <O> D append(O data);

    D append(IData<?> data);

    D append(CharSequence data);

    <O> D append(O data, int index);

    D append(IData<?> data, int index);

    D append(CharSequence data, int index);

    <O> int indexOf(O data);

    int indexOf(IData<?> data);

    int indexOf(CharSequence data);

    <O> int indexOf(O data, int start);

    int indexOf(IData<?> data, int start);

    int indexOf(CharSequence data, int start);

    <O> int indexBefore(O data);

    int indexBefore(IData<?> data);

    int indexBefore(CharSequence data);

    <O> int indexAfter(O data);

    int indexAfter(IData<?> data);

    int indexAfter(CharSequence data);

    DataType getType();

    boolean isEmpty();

    boolean isNotEmpty();

    boolean isWord();

    boolean isTexts();

    boolean isParagraph();

    boolean isLine();

    boolean isIndex();

    boolean isAlphabet();

    boolean isAlphabet(CharSet charSet);

    boolean isCharacter();

    boolean isFraction();

    boolean isLetter();

    boolean isLetters();

    boolean isNumber();

    boolean isSentence();

    boolean isValid();

    <O> boolean contains(O data);

    boolean contains(IData<?> data);

    boolean contains(CharSequence data);

    <A extends IData> A castTo(Class<A> clazz);

    <O> int comparesTo(O data);

    int comparesTo(IData<?> data);

    int comparesTo(CharSequence data);

    boolean equals(IData<?> another);

    boolean equalsIgnoreCase(IData<?> another);

    boolean equalsIgnoreCase(CharSequence another);

    boolean equalsIgnoreType(IData<?> another);

    boolean equalsIgnoreType(CharSequence another);

    enum DataType {
        Alphabet,
        Character,
        Fraction,
        Index,
        Letter,
        Line,
        Number,
        Operator,
        Others,
        Sentence,
        Subscript,
        Superscript,
        Texts,
        Paragraph,
        Word
    }

    enum CharSet {
        English,
        Latin
    }

    interface OnFinishedLoadingListener<P> {
        void onFinishedLoading(P data);
    }

}
