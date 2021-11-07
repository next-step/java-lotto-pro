package common;

import static common.Constants.*;

import exception.BusinessException;
import exception.ErrorMessages;

public class CommonUtils {
	private CommonUtils() {
	}

	public static Integer parseInt(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new BusinessException(ErrorMessages.INPUT_NUMBER_FORMAT_NOT_VALID);
		}
	}

	public static void isPositiveNumber(Integer number) {
		if (number < ZERO) {
			throw new BusinessException(ErrorMessages.POSITIVE_NUMBER_FORMAT_NOT_VALID);
		}
	}
}
