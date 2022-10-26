import domain.SafeString;

public class StringAddCalculator {
    public static int splitAndSum(String o) {
        SafeString s = SafeString.of(o);
        return Integer.parseInt(s.toString());
    }
}
