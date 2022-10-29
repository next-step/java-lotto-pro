package lotto.util;

import java.util.Arrays;
import java.util.List;

public class InputSplitter {
	public static final String DELIMITER = ", ";

	public static List<String> splitText(String text) {
		return Arrays.asList(text.split(DELIMITER));

	}
}
