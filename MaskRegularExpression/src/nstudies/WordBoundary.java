package nstudies;



import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Start and End of Word -limites de uma palavra
 *
 * */

public class WordBoundary {

    /**
     * https://www.w3schools.com/jsref/jsref_regexp_begin_not.asp
     * http://www.regular-expressions.info/wordboundaries.html
     * https://www.regular-expressions.info/anchors.html
     * https://www.regular-expressions.info/characters.html
     * */

    private static void test1(String pattern , String text) {
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        if (matcher.find()) {
            System.out.printf("Groups: %d\nGroup: %s\n"
                    , matcher.groupCount()
                    , matcher.group()
            );

            MatchResult matchResult = matcher.toMatchResult();
            System.out.printf("Start: %d\nEnd: %d\n"
                    , matchResult.start()
                    , matchResult.end()
            );

        }
        else {
            System.out.println("Não encontrado");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        /**
         * \\b define um limite de inicio e fim para achar uma correspondencia com uma palavra ou caracter qualquer
         *
         * */
        test1("\\bword\\b", "The word text editor");
        /**
         *
         * \\B define um limite de inicio e fim para achar uma palavra que esteja entre este intervalo
         * mas nao seja o intervalo. Exemplo:  procurar 'pin' Em Typing ou 'or' em word
         * */
        test1("\\Bword\\B", "The word text editor");
        test1("\\Bor\\B", "The word text editor");
        test1("\\Bpin\\B", "Typing");
        test1("\\Btest\\B", "Are you testing this software?");
        test1("\\Bestin\\B", "Are you testing this software?");
    }
}
