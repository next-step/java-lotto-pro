package lotto.exception;

import lotto.code.ErrorCode;

public class LottoException extends RuntimeException {
	private static String error = "[ERROR] ";

	public LottoException(ErrorCode errorCode) {
		super(error + errorCode.getErrorMessage());
	}
}
