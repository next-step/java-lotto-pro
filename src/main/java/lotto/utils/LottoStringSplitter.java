package lotto.utils;

public class LottoStringSplitter {
	private static final String DELIMITER_REGEX = "[,]";

	private LottoStringSplitter() {}

	public static String[] split(String text) {
		if (LottoStringUtils.isEmpty(text)) {
			return new String[]{};
		}

		return text.split(DELIMITER_REGEX);
	}
}
