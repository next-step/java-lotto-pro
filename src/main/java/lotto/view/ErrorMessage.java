package lotto.view;

import lotto.model.LottoNumber;

public class ErrorMessage {
    public static final String LOTTO_SIZE_OVER = "숫자 갯수가 " + LottoNumber.SIZE + "보다 큽니다.";
    public static final String LOTTO_RANGE_OVER = "로또 숫자 범위가 아닙니다.";
    public static final String NUMBER_FORMAT_ERROR = "입력값이 숫자가 아닙니다.";
    public static final String LOTTO_MAX_BUY_ERROR = "로또는 최대 99개만 구입 가능합니다.";
}
