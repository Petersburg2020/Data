package nx.peter.java;

import nx.peter.java.re.Regex;
import nx.peter.java.util.Fraction;
import nx.peter.java.util.data.FractionData;
// import nx.peter.java.util.data.DataCreator;
// import nx.peter.java.util.data.Sentence;

public class Main {

    public static void main(String[] args) {
        /*Sentence s = DataCreator.createSentence("Cat cat cat cattle cat 01-04-2023. Sometimes 2 to 20 or more Cats can run in sam competition, and some publications will note it.");

        println(s.count(20));

        Regex r = Regex.getInstance(s);
        println(r.extract(20).toString());
        println(r.extractExact(20));

        String email = "uareimee@gmail.com";
        println(email);
        println(Regex.isEmail(email));*/

        Fraction fr = new Fraction(2.5);
        println(new FractionData(fr.getMixed()));
        println(fr.getMixed());

    }

    public static void println(Object what) {
        System.out.println(what);
    }

}
