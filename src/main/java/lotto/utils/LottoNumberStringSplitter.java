package lotto.utils;

public class LottoNumberStringSplitter {
    private static final String DELIMITER_REGEX = "[,]";

    private LottoNumberStringSplitter() {}

    public static String[] split(String text) {
        if (LottoNumberStringUtils.isEmpty(text)) {
            return new String[]{};
        }
        return text.split(DELIMITER_REGEX);
    }
}
