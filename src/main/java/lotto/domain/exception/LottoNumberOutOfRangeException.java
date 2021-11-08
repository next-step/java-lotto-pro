package lotto.domain.exception;

import lotto.domain.Common;

public class LottoNumberOutOfRangeException extends IllegalArgumentException {
	private static final String OUT_OF_RANGE_ERROR = String.format(
		"로또 번호의 범위는 %d이상 %d이하 입니다.", Common.NUMBER_RANGE_MIN, Common.NUMBER_RANGE_MAX
	);

	public LottoNumberOutOfRangeException() {
		super(OUT_OF_RANGE_ERROR);
	}
}
