package util;

import domain.Numbers;
import domain.SafeString;

public class Splitter {
    public static Numbers split(SafeString s) {
        String[] split = s.toString().split(",|:");
        return Numbers.of(split);
    }
}
