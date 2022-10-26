package study.step2.domain.calculator;

import study.step2.domain.numbers.Numbers;
import study.step2.domain.textspliterator.TextSpliterator;
import study.step2.domain.textspliterator.TextSpliteratorFactory;

import java.util.List;

public class StringAddCalculator {

    private static final int DEFAULT_SUM = 0;

    public static int splitAndSum(String text) {
        if(isEmptyText(text)) {
            return DEFAULT_SUM;
        }
        String[] numbers = split(text);
        return Numbers.of(numbers).sum();
    }

    private static boolean isEmptyText(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] split(String text) {
        String[] tokens = null;
        List<TextSpliterator> spliterators = TextSpliteratorFactory.getAllSpliterators();
        for (TextSpliterator spliterator : spliterators) {
            tokens = spliterator.on(text, tokens);
        }
        return tokens;
    }
}
