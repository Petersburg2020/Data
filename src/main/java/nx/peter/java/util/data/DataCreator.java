package nx.peter.java.util.data;

import java.util.Objects;

public class DataCreator {
    private DataCreator() {}

    public static <D extends IData> D createData(Class<D> clazz, CharSequence source) {
        return createData(clazz, source, IData.CharSet.English);
    }

    public static <D extends IData> D createData(Class<D> clazz, CharSequence source, IData.CharSet charSet) {
        return clazz.equals(Sentence.class) ? (D) new Sentence(charSet, source) :
                clazz.equals(Paragraph.class) ? (D) new Paragraph(charSet, source) :
                        clazz.equals(Texts.class) ? (D) new Texts(charSet, source) :
                                clazz.equals(Word.class) ? (D) new Word(charSet, source) :
                                        clazz.equals(Line.class) ? (D) new Line(1, source) :
                                                clazz.equals(Number.class) ? (D) new Number(source) :
                                                        clazz.equals(Operator.class) ? (D) new Operator(source) :
                                                                clazz.equals(Subscript.class) ? (D) new Subscript(source) :
                                                                        clazz.equals(Superscript.class) ? (D) new Subscript(source) :
                                                                                clazz.equals(Alphabet.class) ? (D) new Alphabet(charSet, source) :
                                                                                        clazz.equals(Character.class) ? (D) new Character(source) :
                                                                                                clazz.equals(FractionData.class) ? (D) new FractionData(source) :
                                                                                                        clazz.equals(Index.class) ? (D) new Index(source) : null;
    }

    public static <S extends ISentence> S createSentence(Class<S> clazz, CharSequence source) {
        return createLetters(clazz, source);
    }

    public static <S extends ISentence> S createSentence(Class<S> clazz, CharSequence source, IData.CharSet charSet) {
        return createLetters(clazz, source, charSet);
    }

    public static <L extends Letters> L createLetters(Class<L> clazz, CharSequence source) {
        return createData(clazz, source);
    }

    public static <L extends Letters> L createLetters(Class<L> clazz, CharSequence source, IData.CharSet charSet) {
        return createData(clazz, source, charSet);
    }

    public static <L extends Letter> L createLetter(Class<L> clazz, CharSequence source) {
        return createData(clazz, source);
    }

    public static <L extends Letter> L createLetter(Class<L> clazz, CharSequence source, IData.CharSet charSet) {
        return createData(clazz, source, charSet);
    }

    public static Alphabet createAlphabet(CharSequence source) {
        return createLetter(Alphabet.class, source);
    }

    public static Alphabet createAlphabet(IData.CharSet charSet, CharSequence source) {
        return createLetter(Alphabet.class, source, charSet);
    }

    public static Index createIndex(CharSequence source) {
        return createData(Index.class, source, null);
    }

    public static FractionData createFraction(CharSequence source) {
        return createData(FractionData.class, source, null);
    }

    public static Sentence createSentence(CharSequence source) {
        return createSentence(Sentence.class, source);
    }

    public static Sentence createSentence(IData.CharSet charSet, CharSequence source) {
        return createSentence(Sentence.class, source, charSet);
    }

    public static Character createCharacter(CharSequence source) {
        return createLetter(Character.class, source, null);
    }

    public static Operator createOperator(CharSequence source) {
        return createData(Operator.class, source, null);
    }

    public static Subscript createSubscript(CharSequence source) {
        return createData(Subscript.class, source, null);
    }

    public static Superscript createSuperscript(CharSequence source) {
        return createData(Superscript.class, source, null);
    }

    public static Paragraph createParagraph(CharSequence source) {
        return createSentence(Paragraph.class, source);
    }

    public static Paragraph createParagraph(IData.CharSet charSet, CharSequence source) {
        return createSentence(Paragraph.class, source, charSet);
    }

    public static Texts createText(CharSequence source) {
        return createSentence(Texts.class, source);
    }

    public static Texts createText(IData.CharSet charSet, CharSequence source) {
        return createSentence(Texts.class, source, charSet);
    }

    public static Word createWord(CharSequence source) {
        return createLetters(Word.class, source);
    }

    public static Word createWord(IData.CharSet charSet, CharSequence source) {
        return createLetters(Word.class, source, charSet);
    }

    public static Line createLine(int line, CharSequence source) {
        return Objects.requireNonNull(createData(Line.class, source, null)).setNumber(line);
    }


}
