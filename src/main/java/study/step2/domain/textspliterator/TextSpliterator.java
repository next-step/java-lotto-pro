package study.step2.domain.textspliterator;

public interface TextSpliterator {

    default String[] on(String text, String[] tokens) {
        if(tokens != null) {
            return tokens;
        }

        return split(text);
    }

    String[] split(String text);
}
