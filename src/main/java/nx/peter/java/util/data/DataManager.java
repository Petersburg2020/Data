package nx.peter.java.util.data;

import nx.peter.java.util.data.comparator.ComparedLetters;
import nx.peter.java.util.param.IntString;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class DataManager {
    public static final String ALPHABETS_ENGLISH = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static final String ALPHABETS_LATIN = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZĀĒĪŌŪaābcdeēfghiījklmnoōpqrstuūvwxyz".getBytes(StandardCharsets.UTF_8));

    public static final String AA = "ĀāAa";
    public static final String EE = "ĒēEe";
    public static final String II = "ĪīIi";
    public static final String OO = "ŌōOo";
    public static final String UU = "ŪūUu";

    public static final String NUMBERS = "1234567890";
    public static final String CHARACTERS = "{}();.,-∅_+!?/#$@*~`|•√π÷×¶∆=°^¥€¢£%©®™✓[]><\"⁻ᵐ’‘‹›«»„“”¡¿\\←↑↓→ΩΠμ§ⁿ':";

    public static final String SPECIAL_CHARACTERS = "@$&_©®™£€¥¢#";
    public static final String FRACTIONS = "⅙⅐⅛⅑⅒½⅓¼⅕⅔⅖⅗¾⅜⅘⅝⅚⅞";
    public static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    public static final String VOWELS_ENGLISH = "AEIOUaeiou";
    public static final String VOWELS_LATIN = "ĀĒĪŌŪAEIOUāēīōūaeiou";
    public static final String CONSONANTS = "BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz";

    public static final String OPERATORS = "-+*÷×/";

    public static final String OPERATOR_PLUS = "+";
    public static final String OPERATOR_MINUS = "-";
    public static final String OPERATOR_TIMES = "×";
    public static final String OPERATOR_DIVIDE = "÷";

    public static final String EQUALITY_NOT_EQUAL_TO = "≠";
    public static final String EQUALITY_EQUAL_TO = "=";
    public static final String EQUALITY_ALMOST_EQUAL_TO = "≈";
    public static final String EQUALITY_IDENTICAL_TO = "≡";
    public static final String EQUALITY_NOT_IDENTICAL_TO = "≢";
    public static final String EQUALITY_GREATER_EQUAL_TO = "≥";
    public static final String EQUALITY_LESS_EQUAL_TO = "≤";
    public static final String EQUALITY_LESS_THAN = "<";
    public static final String EQUALITY_GREATER_THAN = ">";
    public static final String EQUALITY_NOT_LESS_THAN = "≮";
    public static final String EQUALITY_NOT_GREATER_THAN = "≯";
    public static final String EQUALITY_NOT_GREATER_EQUAL_TO = "≱";
    public static final String EQUALITY_NOT_LESS_EQUAL_TO = "≰";

    public static final String INTEGRAL = "∫";
    public static final String MATH_EPSILON = "∑";

    public static final String ROOT = "√";
    public static final String ROOT_4 = "∜";
    public static final String ROOT_3 = "∛";
    public static final String INDEXES = "¹²³⁴⁵⁶⁷⁸⁹⁰";
    public static final String INDEX_CHARACTERS = "⁾⁺⁽⁻⁼";
    public static final String INDEX_OPERATORS = "⁺⁻";
    public static final String INDEX_VARIABLES = "ᵃᵇᶜᵈᵉᶠᵍʰⁱʲᵏˡᵐⁿᵒᵖʳˢᵗᵘᵛʷˣʸᶻᵂⱽᵁᵀᴿᴾᴼᴺᴹᴸᴷᴶᴵᴴᴳᴱᴰᴮᴬ";

    public static final String SUPERSCRIPT_SPECIALS = "ᵝᶷᶿᶲᶮᶯᶞᵟᵑᵆ";
    public static final String SUPERSCRIPTS = INDEXES + INDEX_CHARACTERS + INDEX_VARIABLES + SUPERSCRIPT_SPECIALS;

    public static final String SUBSCRIPTS = "₀₁₂₃₄₅₆₇₈₉";
    public static final String SUBSCRIPT_VARIABLES = "ₐₑₒₓₔᵣᵤᵥᵦᵨᵩ";
    public static final String SUBSCRIPT_CHARACTERS = "₎₍₊₌₋";
    public static final String SUBSCRIPT_OPERATORS = "₊₋";
    public static final String SUBSCRIPTS_ALL = SUBSCRIPTS + SUBSCRIPT_CHARACTERS + SUBSCRIPT_VARIABLES;

    public static final String SET_NULL_SET = "∅";
    public static final String SET_ELEMENT_OF = "∈";
    public static final String SET_NOT_ELEMENT_OF = "∉";
    public static final String SET_MEMBER_OF = "∋";
    public static final String SET_NOT_MEMBER_OF = "∌";
    public static final String SET_INTERSECTION = "∩";
    public static final String SET_UNION = "∪";
    public static final String SET_NOT_INTERSECTION = "∩";
    public static final String SET_NOT_UNION = "∪";
    public static final String SET_SUBSET_OF = "⊂";
    public static final String SET_SUPERSET_OF = "⊃";
    public static final String SET_NOT_SUBSET_OF = "⊄";
    public static final String SET_NOT_SUPERSET_OF = "⊅";
    public static final String SET_SUBSET_OF_EQUAL_TO = "⊆";
    public static final String SET_SUPERSET_OF_EQUAL_TO = "⊇";
    public static final String SET_NOT_SUBSET_OF_EQUAL_TO = "⊈";
    public static final String SET_NOT_SUPERSET_OF_EQUAL_TO = "⊉";
    public static final String SET_MINUS = "∖";
    public static final String SET_COMPLEMENT = "∁";

    public static final String SET_SYMBOLS = SET_MINUS + SET_COMPLEMENT + SET_UNION + SET_NOT_UNION
            + SET_INTERSECTION + SET_ELEMENT_OF + SET_NOT_ELEMENT_OF + SET_NOT_INTERSECTION
            + SET_MEMBER_OF + SET_NOT_MEMBER_OF + SET_NOT_SUBSET_OF + SET_SUBSET_OF + SET_SUPERSET_OF
            + SET_NOT_SUPERSET_OF + SET_SUPERSET_OF_EQUAL_TO + SET_NOT_SUPERSET_OF_EQUAL_TO
            + SET_SUBSET_OF_EQUAL_TO + SET_NOT_SUBSET_OF_EQUAL_TO + SET_NULL_SET;

    public static final String ANGLE_DIAMETER = "⌀";
    public static final String ANGLE_ANGLE = "∠";
    public static final String ANGLE_MEASURED_ANGLE = "∡";
    public static final String ANGLE_SPHERICAL_ANGLE = "∢";
    public static final String ANGLE_RIGHT_ANGLE = "⦜";
    public static final String ANGLE_ACUTE_ANGLE = "⦟";
    public static final String ANGLE_DEGREE = "°";
    public static final String ANGLE_PARALLEL_TO = "∥";
    public static final String ANGLE_NOT_PARALLEL_TO = "∦";
    public static final String ANGLE_PERPENDICULAR = "⟂";

    public static final String ANGLE_SYMBOLS = ANGLE_ANGLE + ANGLE_ACUTE_ANGLE + ANGLE_SPHERICAL_ANGLE
            + ANGLE_DEGREE + ANGLE_DIAMETER + ANGLE_MEASURED_ANGLE + ANGLE_NOT_PARALLEL_TO
            + ANGLE_RIGHT_ANGLE + ANGLE_PARALLEL_TO + ANGLE_PERPENDICULAR;


    public static boolean equalsIgnoreCaseAlphabet(char comparator, char letter) {
        return equalsIgnoreCaseAlphabet(comparator, letter + "");
    }

    public static boolean equalsIgnoreCaseAlphabet(char comparator, CharSequence letter) {
        return equalsIgnoreCaseAlphabet(comparator + "", letter);
    }

    public static boolean equalsIgnoreCaseAlphabet(CharSequence comparator, char letter) {
        return equalsIgnoreCaseAlphabet(comparator, letter + "");

    }

    public static boolean equalsIgnoreCaseAlphabet(CharSequence comparator, CharSequence letter) {
        if (letter != null && letter.length() == 1 && comparator != null && comparator.length() == 1)
            return equalsAlphabet(comparator.toString().toLowerCase(), letter.toString().toLowerCase());
        return false;
    }

    public static boolean equalsAlphabet(char comparator, char letter) {
        return equalsAlphabet(comparator, letter + "");
    }

    public static boolean equalsAlphabet(char comparator, CharSequence letter) {
        return equalsAlphabet(comparator + "", letter);
    }

    public static boolean equalsAlphabet(CharSequence comparator, char letter) {
        return equalsAlphabet(comparator, letter + "");

    }

    public static boolean equalsAlphabet(CharSequence comparator, CharSequence letter) {
        if (letter != null && letter.length() == 1 && comparator != null && comparator.length() == 1) {
            String l = letter.toString();
            String comp = comparator.toString();
            switch (l) {
                case "a":
                    return comp.contentEquals("ā") || l.contentEquals(comp);
                case "e":
                    return comp.contentEquals("ē") || l.contentEquals(comp);
                case "i":
                    return comp.contentEquals("ī") || l.contentEquals(comp);
                case "o":
                    return comp.contentEquals("ō") || l.contentEquals(comp);
                case "u":
                    return comp.contentEquals("ū") || l.contentEquals(comp);
                case "ā":
                    return comp.contentEquals("a") || l.contentEquals(comp);
                case "ē":
                    return comp.contentEquals("e") || l.contentEquals(comp);
                case "ī":
                    return comp.contentEquals("i") || l.contentEquals(comp);
                case "ō":
                    return comp.contentEquals("o") || l.contentEquals(comp);
                case "ū":
                    return comp.contentEquals("u") || l.contentEquals(comp);
                default: return l.contentEquals(comp);
            }
        }
        return false;
    }



    public static boolean isSubscript(char letter) {
        return isSubscript(letter + "");
    }

    public static boolean isSubscript(CharSequence letter) {
        if (letter != null && letter.length() == 1)
            return SUBSCRIPTS_ALL.contains(letter);
        return false;
    }


    public static boolean isSubscriptCharacter(char letter) {
        return isSubscriptCharacter(letter + "");
    }

    public static boolean isSubscriptCharacter(CharSequence letter) {
        if (letter != null && letter.length() == 1)
            return SUBSCRIPT_CHARACTERS.contains(letter);
        return false;
    }


    public static boolean isSubscriptOperator(char letter) {
        return isSubscriptOperator(letter + "");
    }

    public static boolean isSubscriptOperator(CharSequence letter) {
        if (letter != null && letter.length() == 1)
            return SUBSCRIPT_OPERATORS.contains(letter);
        return false;
    }


    public static boolean isSubscriptVariable(char letter) {
        return isSubscriptVariable(letter + "");
    }

    public static boolean isSubscriptVariable(CharSequence letter) {
        if (letter != null && letter.length() == 1)
            return SUBSCRIPT_VARIABLES.contains(letter);
        return false;
    }


    public static boolean isSuperscript(char letter) {
        return isSuperscript(letter + "");
    }

    public static boolean isSuperscript(CharSequence letter) {
        if (letter != null && letter.length() == 1)
            return SUPERSCRIPTS.contains(letter);
        return false;
    }


    public static boolean isSuperscriptCharacter(char letter) {
        return isSuperscriptCharacter(letter + "");
    }

    public static boolean isSuperscriptCharacter(CharSequence letter) {
        if (letter != null && letter.length() == 1)
            return INDEX_CHARACTERS.contains(letter);
        return false;
    }


    public static boolean isSuperscriptOperator(char letter) {
        return isSuperscriptOperator(letter + "");
    }

    public static boolean isSuperscriptOperator(CharSequence letter) {
        if (letter != null && letter.length() == 1)
            return INDEX_OPERATORS.contains(letter);
        return false;
    }


    public static boolean isSuperscriptVariable(char letter) {
        return isSuperscriptVariable(letter + "");
    }

    public static boolean isSuperscriptVariable(CharSequence letter) {
        if (letter != null && letter.length() == 1)
            return INDEX_VARIABLES.contains(letter);
        return false;
    }


    public static boolean isAlphabet(char letter) {
        return isAlphabet(Alphabet.CharSet.English, letter);
    }

    public static boolean isAlphabet(Alphabet.CharSet charSet, char letter) {
        return isAlphabet(charSet, letter + "");
    }

    public static boolean isAlphabet(CharSequence letter) {
        return isAlphabet(Alphabet.CharSet.English, letter);
    }

    public static boolean isAlphabet(Alphabet.CharSet charSet, CharSequence letter) {
        if (letter != null && letter.length() == 1 && charSet != null)
            switch (charSet) {
                case English:
                    return ALPHABETS_ENGLISH.contains(letter.toString());
                case Latin:
                    return ALPHABETS_LATIN.contains(letter.toString());
            }
        return false;
    }

    public static boolean isConsonant(char letter) {
        return isConsonant(letter + "");
    }

    public static boolean isConsonant(CharSequence letter) {
        if (letter != null && letter.length() == 1)
            return CONSONANTS.contains(letter);
        return false;
    }

    public static boolean isOperator(char letter) {
        return isOperator(letter + "");
    }

    public static boolean isOperator(CharSequence letter) {
        if (letter != null && letter.length() == 1)
            return OPERATORS.contains(letter);
        return false;
    }

    public static boolean isVowel(char letter) {
        return isVowel(Alphabet.CharSet.English, letter);
    }

    public static boolean isVowel(Alphabet.CharSet charSet, char letter) {
        return isVowel(charSet,letter + "");
    }

    public static boolean isVowel(CharSequence letter) {
        return isVowel(Alphabet.CharSet.English, letter);
    }

    public static boolean isVowel(Alphabet.CharSet charSet, CharSequence letter) {
        if (letter != null && letter.length() == 1 && charSet != null)
            switch (charSet) {
                case English:
                    return VOWELS_ENGLISH.contains(letter);
                case Latin:
                    return VOWELS_LATIN.contains(letter);
            }
        return false;
    }

    public static boolean isLetter(char letter) {
        return isLetter(IData.CharSet.English, letter);
    }

    public static boolean isLetter(IData.CharSet charSet, char letter) {
        return isLetter(charSet, letter + "");
    }

    public static boolean isLetter(CharSequence letter) {
        return isLetter(IData.CharSet.English, letter);
    }

    public static boolean isLetter(IData.CharSet charSet, CharSequence letter) {
        return isIndex(letter) || isAlphabet(charSet, letter) || isCharacter(letter) || isSpecialCharacter(letter)
                || isFraction(letter) || isOperator(letter) || isNumber(letter);
    }

    public static boolean isNonLetter(char letter) {
        return !isNonLetter(letter + "");
    }

    public static boolean isNonLetter(CharSequence letter) {
        return letter.length() == 1 && !isLetter(letter);
    }

    public static boolean isUpperCase(char letter) {
        return isUpperCase(letter + "");
    }

    public static boolean isUpperCase(CharSequence letter) {
        if (letter.length() == 1)
            return UPPER_CASE.contains(letter);
        return false;
    }

    public static boolean isLowerCase(char letter) {
        return isLowerCase(letter + "");
    }

    public static boolean isLowerCase(CharSequence letter) {
        if (letter.length() == 1)
            return LOWER_CASE.contains(letter);
        return false;
    }


    public static boolean isCharacter(char letter) {
        return isCharacter(letter + "");
    }

    public static boolean isCharacter(CharSequence letter) {
        if (letter.length() == 1)
            return CHARACTERS.contains(letter);
        return false;
    }


    public static boolean isSpecialCharacter(char letter) {
        return isSpecialCharacter(letter + "");
    }

    public static boolean isSpecialCharacter(CharSequence letter) {
        if (letter.length() == 1)
            return SPECIAL_CHARACTERS.contains(letter);
        return false;
    }


    public static boolean isIndex(CharSequence letter) {
        if (letter != null && letter.length() == 1)
            return INDEXES.contains(letter);
        return false;
    }

    public static boolean isIndex(char letter) {
        return isIndex(letter + "");
    }

    public static boolean isFraction(char letter) {
        return isFraction(letter + "");
    }

    public static boolean isFraction(CharSequence letter) {
        if (letter.length() == 1)
            return FRACTIONS.contains(letter);
        return false;
    }

    public static boolean isNumber(char letter) {
        return isNumber(letter + "");
    }

    public static boolean isBool(CharSequence letter) {
        return letter.equals("true") || letter.equals("false");
    }

    public static String tab(int indents) {
        return "\t".repeat(Math.max(0, indents));
    }

    public static boolean isInteger(char letter) {
        return isInteger(letter + "");
    }

    public static boolean isLong(CharSequence letters) {
        if (extractDoubles(letters).size() == 1) {
            double num = extractDoubles(letters).get(0);
            return ((long) num) == num;
        }
        return false;
    }

    public static boolean isFloat(CharSequence letters) {
        if (extractDoubles(letters).size() == 1) {
            double num = extractDoubles(letters).get(0);
            return ((float) num) == num;
        }
        return false;
    }

    public static boolean isIndexes(CharSequence letters) {
        if (new Word(letters).count('.') > 1)
            return false;
        for (char c : letters.toString().toCharArray())
            if (c != '.' && !isIndex(c))
                return false;
        return true;
    }

    public static boolean isNumber(CharSequence letter) {
        if (letter.length() == 1)
            return NUMBERS.contains(letter);
        return false;
    }

    public static boolean isNumberOnly(CharSequence letters) {
        List<Double> doubles = extractDoubles(letters);
        return doubles.size() == 1 && (isInteger(letters) ?
                String.valueOf((int) (double) doubles.get(0)).contentEquals(letters) : String.valueOf((double) doubles.get(0)).contentEquals(letters));
    }

    public static boolean isInteger(CharSequence letters) {
        List<Double> doubles = extractDoubles(letters);
        return doubles.size() == 1 && doubles.get(0) == (int) (double) doubles.get(0);
    }

    public static String toAlphabet(int number) {
        return number > 0 && number <= UPPER_CASE.length() ? UPPER_CASE.charAt(number - 1) + "" : "";
    }

    public static int toNumber(char alphabet) {
        return isAlphabet(alphabet) ? UPPER_CASE.indexOf(alphabet + "") : 0;
    }

    public static int toNumber(CharSequence alphabet) {
        return isAlphabet(alphabet) ? UPPER_CASE.indexOf(alphabet.toString()) : 0;
    }

    public static int alphabetCount(CharSequence letters) {
        int count = 0;
        if (letters.length() == 1)
            for (char letter : letters.toString().toCharArray())
                if (isAlphabet(letter))
                    count++;
        return count;
    }

    public static int getNumberOfAlmostEqualLetters(CharSequence letters1, CharSequence letters2) {
        return getAlmostEqualLetters(letters1, letters2).size();
    }

    public static ComparedLetters getAlmostEqualLetters(CharSequence letters1, CharSequence letters2) {
        return ComparedLetters.getAlmostEquals(letters1, letters2);
    }

    public static int getNumberOfEqualLetters(CharSequence letters1, CharSequence letters2) {
        return getEqualLetters(letters1, letters2).size();
    }

    public static ComparedLetters getEqualLetters(CharSequence letters1, CharSequence letters2) {
        return ComparedLetters.getEquals(letters1, letters2);
    }


    public static List<Alphabet> extractAlphabets(CharSequence letters) {
        List<Alphabet> alphabets = new ArrayList<>();
        for (IntString property : getProperties(letters))
            if (isAlphabet(property.letter))
                alphabets.add(new Alphabet(property.letter));
        return alphabets;
    }

    public static List<Character> extractCharacters(CharSequence letters) {
        List<Character> characters = new ArrayList<>();
        for (IntString property : getProperties(letters))
            if (isCharacter(property.letter))
                characters.add(new Character(property.letter));
        return characters;
    }

    public static List<Boolean> extractBools(CharSequence letters) {
        List<Boolean> bools = new ArrayList<>();
        for (Word word : extractWords(letters))
            if (isBool(word.get()))
                bools.add(word.contentEquals("true"));
        return bools;
    }

    public static List<FractionData> extractFractions(CharSequence letters) {
        List<FractionData> characters = new ArrayList<>();
        for (IntString property : getProperties(letters))
            if (isFraction(property.letter))
                characters.add(new FractionData(property.letter));
        return characters;
    }

    public static List<Word> getWordsOnly(CharSequence letters) {
        return getWordsOnly(IData.CharSet.English, letters);
    }

    public static List<Word> getWordsOnly(IData.CharSet charSet, CharSequence letters) {
        List<Word> words = new ArrayList<>();
        for (String word : letters.toString().split(" ")) {
            String w = word;
            if (w.length() > 1 && isCharacter(word.charAt(word.length() - 1)))
                w = w.substring(0, word.length() - 1);
            if (w.length() == 1 && !isAlphabet(charSet, w))
                continue;
            words.add(new Word(charSet, w));
        }
        return words;
    }

    public static List<Word> getWords(CharSequence letters) {
        return getWords(IData.CharSet.English, letters);
    }

    public static List<Word> getWords(IData.CharSet charSet, CharSequence letters) {
        List<Word> words = new ArrayList<>();
        for (String word : letters.toString().split(" "))
            words.add(new Word(charSet, word));
        return words;
    }

    public static <L extends Letters> List<Word> extractWords(L letters) {
        return extractWords(letters != null ? letters.get() : "", letters != null ? letters.getCharSet() : IData.CharSet.English);
    }

    public static List<Word> extractWords(CharSequence letters) {
        return extractWords(letters, IData.CharSet.English);
    }

    public static List<Word> extractWords(CharSequence letters, IData.CharSet charSet) {
        List<Word> words = new ArrayList<>();
        if (letters == null) return words;
        String word = "";
        for (IntString property : getProperties(letters)) {
            if (isAlphabet(charSet, property.letter))
                word += property.letter;
            else {
                if (word.length() > 0)
                    words.add(new Word(charSet, word));
                word = "";
            }
            if (property.index + 1 == letters.length())
                if (word.length() > 0)
                    words.add(new Word(charSet, word));
        }
        return words;
    }

    public static <S extends Letters> List<Word> getWords(S sentence) {
        return getWords(sentence != null ? sentence.getCharSet() : IData.CharSet.English, sentence != null ? sentence.get() : "");
    }

    public static List<Paragraph> extractParagraphs(CharSequence letters) {
        return extractParagraphs(IData.CharSet.English, letters);
    }

    public static List<Paragraph> extractParagraphs(IData.CharSet charSet, CharSequence letters) {
        List<Paragraph> paragraphs = new ArrayList<>();
        Texts texts = new Texts(charSet, letters != null ? letters.toString() : "");
        int start = 0, end;
        if (texts.length() > 0)
            while (start > -1 && start < texts.length() - 1) {
                IntString first = getFirstOccurrence(
                        new IntString('.', texts.indexOf(".\n", start)),
                        new IntString('?', texts.indexOf("?\n", start)),
                        new IntString('!', texts.indexOf("!\n", start)),
                        new IntString('\n', texts.indexOf("\n", start))
                );
                end = first.index;

                String paragraph = end >= 0 && end < texts.length() - 2 ? texts.substring(start, end + 1) : texts.substring(start);
                paragraphs.add(new Paragraph(charSet, paragraph.trim()));

                if (end <= 0) break;

                start = end + (first.letter.contentEquals("\n") ? "" : " ").length();
            }
        return paragraphs;
    }

    public static boolean isIndent(char indent) {
        return indent == '\t';
    }

    public static <S extends ISentence> List<Paragraph> extractParagraphs(S texts) {
        return extractParagraphs(texts != null ? texts.getCharSet() : IData.CharSet.English, texts != null ? texts.get() : "");
    }

    public static List<Line> extractLines(CharSequence letters) {
        List<Line> lines = new ArrayList<>();
        String texts = letters != null ? letters.toString() : "";

        int start = 0, end = 0, line = 0;
        while (start >= 0 && end >= 0) {
            if (start > texts.length() - 1) break;
            line++;
            end = texts.indexOf("\n", start);
            Line l = new Line(line, end >= 0 && end < texts.length() - 1 ? texts.substring(start, end) : texts.substring(start));
            if (l.isNotEmpty())
                lines.add(l);

            if (end < 0 || end >= texts.length() - 1) break;
            start = end + 1;
        }
        return lines;
    }

    public static List<Sentence> extractSentences(CharSequence letters) {
        return extractSentences(IData.CharSet.English, letters);
    }

    public static List<Sentence> extractSentences(IData.CharSet charSet, CharSequence letters) {
        List<Sentence> sentences = new ArrayList<>();
        Texts texts = new Texts(charSet, letters != null ? letters.toString() : "");

        int start = 0, end;
        if (texts.length() > 0)
            while (start < texts.length() - 1) {
                IntString first = getFirstOccurrence(
                        new IntString('.', texts.indexOf(". ", start)),
                        new IntString('?', texts.indexOf("? ", start)),
                        new IntString('!', texts.indexOf("! ", start)),
                        new IntString('\n', texts.indexOf("\n", start))
                );
                end = first.index;


                String sentence = end >= 0 && end < texts.length() - 2 ? texts.substring(start, end + 1) : texts.substring(start);
                sentences.add(new Sentence(charSet, sentence.trim()));

                // System.out.println("Start: " + start + ", End: " + end + ", Content: \"" + sentence + "\"");

                if (end <= 0) break;

                start = end + (first.letter.contentEquals("\n") ? "" : " ").length() + 1;
            }
        return sentences;
    }

    public static IntString getFirstOccurrence(IntString... values) {
        IntString value = values.length > 0 ? values[0] : null;
        if (value != null)
            for (IntString str : values)
                value = getFirstOccurrence(value, str);
        return value;
    }

    public static IntString getFirstOccurrence(IntString a, IntString b) {
        return getFirstOccurrence(a.index, a.letter, b.index, b.letter);
    }

    public static IntString getFirstOccurrence(int a, String aStr, int b, String bStr) {
        int min = Math.min(a, b);
        int index = min > -1 ? min : Math.max(a, b);
        String letter = index == a ? aStr : bStr;
        return new IntString(letter, index);
    }

    public static <S extends ISentence> List<Sentence> extractSentences(S texts) {
        return extractSentences(texts != null ? texts.getCharSet() : IData.CharSet.English, texts != null ? texts.get() : "");
    }

    public static List<Sentence> extractSentences(Texts texts) {
        List<Sentence> sentences = new ArrayList<>();
        for (Paragraph paragraph : texts.extractParagraphs())
            sentences.addAll(paragraph.extractSentences().getSentences());
        return sentences;
    }


    public static List<Integer> extractIntegers(CharSequence letters) {
        List<Integer> integers = new ArrayList<>();
        for (double num : extractDoubles(letters))
            if (isInteger(String.valueOf(num)))
                integers.add((int) num);
        return integers;
    }

    public static List<Double> extractDecimals(CharSequence letters) {
        List<Double> decimals = new ArrayList<Double>();
        for (double num : extractDoubles(letters))
            if (!isInteger(String.valueOf(num)))
                decimals.add(num);
        return decimals;
    }

    public static List<Long> extractLongs(CharSequence letters) {
        List<Long> longs = new LinkedList<>();
        for (double num : extractDoubles(letters))
            if (isLong(num + ""))
                longs.add((long) num);
        return longs;
    }

    public static List<Number> extractNumbers(CharSequence letters) {
        List<Number> numbers = new ArrayList<>();
        for (double num : extractDoubles(letters))
            if (isInteger(num + ""))
                numbers.add(new Number(extractIntegers(num + "").get(0)));
            else
                numbers.add(new Number(num));
        return numbers;
    }

    public static List<Operator> extractOperators(CharSequence letters) {
        List<Operator> operators = new LinkedList<>();
        for (IntString prop : getProperties(letters))
            if (isOperator(prop.letter))
                operators.add(new Operator(prop.letter));
        return operators;
    }

    public static List<Letter> extractLetters(CharSequence letters) {
        return extractLetters(IData.CharSet.English, letters);
    }

    public static List<Letter> extractLetters(IData.CharSet charSet, CharSequence letters) {
        List<Letter> letterList = new ArrayList<>();
        for (IntString prop : getProperties(letters))
            if (isLetter(charSet, prop.letter))
                letterList.add(new Letter<>(charSet, prop.letter));
        return letterList;
    }

    public static List<Double> extractDoubles(CharSequence letters) {
        List<Double> doubles = new ArrayList<>();
        String number = "";
        for (IntString property : getProperties(letters)) {
            if (isNumber(property.letter) || property.letter.contentEquals(".")) {
                if (property.letter.contentEquals(".") && number.contains(".")) {
                    if (number.startsWith(".") && number.length() > 1) {
                        number = 0 + number;
                        doubles.add(Double.parseDouble(number));
                    }
                    number = property.letter;
                } else
                    number += property.letter;
                if (property.index + 1 == letters.length())
                    if (number.length() > 0) {
                        if (number.contains(".") && number.length() > 1) {
                            if (number.startsWith("."))
                                number = 0 + number;
                            else if (number.endsWith("."))
                                number += 0;
                            doubles.add(Double.parseDouble(number));
                        } else if (!number.contains("."))
                            doubles.add(Double.parseDouble(number));
                        number = "";
                    }
            } else if (number.length() > 0) {
                if (number.contains(".") && number.length() > 1) {
                    if (number.startsWith("."))
                        number = 0 + number;
                    else if (number.endsWith("."))
                        number += 0;
                    doubles.add(Double.parseDouble(number));
                } else {
                    if (!number.contains("."))
                        doubles.add(Double.parseDouble(number));
                }
                number = "";
            }
        }
        return doubles;
    }

    public static List<Float> extractFloats(CharSequence letters) {
        List<Float> floats = new LinkedList<>();
        for (double num : extractDoubles(letters))
            if (isFloat(num + ""))
                floats.add((float) num);
        return floats;
    }

    public static List<Index> extractIndexes(CharSequence letters) {
        List<Index> indices = new ArrayList<>();
        StringBuilder index = new StringBuilder();
        for (IntString property : getProperties(letters)) {
            if (isIndex(property.letter) || (property.letter.contentEquals("°") && !index.toString().contains("°"))) {
                if (property.letter.contentEquals("°") && index.toString().isEmpty())
                    index.append("⁰");
                index.append(property.letter);
            } else {
                if (index.length() > 0)
                    indices.add(new Index(index.toString()));
                index = new StringBuilder();
            }
        }
        return indices;
    }

    public static List<Object> extractArray(CharSequence letters) {
        List<Object> array = new ArrayList<>();
        Word data = new Word(letters.toString().substring(letters.toString().indexOf("[") + 1, letters.toString().lastIndexOf("]")).trim());
        int start = 0, end = 0;

        while (start > -1 && start < data.length() - 1) {
            start = data.subLetters(end).getFirstLetterIndex();
            char firstLetter = data.subLetters(end).getFirstLetter();
            if (firstLetter == ',' || firstLetter == '}') {
                end += data.subLetters(end).indexOf(firstLetter) + 1;
                firstLetter = data.subLetters(end).getFirstLetter();
            }

            if (start <= -1)
                break;
            start += end;

            end = getEnd(data, firstLetter, start);

            if (end < 0 || start >= data.length())
                break;

            String value = data.substring(start, end).trim();
            if (end >= data.length() - 1)
                value = data.substring(start).trim();

            if (value.startsWith("[") && !value.endsWith("]")) {
                end = value.lastIndexOf("]");
                value = value.substring(0, end + 1);
            } else if (value.startsWith("{") && !value.endsWith("}")) {
                end = value.lastIndexOf("}");
                value = value.substring(0, end + 1);
            }

            String type = getType(value);
            if (type.contentEquals(NULL)) break;

            Object val;
            switch (type) {
                case OBJECT:
                    val = extractObject(value);
                    break;
                case ARRAY:
                    val = extractArray(value);
                    break;
                default:
                    val = toObject(value);
            }

            array.add(val);

            if (type.contentEquals(OBJECT) || type.contentEquals(ARRAY) || type.contentEquals(STRING))
                end++;

            if (end >= data.length() - 1 || start >= data.length() - 1)
                break;
        }
        return array;
    }

    public static Map<String, Object> extractObject(CharSequence letters) {
        Map<String, Object> object = new HashMap<>();
        Word data = new Word(letters.toString().substring(letters.toString().indexOf("{") + 1, letters.toString().lastIndexOf("}")).replaceAll("\t", "").replaceAll("\n", "").trim());
        int start = 0, end = 0, lastIndex;

        while (start < data.length() - 1 && end < data.length() - 1) {
            start = data.indexOf("\"", end) + 1;
            end = data.indexOf("\":", start);
            if (end < 0 || end > data.length() - 1 || start > data.length() - 1)
                break;

            String key = data.substring(start, end);
            start = data.indexOf(":", end);
            if (start > -1) start++;
            else break;

            lastIndex = start;
            start = data.subLetters(lastIndex).getFirstLetterIndex();
            char firstLetter = data.subLetters(lastIndex + 1).getFirstLetter();
            if (firstLetter == ',' || firstLetter == '}') {
                end += data.subLetters(end).indexOf(firstLetter) + 1;
                firstLetter = data.subLetters(end).getFirstLetter();
            }

            if (start <= -1) break;
            else start += lastIndex;

            end = getEnd(data, firstLetter, start);

            if (end < 0 || start > data.length() - 1)
                break;

            String value = data.substring(start, end).trim();
            if (end >= data.length() - 1 && start < data.length() - 1)
                value = data.substring(start).trim();

            if (value.startsWith("[") && !value.endsWith("]"))
                value = value.substring(0, value.lastIndexOf("]") + 1);
            else if (value.startsWith("{") && !value.endsWith("}"))
                value = value.substring(0, value.lastIndexOf("}") + 1);

            String type = getType(value);
            if (type.contentEquals(NULL)) break;

            Object val;
            switch (type) {
                case OBJECT:
                    val = extractObject(value);
                    break;
                case ARRAY:
                    val = extractArray(value);
                    break;
                default:
                    val = toObject(value);
            }
            object.put(key, val);

            if (type.contentEquals(OBJECT) || type.contentEquals(ARRAY) || type.contentEquals(STRING))
                end++;

            if (end > data.length() - 1 || start > data.length() - 1 || end <= -1 || start <= -1)
                break;
        }
        return object;
    }

    protected static int getEnd(Word data, char firstLetter, int start) {
        int end;
        if (start <= -1 || start > data.length() - 1) return -1;
        if (firstLetter == '\"') {
            end = data.subLetters(start).contains("\",") ? data.indexOf("\",", start) : data.indexOf("\" ", start);
            if (end > -1)
                end++;
            else
                end = data.length();
        } else if (firstLetter == '[') {
            end = getCoverIndex(data, '[', ']', start);
            if (end > -1)
                end++;
        } else if (firstLetter == '{') {
            end = getCoverIndex(data, '{', '}', start);
            if (end > -1)
                end++;
        } else
            end = data.subLetters(start).contains(",") ? data.indexOf(",", start) : data.length() - 1;
        return end;
    }

    public static String getType(String value) {
        return value.startsWith("[") && value.endsWith("]") ? ARRAY :
                value.startsWith("{") && value.endsWith("}") ? OBJECT :
                        value.startsWith("\"") && value.endsWith("\"") ? STRING :
                                isBool(value) ? BOOLEAN : isInteger(value) ? INTEGER : isLong(value) ? LONG :
                                        isFloat(value) ? FLOAT : isNumberOnly(value) ? DOUBLE : NULL;
    }

    public static final String ARRAY = "array";
    public static final String OBJECT = "object";
    public static final String STRING = "string";
    public static final String INTEGER = "int";
    public static final String FLOAT = "float";
    public static final String DOUBLE = "double";
    public static final String LONG = "long";
    public static final String BOOLEAN = "boolean";
    public static final String NULL = "null";

    public static int getCoverIndex(Word source, char open, char close, int index) {
        if (source == null || index > source.length() || index < 0 && !source.subLetters(index).contains(open))
            return -1;
        int start, end = index, openCount = 0, closeCount = 0, lastIndex = -1;
        start = source.indexOf(open, end);
        end = start;
        lastIndex = end + 1;
        while (start > -1 && start < source.length() - 1) {
            start = source.indexOf(close, lastIndex);
            if (start <= -1 || start < end) return openCount == closeCount ? lastIndex : -1;
            start++;
            if (start >= source.length() - 1) {
                openCount = source.subLetters(end).getLetterCount(open);
                closeCount = source.subLetters(end).getLetterCount(close);
            } else {
                openCount = source.subLetters(end, start).getLetterCount(open);
                closeCount = source.subLetters(end, start).getLetterCount(close);
            }
            lastIndex = start;
            if (openCount == closeCount) return lastIndex;
        }
        return -1;
    }

    public static boolean isValid(Word source, char open, char close, int start) {
        return getCoverIndex(source, open, close, start) > -1;
    }


    public static Object toObject(String value) {
        switch (getType(value)) {
            case BOOLEAN:
                return value.contentEquals("true");
            case INTEGER:
                return extractIntegers(value).get(0);
            case LONG:
                return !extractLongs(value).isEmpty() ? extractLongs(value).get(0) : Long.MIN_VALUE;
            case FLOAT:
                return !extractFloats(value).isEmpty() ? extractFloats(value).get(0) : Float.MIN_VALUE;
            case DOUBLE:
                return !extractDecimals(value).isEmpty() ? extractDecimals(value).get(0) : Double.MIN_VALUE;
            case STRING:
                return value.length() > 1 ? new Word(value).remove("\"", value.length() - 2).remove("\"").replaceAll("@10", "\n").replaceAll("@09", "\t").get() : value;
            default:
                return null;
        }
    }


    public static List<IntString> getProperties(CharSequence letters) {
        List<IntString> properties = new ArrayList<>();
        for (int n = 0; n < letters.length(); n++)
            properties.add(new IntString(letters.toString().charAt(n), n));
        return properties;
    }

}

