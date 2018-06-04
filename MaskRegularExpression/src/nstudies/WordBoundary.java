package nstudies;



import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Start and End of Word -limites de uma palavra
 *
 * https://docs.oracle.com/javase/tutorial/essential/regex/bounds.html
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
            System.out.printf("Pattern '%s' em: '%s'\n"
                    , pattern, text);
            System.out.printf("Group count %d\nGroup: %s\n"
                    , matcher.groupCount() , matcher.group());

            MatchResult matchResult = matcher.toMatchResult();
            int s = matchResult.start(), e = matchResult.end();
            System.out.printf("Start: %d\nEnd: %d\nText: '%s'"
                    , s
                    , e
                    , text.substring(s, e)
            );

        }
        else {
            System.out.printf("Pattern '%s' nao foi encontrado em: '%s'"
                    , pattern, text);
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        /**
         * \\b define um limite de inicio e fim para achar uma correspondencia com uma palavra inteira
         * ou caracter qualquer
         *
         * */
        // corresponde com a palavra 'word'
        test1("\\bword\\b", "The word text editor");
        // nao temos a palavra or no texto
        test1("\\bor\\b", "The word text editor");
        // corresponde com a palavra or no texto
        test1("\\bor\\b", "The word text editor or something else");
        // nao corresponde com nenhuma palavra no texto
        test1("\\btest\\b", "Are you testing this software?");
        test1("\\btesting\\b", "Are you testing this software?");
        test1("\\btesting", "Are you testing this software?");
        /**
         *
         * \\B define um limite de inicio e fim para achar uma palavra que esteja entre este intervalo
         * mas nao seja o intervalo. Exemplo:  procurar 'pin' Em 'Typing' ou 'or' em 'word'
         *
         * Ou seja \\B nos ajuda a procurar uma substring numa string
         * */
        test1("\\Bword\\B", "The word text editor");
        test1("\\Bor\\B", "The word text editor");
        test1("\\Bpin\\B", "Typing");

        test1("\\Btest\\B", "Are you testing this software?");
        test1("\\Bestin\\B", "Are you testing this software?");
    }
}
