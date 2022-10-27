package study.step2.domain.textspliterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class TextSpliteratorFactory {

    private static final List<TextSpliterator> SPLITERATORS;

    static {
        SPLITERATORS = new ArrayList<>();
        SPLITERATORS.add(new NoneDelimiterSpliterator());
        SPLITERATORS.add(new DefaultDelimiterSpliterator());
        SPLITERATORS.add(new CustomDelimiterSpliterator());
    }


    public static List<TextSpliterator> getAllSpliterators() {
        return Collections.unmodifiableList(SPLITERATORS);
    }
}
