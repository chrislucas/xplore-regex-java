package nstudies;

public class LookAheadAndBehind {


    /**
     * http://www.regular-expressions.info/lookaround.html
     *
     * Negative lookahead (?!regex)
     * Positive lookahead (?=regex)
     *
     * */

    private static void test() {
        String neg = "q(?!u)\\.*";
        String pos = "q(?=u)\\.*";
        System.out.println("qu".matches(neg));
        System.out.println("qu".matches(pos));
    }

    public static void main(String[] args) {

        test();

    }

}
