package step2;

import java.util.ArrayList;
import java.util.List;

public class SplitManager {
    public Spliter findSpliter(String inputvalue) {
        if (inputvalue.startsWith("//")){
            return new PatternSpliter(inputvalue);
        }
        return new DefaultSpliter(inputvalue);
    }
}
