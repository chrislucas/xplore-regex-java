package nstudies;

import impl.MatcherResult;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordBoundary {

    /**
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
        test1("\\bword\\b", "The word text editor");
        test1("\\btest\\b", "Are you testing this software?");
    }
}
