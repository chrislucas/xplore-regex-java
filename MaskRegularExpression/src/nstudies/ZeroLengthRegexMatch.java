package nstudies;

/**
 * https://www.regular-expressions.info/zerolength.html
 *
 * anchors, word boundaries e lookaround sao recursos de expressao regular que
 * combinam com uma determinada posicao ao inves de um caracteter. Isso signigica
 * que quando uma regex consiste de um ou mais desses elementos pode ocorrer
 * um 'match' de comprimento zero 'zero legnth match',
 *
 * Isso pode ser muito util ou algo indesejavel dependendo da situação;
 *
 * */

public class ZeroLengthRegexMatch {


    /**
     * https://www.regular-expressions.info/anchors.html
     *
     * Start and End of Line - limites de uma linha
     *
     * ^ start of string
     * $ end of string
     * */

    private static void testZeroLengthMatch() {
        String regex = "^\\d*$";
        System.out.println("2".matches(regex));
        /**
         * a resposta do metodo abaixo e TRUE pois o asterisco
         * apos o \\d torna o caracter opcional (0 ou mais)
         * */
        System.out.println("".matches(regex));
    }

    public static void main(String[] args) {
        testZeroLengthMatch();
    }
}
