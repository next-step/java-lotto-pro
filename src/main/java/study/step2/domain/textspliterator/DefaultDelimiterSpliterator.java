package study.step2.domain.textspliterator;

public class DefaultDelimiterSpliterator implements TextSpliterator {

    private static final String DEFAULT_DELIMITER_REGEX = ",|:";

    @Override
    public String[] split(String text) {
        String[] tokens = text.split(DEFAULT_DELIMITER_REGEX);
        if(isInseparable(text, tokens)) {
            return null;
        }

        return tokens;
    }

    private boolean isInseparable(String text, String[] tokens) {
        return tokens[0].equals(text);
    }
}
