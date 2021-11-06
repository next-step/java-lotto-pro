package lotto.view;

import lotto.model.LottoNumber;

public class ErrorMessage {
    public static final String LOTTO_SIZE_UNMATCHED = "숫자 갯수가 " + LottoNumber.SIZE + "가 아닙니다.";
    public static final String LOTTO_RANGE_OVER = "로또 숫자 범위가 아닙니다.";
    public static final String NUMBER_FORMAT_ERROR = "입력값이 숫자가 아닙니다.";
    public static final String LOTTO_MAX_BUY_ERROR = "로또는 최대 99개만 구입 가능합니다.";
    public static final String SPLITED_ERROR = "1부터 45까지 6개 숫자를 , 로 구분지어서 당첨번호를 입력해주세요.";
}
