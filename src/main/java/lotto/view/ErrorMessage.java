package lotto.view;

import lotto.model.Lotto;

public class ErrorMessage {
    public static final String LOTTO_SIZE_UNMATCHED = "숫자 갯수가 " + Lotto.SIZE + "가 아닙니다.";
    public static final String LOTTO_RANGE_OVER = "로또 숫자 범위가 아닙니다.";
    public static final String NUMBER_FORMAT_ERROR = "입력값이 숫자가 아닙니다.";
    public static final String SPLITED_ERROR = "1부터 45까지 중복되지 않는 6개 숫자를 , 로 구분지어서 당첨번호를 입력해주세요.";
    public static final String DUPLICATE_ERROR = "중복된 숫자가 존재합니다.";
    public static final String LOTTO_NULL = "숫자를 입력해 주세요.";
    public static final String BONUS_EXIST = "보너스 번호가 당첨번호에 존재합니다.";
}
