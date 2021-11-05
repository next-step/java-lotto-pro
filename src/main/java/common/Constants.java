package common;

import java.util.regex.Pattern;

public class Constants {
	public static final int PER_PRICE = 1000;
	public static final int START_NUMBER = 1;
	public static final int END_NUMBER = 45;
	public static final int ZERO = 0;
	public static final int LOTTO_VOLUME = 6;
	public static final String DELIMITER = ",";
	public static final Pattern NUMBER_COMMA_PATTERN = Pattern.compile("^[0-9\\,]+$");
}
