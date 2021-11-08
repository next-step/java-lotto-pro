package lotto.domain.exception;

import lotto.domain.Common;

public class IllegalNumbersException extends IllegalArgumentException {
	private static final String NUMBER_COUNT_ERROR = String.format(
		"Lotto 번호는 %d개 여야 합니다.", Common.LOTTO_NUMBER_COUNT
	);

	public IllegalNumbersException() {
		super(NUMBER_COUNT_ERROR);
	}
}
