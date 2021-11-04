package step2;

public class SplitManager {
    public Spliter findSpliter(String inputvalue) {
        if (inputvalue.startsWith("//")) {
            return new PatternSpliter(inputvalue);
        }
        return new DefaultSpliter(inputvalue);
    }
}
