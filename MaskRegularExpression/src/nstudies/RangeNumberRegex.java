package nstudies;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RangeNumberRegex {


    /**
     * Ponto interessante: Regex lida com textos e nao numeros
     * assim usa-la para vwerificar se um numero esta dentro de um intervalo
     * leva um pouco mais de trabalho. Exemplo
     *
     * [0-255] eh uma Classe de caracteres, o que dizemos quando passamos
     * isso para um interpretador de regex eh:
     *
     * corresponde de 0 a 2 e 5 [0,1,2,5].
     *
     * Se quisermos criar uma classe que corresponda entre 0 e 255 por exemplo
     * precisamos de uma regex que diga para corresponde com numeros de 1 a 3
     * digitos
     *
     * [0-9] corresponde a 1 digito de 0 a 9
     * [1-9][0-9] corresponde de 10 a 99
     * 1[0-9][0-9] de 100 a 199
     * 2[0-4][0-9] de 200 a 249
     * 25[0-5] de 250 a 255
     * */

    private static final String VALID255 = "^[1-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5]" +
            "(\\.[1-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5]){3}";


    private static Matcher test(String ip) {
        return Pattern.compile(VALID255).matcher(ip);
    }

    private static void show(Matcher matcher) {
        if (matcher.find()) {
            System.out.printf("Groups: %d\nGroup: %s"
                        , matcher.groupCount()
                        , matcher.group()
                    );
        }
        else {
            System.out.println("Não corresponde");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        show(test("127.0.0.1"));
        show(test("256.0.0.1"));
        show(test("0.0.0.1"));
        show(test("255.255.255.255"));
    }
}
