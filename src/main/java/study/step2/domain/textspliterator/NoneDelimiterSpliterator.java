package study.step2.domain.textspliterator;

public class NoneDelimiterSpliterator implements TextSpliterator {

    private static final String ONLY_NUMBER_REGEX = "[\\d]+";


    @Override
    public String[] split(String text) {
        if(isInseparable(text)) {
            return null;
        }

        return new String[] {text};
    }

    private boolean isInseparable(String text) {
        return !text.matches(ONLY_NUMBER_REGEX);
    }
}
