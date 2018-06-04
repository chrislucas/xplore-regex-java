package nstudies;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.regular-expressions.info/anchors.html
 *
 * ^ caret - inicio da linha
 * $ dollar - fim da linha
 *
 * https://docs.oracle.com/javase/tutorial/essential/regex/bounds.html
 * */

public class Anchors {

    private static final void test(String regex, String text) {
        Matcher matcher = Pattern.compile(regex).matcher(text);
        if (matcher.find()) {
            int gc = matcher.groupCount();
            String group = matcher.group();
            System.out.printf("Padrao: '%s'\nTexto: %s\nGroup Count: %d\nGroup: '%s'"
                    , regex
                    , text
                    , gc
                    , group
            );
        }

        else {
            System.out.printf("Nao foi encontrado o padrão '%s' no texto '%s'\n"
                    , regex, text);
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        test("^dog$", "dog");
        test("^dog$", "    dog");
        test("dog$", "    dog");
        test("^dog", "dog    ");
        test("^teste 123$", "teste 123");
        test("^teste 123$", "teste 1234");
        test("^teste 123", "teste 1234");
    }
}
