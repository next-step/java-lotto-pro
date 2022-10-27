import domain.Numbers;
import domain.SafeString;
import util.Splitter;

public class StringAddCalculator {
    private StringAddCalculator(){}

    public static int splitAndSum(String text) {
        SafeString safeString = SafeString.of(text);
        Numbers numbers = Splitter.split(safeString.toString());
        return numbers.sum();
    }
}
