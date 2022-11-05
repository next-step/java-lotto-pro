/*
 * Constant.java
 * v0.1
 * 2022.10.30
 */
package lotto;

public class Constant {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final String REGEX_ONLY_NUMBER = "^[0-9]*$";
    public static final String NULL = "";
    public static final String INPUT_PAY_MONEY = "구입금액을 입력해 주세요.";
    public static final String INPUT_MANUAL_PURCHASE = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String INPUT_MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER_LAST_WEEK = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_LAST_WEEK = "보너스 볼을 입력해 주세요.";
    public static final String RESULT_BOUGHT_1 = "수동으로 ";
    public static final String RESULT_BOUGHT_2 = "장, 자동으로 ";
    public static final String RESULT_BOUGHT_3 = "개를 구매했습니다.";
    public static final String RESULT_WINNING_STATISTICS = "당첨 통계\n---------";
    public static final String EA = "개";
    public static final String RESULT_HIT_THREE = "3개 일치 (5000원)-";
    public static final String RESULT_HIT_FOUR = "4개 일치 (50000원)- ";
    public static final String RESULT_HIT_FIVE = "5개 일치 (1500000원)- ";
    public static final String RESULT_HIT_FIVE_AND_BONUS = "5개 일치, 보너스 볼 일치(30000000원)- ";
    public static final String RESULT_HIT_SIX = "6개 일치 (2000000000원)- ";
    public static final String RESULT_TOTAL_EARNINGS_RATE_1 = "총 수익률은 ";
    public static final String RESULT_TOTAL_EARNINGS_RATE_2 = "입니다.";
    public static final int ZERO = 0;
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;
    public static final String DELIMITER = "[, ]";
    public static final String ERROR_ONLY_NUMBER = "숫자만 입력할 수 있습니다.";
    public static final String ERROR_NUMBER_OUT_OF_RANGE = "숫자는 1 ~ 45까지 입력할 수 있습니다.";
    public static final String ERROR_LOTTO_COST = "로또 복권 1장의 구입 가격 " + LOTTO_PRICE + "원 입니다.";
    public static final String ERROR_INPUT_EMPTY_COST = "금액을 입력해주세요.";
    public static final String ERROR_INPUT_EMPTY_WINNING_NUMBER = "당첨 번호를 입력해주세요.";
    public static final String ERROR_INPUT_SIX_NUMBER = "로또 번호 6개를 입력해주세요.";
    public static final String ERROR_LOTTO_NUMBER_DUPLICATED = "로또 번호는 중복될 수 없습니다.";
    public static final String ERROR_BONUS_NUMBER_DUPLICATED = "입력하신 보너스 번호는 지난주 당첨 번호에 이미 있는 번호입니다.";
    public static final String ERROR_EXCEED_PURCHASABLE_COUNT = "구매할 수 있는 개수를 초과하였습니다.";
    public static final String ERROR_NOT_ENOUGH_BALANCE = "남아있는 금액이 부족합니다.";
}
