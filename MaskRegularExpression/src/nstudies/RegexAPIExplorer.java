package nstudies;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexAPIExplorer {


    private static Matcher getMatcher(String pattern, CharSequence input) {
        return Pattern.compile(pattern).matcher(input);
    }

    private static MatchResult getMatcherResult(String pattern, CharSequence input) {
        return getMatcher(pattern, input).toMatchResult();
    }

    private static void showGroup(Matcher matcher) {
        if (matcher.find()) {
            System.out.printf("Quantidade de Grupos: %d\nGrupo: %s\n"
                    , matcher.groupCount()
                    , matcher.group()
            );
            if (matcher.groupCount() > 0) {
                for (int i = 0; i < matcher.groupCount(); i++) {
                    System.out.printf("Grupo: %d, %s\n", i, matcher.group(i));
                }
            }
        }
        else {
            System.out.println("Nenhuma correspondência");
        }
        System.out.println("");
    }

    private static void testMatchResult(MatchResult matchResult) {
        Matcher matcher = (Matcher) matchResult;
        if (matcher.find()) {
            System.out.printf("Start: %d\nEnd: %d\nGroup count %d\nGroup %s\n"
                    , matchResult.start()
                    , matchResult.end()
                    , matcher.groupCount()
                    , matcher.group()
            );
        }
        else {
            System.out.println("Nenhuma correspondência");
        }

        System.out.println("");
    }

    public static void main(String[] args) {
        testMatchResult(getMatcher("(\\d{1,3}\\.){3}\\d{1,3}", "123.123.123.123"));
        testMatchResult(getMatcher("(\\d{1,3}\\.){3}\\d{1,3}", "1.2.3.4"));
        testMatchResult(getMatcher("(\\d{1,3}\\.){3}\\d{1,3}", "abc.123.123.123"));
        testMatchResult(getMatcher("(\\d{1,3}\\.){3}\\d{1,3}", "456.123.123.avc"));
    }


    private static void t() {
        // comeca com 1 ou mais digitos seguido de 0 ou mais caracteres
        showGroup(getMatcher("^\\d+\\.*", "Teste123"));

        // comeca com 1 ou mais nao digitos seguido de 0 ou mais caracteres
        showGroup(getMatcher("^\\D+\\.*", "Teste123"));

        // comeca com 1 ou mais digitos seguidos de 0 ou mais caracteres
        showGroup(getMatcher("^\\d+\\.*", "123Teste"));

        showGroup(getMatcher("^\\d+\\.*", "123789"));
        // comeca com 1 ou mais digitos seguidos de 1 ou mais caracteres
        showGroup(getMatcher("^\\d+\\.+", "123789"));

        showGroup(getMatcher("^\\D+\\.*", "123Teste"));

        showGroup(getMatcher("^\\D+\\.*", "Teste123Teste"));

        // corresponde com 1 ou mais nao digitos seguidos de 0 ou mais caracteres
        showGroup(getMatcher("\\D+\\.*", "123Avenida123Teste"));

        // corresponde com 1 ou mais nao digitos seguidos de pelo menos 1 caracter qualquer qualquer coisa
        showGroup(getMatcher("\\D+\\.+", "123Avenida"));

        showGroup(getMatcher("^(\\D+)(\\d+)(\\D+)", "Av. 23 de Maio"));

    }
}
