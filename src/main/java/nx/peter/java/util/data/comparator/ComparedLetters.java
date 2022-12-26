package nx.peter.java.util.data.comparator;

import nx.peter.java.util.data.Letter;
import nx.peter.java.util.data.Letters;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComparedLetters implements Iterable<ComparedLetter> {
    protected List<ComparedLetter> comparedLetters;
    protected boolean isAlmostEqual;

    public ComparedLetters() {
        this("", "", true);
    }

    public ComparedLetters(CharSequence letter1, CharSequence letter2, boolean isAlmostEqual) {
        this(isAlmostEqual ? getAlmostEquals(letter1, letter2).getComparedLetters().list() : getEquals(letter1, letter2).getComparedLetters().list(), isAlmostEqual);
    }

    public ComparedLetters(Letters<?> letters1, Letters<?> letters2, boolean isAlmostEqual) {
        this(letters1 != null ? letters1.get() : "", letters2 != null ? letters2.get() : "", isAlmostEqual);
    }

    public ComparedLetters(List<ComparedLetter> letters, boolean isAlmostEqual) {
        comparedLetters = letters != null ? letters : new ArrayList<>();
        this.isAlmostEqual = isAlmostEqual;
    }

    public boolean contains(Letter<?> letter) {
        for (ComparedLetter cLetter : comparedLetters)
            if (cLetter.contains(letter))
                return true;
        return false;
    }

    public boolean contains(char letter) {
        return contains(new Letter<>(letter));
    }

    public boolean contains(ComparedLetter letter) {
        for (ComparedLetter cLetter : comparedLetters)
            if (cLetter.equals(letter))
                return true;
        return false;
    }

    public int size() {
        return comparedLetters.size();
    }

    public ComparedLetter get(int index) {
        return index >= 0 && index < size() ? comparedLetters.get(index) : null;
    }

    public int indexOf(Letter<?> letter) {
        for (int index = 0; index < size(); index++)
            if (get(index).contains(letter))
                return index;
        return -1;
    }

    public IComparedLetters getComparedLetters() {
        List<ComparedLetter> letters = new ArrayList<>(comparedLetters);
        return new IComparedLetters() {
            @Override
            public int size() {
                return letters.size();
            }

            @Override
            public ComparedLetter getLast() {
                return size() > 0 ? letters.get(size() - 1) : new ComparedLetter();
            }

            @Override
            public ComparedLetter getFirst() {
                return size() > 0 ? letters.get(0) : new ComparedLetter();
            }

            @Override
            public int indexOf(ComparedLetter comparedLetter) {
                return letters.indexOf(comparedLetter);
            }

            @Override
            public int indexOf(char letter1, char letter2) {
                return indexOf(letter1, letter2, 0);
            }

            @Override
            public int indexOf(Letter<?> letter1, Letter<?> letter2) {
                return indexOf(letter1, letter2, 0);
            }

            @Override
            public int indexOf(char letter1, char letter2, int start) {
                return indexOf(new Letter<>(letter1), new Letter<>(letter2), start);
            }

            @Override
            public int indexOf(Letter<?> letter1, Letter<?> letter2, int start) {
                int index = 0;
                for (ComparedLetter letter : letters)
                    if (letter.equalData(letter1, letter2) && letter.data1.getIndex() >= start && letter.data2.getIndex() >= start)
                        return index;
                    else index++;
                return -1;
            }

            @Override
            public boolean contains(ComparedLetter comparedLetter) {
                return letters.contains(comparedLetter);
            }

            @Override
            public boolean contains(char letter1, char letter2) {
                return contains(new Letter<>(letter1), new Letter<>(letter2));
            }

            @Override
            public boolean contains(Letter<?> letter1, Letter<?> letter2) {
                for (ComparedLetter letter : letters)
                    if (letter.equalData(letter1, letter2))
                        return true;
                return false;
            }

            @Override
            public IComparedLetters sort() {
                letters.sort(ComparedData::compareTo);
                return this;
            }

            @Override
            public List<ComparedLetter> list() {
                return new ArrayList<>(letters);
            }

            @Override
            public boolean equals(IComparedLetters another) {
                return another != null && another.list().equals(letters);
            }

            @Override
            public Iterator<ComparedLetter> iterator() {
                return letters.iterator();
            }

            @Override
            public String toString() {
                return letters.toString();
            }
        };
    }

    @Override
    public Iterator<ComparedLetter> iterator() {
        return comparedLetters.iterator();
    }

    @Override
    public String toString() {
        return "{" +
                "\"comparedLetters\": " + comparedLetters.toString() +
                "], \"isAlmostEqual\": " + isAlmostEqual +
                '}';
    }

    public static ComparedLetters getEquals(CharSequence letters1, CharSequence letters2) {
        if (letters1 == null || letters2 == null)
            return new ComparedLetters();
        List<ComparedLetter> cLetters = new ArrayList<>();
        for (int index1 = 0; index1 < letters1.length(); index1++)
            for (int index2 = 0; index2 < letters2.length(); index2++) {
                ComparedLetter compared = new ComparedLetter(letters1.toString().charAt(index1), index1, letters2.toString().charAt(index2), index2);
                if (compared.isEqual())
                    cLetters.add(compared);
            }
        return new ComparedLetters(cLetters, false);
    }

    public static ComparedLetters getEquals(Letters<?> letters1, Letters<?> letters2) {
        return getEquals(letters1 != null ? letters1.get() : null, letters2 != null ? letters2.get() : null);
    }

    public static ComparedLetters getAlmostEquals(CharSequence letters1, CharSequence letters2) {
        if (letters1 == null || letters2 == null)
            return new ComparedLetters();
        List<ComparedLetter> cLetters = new ArrayList<>();
        for (int index1 = 0; index1 < letters1.length(); index1++)
            for (int index2 = 0; index2 < letters2.length(); index2++) {
                ComparedLetter compared = new ComparedLetter(letters1.toString().charAt(index1), index1, letters2.toString().charAt(index2), index2);
                if (compared.isAlmostEqual())
                    cLetters.add(compared);
            }
        return new ComparedLetters(cLetters, true);
    }

    public static ComparedLetters getAlmostEquals(Letters<?> letters1, Letters<?> letters2) {
        return getAlmostEquals(letters1 != null ? letters1.get() : null, letters2 != null ? letters2.get() : null);
    }


    public interface IComparedLetters extends Iterable<ComparedLetter> {
        int size();

        ComparedLetter getLast();

        ComparedLetter getFirst();

        int indexOf(ComparedLetter comparedLetter);

        int indexOf(char letter1, char letter2);

        int indexOf(Letter<?> letter1, Letter<?> letter2);

        int indexOf(char letter1, char letter2, int start);

        int indexOf(Letter<?> letter1, Letter<?> letter2, int start);

        boolean contains(ComparedLetter comparedLetter);

        boolean contains(char letter1, char letter2);

        boolean contains(Letter<?> letter1, Letter<?> letter2);

        IComparedLetters sort();

        List<ComparedLetter> list();

        boolean equals(IComparedLetters another);
    }

}
