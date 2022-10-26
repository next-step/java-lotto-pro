import domain.Numbers;
import domain.SafeString;
import util.Splitter;

public class StringAddCalculator {
    public static int splitAndSum(String o) {
        SafeString s = SafeString.of(o);
        Numbers split = Splitter.split(s);
        return split.sum();
    }
}
