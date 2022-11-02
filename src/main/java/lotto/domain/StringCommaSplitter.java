package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class StringCommaSplitter implements StringToIntListSplitter {
    @Override
    public List<String> split(String str) {
        return Arrays.asList(str.split(","));
    }
}
