package nx.peter.java.util.data;

import nx.peter.java.dictionary.Dictionary;
import nx.peter.java.dictionary.LatinDictionary;
import nx.peter.java.util.Util;
import nx.peter.java.io.File;
import nx.peter.java.io.FileManager;

import java.util.ArrayList;
import java.util.List;

public class LoremIpsum {
    protected List<Paragraph> paragraphs, intParagraphs;
    protected List<Sentence> sentences;
    protected List<Line> lines;
    protected String lorem;

    private LoremIpsum() {
        initParagraphs();
    }

    public static LoremIpsum getInstance() {
        return new LoremIpsum();
    }

    private void initParagraphs() {
        lorem = "";
        this.lines = new ArrayList<>();
        paragraphs = new ArrayList<>();
        List<String> lines = FileManager.readLines(File.FILES_FOLDER + "dictionary/lorem_texts.txt");
        for (int line = 0; line < lines.size() / 2; line += 2) {
            Paragraph paragraph = new Paragraph(lines.get(line));
            lorem += lines.get(line);
            if (line < lines.size() - 2) lorem += "\n";
            paragraphs.add(paragraph);
        }
        sentences = getParagraphs().getSentences().getSentences();

        int line = 0;
        for (Sentence sentence : sentences)
            this.lines.add(new Line(++line, sentence.get()));
    }

    public Line getLine(int line) {
        return getLines().getLine(line);
    }

    public Paragraph getParagraph(int paragraph) {
        return paragraph > 0 && paragraph <= getParagraphCount() ? paragraphs.get(paragraph - 1) : new Paragraph();
    }

    public Texts.Paragraphs getParagraphs() {
        return new Texts.Paragraphs(getLoremText(), paragraphs);
    }

    public Texts getLoremText() {
        return new Texts(lorem);
    }

    public Texts.Paragraphs getParagraphs(int start, int end) {
        Util.MinMax<Integer> m = new Util.MinMax<>(start, end);
        List<Paragraph> paragraphs = new ArrayList<>();
        if (m.min() > 0 && m.isUnequal() && m.max() <= getParagraphCount())
            for (int i = m.min(); i <= m.max(); i++)
                paragraphs.add(getParagraph(i));
        return new Texts.Paragraphs(getLoremText(), paragraphs);
    }

    public int getParagraphCount() {
        return paragraphs.size();
    }

    public Texts.Lines getLines() {
        return new Texts.Lines(getLoremText(), lines);
    }

    public int getLineCount() {
        return getLines().size();
    }

    public Texts.Sentences getSentences() {
        return new Texts.Sentences(getLoremText(), sentences);
    }

    public Texts.Sentences getSentences(int start, int end) {
        Util.MinMax<Integer> m = new Util.MinMax<>(start, end);
        List<Sentence> sentences = new ArrayList<>();
        if (m.min() > 0 && m.isUnequal() && m.max() <= getSentenceCount())
            for (int i = m.min(); i <= m.max(); i++)
                sentences.add(getSentence(i));
        return new Texts.Sentences(getLoremText(), sentences);
    }

    public int getSentenceCount() {
        return getSentences().size();
    }

    public Sentence getSentence(int sentence) {
        return getSentences().getSentence(sentence);
    }


    public Texts.Words getWords() {
        List<Word> words = new ArrayList<>();
        for (Paragraph p : paragraphs)
            words.addAll(p.extractWords().toList());
        return new Texts.Words(words, getTexts());
    }

    public Texts.Words getWords(int start, int end) {
        Util.MinMax<Integer> m = new Util.MinMax<>(start, end);
        List<Word> words = new ArrayList<>();
        if (m.min() > 0 && m.isUnequal() && m.max() <= getSentenceCount())
            words.addAll(getLoremText().extractWords().toList());
        return new Texts.Words(probe(words), getTexts());
    }

    protected List<Word> probe(List<Word> words) {
        List<Word> temp = new ArrayList<>();
        for (Word word : words)
            if (!temp.contains(word)) temp.add(word);
        temp.sort((a, b) -> {
            Word aTemp = new Word(a.get()).toLowerCase();
            Word bTemp = new Word(b.get()).toLowerCase();
            return aTemp.comparesTo(bTemp);
        });
        return temp;
    }

    public Dictionary getDictionary() {
        return new IDictionary();
    }

    public int getWordCount() {
        return getWords().size();
    }

    public Word getWord(int position) {
        return getWords().get(position);
    }


    public Texts getTexts() {
        return new Texts(lorem);
    }

    public boolean contains(IData<?> data) {
        return contains(data != null ? data.get() : null);
    }

    public boolean contains(CharSequence data) {
        if (data != null)
            for (Paragraph p : paragraphs)
                if (p.contains(data))
                    return true;
        return false;
    }

    @Override
    public String toString() {
        return getLoremText().get();
    }

    protected static class IDictionary extends Dictionary.Builder {
        public IDictionary() {
            super(Type.LoremIpsum);
        }
    }

}
