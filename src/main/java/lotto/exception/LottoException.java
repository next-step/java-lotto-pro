package lotto.exception;


public class LottoException extends RuntimeException {

  private static final String error = "[ERROR] ";

  public LottoException(ErrorCode errorCode) {
    super(error + errorCode.getErrorMessage());
  }
}
