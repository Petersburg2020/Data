package nx.peter.java.util.data;

import nx.peter.java.util.Fraction;

public class FractionData extends Data<FractionData> {

    public FractionData() {
        super();
    }

    public FractionData(double data) {
        this(new Fraction(data));
    }

    public FractionData(Fraction data) {
        super(toFractionData(data).get());
    }

    public FractionData(CharSequence data) {
        super(data);
    }

    public void set(Fraction data) {
        set(toFractionData(data).get());
    }

    @Override
    public FractionData set(CharSequence data) {
        if (DataManager.isFraction(data))
            this.data = data.toString();
        return this;
    }

    public static FractionData toFractionData(Fraction data) {
        if (data == null)
            return new FractionData();
        switch ((int) data.getNumerator()) {
            case 1:
                switch ((int) data.getDenominator()) {
                    case 2:
                        return new FractionData("½");
                    case 3:
                        return new FractionData("⅓");
                    case 4:
                        return new FractionData("¼");
                    case 5:
                        return new FractionData("⅕");
                    case 6:
                        return new FractionData("⅙");
                    case 7:
                        return new FractionData("⅐");
                    case 8:
                        return new FractionData("⅛");
                    case 9:
                        return new FractionData("⅑");
                    case 10:
                        return new FractionData("⅒");
                }
                break;
            case 2:
                switch ((int) data.getDenominator()) {
                    case 3:
                        return new FractionData("⅔");
                    case 5:
                        return new FractionData("⅖");
                }
                break;
            case 3:
                switch ((int) data.getDenominator()) {
                    case 4:
                        return new FractionData("¾");
                    case 5:
                        return new FractionData("⅗");
                }
                break;
            case 4:
                if (data.getDenominator() == 5)
                    return new FractionData("⅘");
                break;
            case 5:
                switch ((int) data.getDenominator()) {
                    case 6:
                        return new FractionData("⅚");
                    case 8:
                        return new FractionData("⅝");
                }
            case 7:
                if (data.getDenominator() == 8)
                    return new FractionData("⅞");
        }
        return new FractionData();
    }

    public Fraction getFraction() {
        switch (data) {
            case "⅙":
                return new Fraction(1, 6);
            case "⅐":
                return new Fraction(1, 7);
            case "⅛":
                return new Fraction(1, 8);
            case "⅑":
                return new Fraction(1, 9);
            case "⅒":
                return new Fraction(1, 10);
            case "½":
                return new Fraction(1, 2);
            case "⅓":
                return new Fraction(1, 3);
            case "¼":
                return new Fraction(1, 4);
            case "⅕":
                return new Fraction(1, 5);
            case "⅔":
                return new Fraction(2, 3);
            case "⅖":
                return new Fraction(2, 5);
            case "¾":
                return new Fraction(3, 4);
            case "⅗":
                return new Fraction(3, 5);
            case "⅜":
                return new Fraction(3, 8);
            case "⅘":
                return new Fraction(4, 5);
            case "⅚":
                return new Fraction(5, 6);
            case "⅝":
                return new Fraction(5, 8);
            case "⅞":
                return new Fraction(7, 8);
            default:
                return new Fraction(0);
        }
    }

    public boolean isInteger() {
        return getFraction().isInteger();
    }

    public boolean isDecimal() {
        return getFraction().isFraction();
    }

    public boolean isNegative() {
        return getFraction().isNegative();
    }

    public boolean isPositive() {
        return getFraction().isPositive();
    }

    public boolean isZero() {
        return getFraction().isZero();
    }

    public Fraction add(FractionData fraction) {
        return fraction != null ? getFraction().add(fraction.getFraction()) : getFraction();
    }

    public Fraction subtract(FractionData fraction) {
        return fraction != null ? getFraction().subtract(fraction.getFraction()) : getFraction();
    }

    public Fraction multiply(FractionData fraction) {
        return fraction != null ? getFraction().multiply(fraction.getFraction()) : getFraction();
    }

    public Fraction divide(FractionData fraction) {
        return fraction != null ? getFraction().divide(fraction.getFraction()) : getFraction();
    }

    public Fraction add(Fraction fraction) {
        return fraction != null ? getFraction().add(fraction) : getFraction();
    }

    public Fraction subtract(Fraction fraction) {
        return fraction != null ? getFraction().subtract(fraction) : getFraction();
    }

    public Fraction multiply(Fraction fraction) {
        return fraction != null ? getFraction().multiply(fraction) : getFraction();
    }

    public Fraction divide(Fraction fraction) {
        return fraction != null ? getFraction().divide(fraction) : getFraction();
    }

    @Override
    public DataType getType() {
        return DataType.Fraction;
    }

}
