import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TripleDouble {

    public static void main(String[] args) throws Exception {

        /* expected 1 matching three 0 and two 0 */
        System.out.println(tripleDouble(12400023492L, 43200));
        /* expected 0 not matching three 2 and two 3 */
        System.out.println(tripleDouble(1222345, 1233345));
    }

    public static int tripleDouble(long num1, long num2) {

        String regexTriple = ".*(\\d)\\1{2,}.*";
        String regexDouble = ".*(\\d)\\1{1,}.*";

        Pattern patternTriple = Pattern.compile(regexTriple, Pattern.MULTILINE);
        Pattern patternDouble = Pattern.compile(regexDouble, Pattern.MULTILINE);

        Matcher matcherTriple = patternTriple.matcher(String.valueOf(num1));
        String groupTriple = null;
        if (matcherTriple.find()) {
            groupTriple = matcherTriple.group(1);
        }

        Matcher matcherDouble = patternDouble.matcher(String.valueOf(num2));
        String groupDouble = null;
        if (matcherDouble.find()) {
            groupDouble = matcherDouble.group(1);
        }

        if (groupTriple != null && groupDouble != null) {
            if (groupTriple.equals(groupDouble))
                return 1;
        }

        return 0;
    }

}
