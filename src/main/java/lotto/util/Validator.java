package lotto.util;

public class Validator {
    private static final String REGEX_1_TO_45_CHAR = "^[0-9]{1}$|^[1-3]{1}[0-9]{1}|^4{1}[0-5]{1}$";
    
    public static void validateIsEmpty(String str) {
        if (Constants.INIT_VALUE.equals(str)) {
            throw new IllegalArgumentException(Constants.ERR_VALUE_NOT_VALID);
        }
    }

    public static void validateLottoNumberBoundary(String lottoNumberStr) {
        if (!RegexUtil.match(REGEX_1_TO_45_CHAR, lottoNumberStr)) {
            throw new IllegalArgumentException(Constants.ERR_VALUE_NOT_VALID);
        }
    }
    
    public static void validateLottoNumberBoundary(int lottoNumber) {
        if (lottoNumber < Constants.MIN_LOTTO_TICKET_NUM || lottoNumber > Constants.MAX_LOTTO_TICKET_NUM) {
            throw new IllegalArgumentException(Constants.ERR_VALUE_NOT_VALID);
        }
    }
}
