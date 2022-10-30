package lotto.util;

public class Constants {
    public static final int SIX = 6;
    public static final int FIVE = 5;
    public static final int FOUR = 4;
    public static final int THREE = 3;
    public static final int ZERO = 0;
    public static final int HUNDRED = 100;
    public static final String COMMA = ",";

    public static final int TICKET_MIN_IDX = 0;
    public static final int TICKET_MAX_IDX = 5;
    public static final int TICKET_MIN_LOTTO_NUM = 1;
    public static final int TICKET_MAX_LOTTO_NUM = 45;
    public static final int TICKET_VALUE = 1000;
    
    public static final String REGEX_1_TO_45_CHAR = "^.{1,45}$";
    public static final String REGEX_NUMBER = "^[0-9]+$";
    
    public static final String ERR_NULL_VALUE = "값을 입력해 주세요";
    public static final String ERR_VALUE_NOT_VALID = "올바른 숫자를 입력해 주세요.";
    public static final String ERR_MORE_THAN_1000 = "1000 이상의 숫자를 입력해 주세요.";
    public static final String ERR_SIX_NUMBERS = "여섯 개의 숫자를 입력해 주세요.";
    public static final String ERR_DUP_NUMBERS = "중복된 숫자는 허용되지 않습니다.";
    
    public static final String STR_START_LOTTO = "구입금액을 입력해 주세요.";
    public static final String STR_BUY_LOTTO = "%d개를 구매했습니다.\n";
    public static final String STR_LOTTO_NUM_LIST = "[%d, %d, %d, %d, %d, %d]\n";
    public static final String STR_WINNING_LOTTO_NUM = "지난 주 당첨 번호를 입력해 주세요.";
    
    public static final String STR_RESULT_TITLE = "당첨 통계\n";
    public static final String STR_RESULT_SEPARATOR = "---------\n";
    public static final String STR_RESULT_PRIZES = "%s개 일치 (%s원) - %s개\n";
    public static final int[] INT_RESULT_PRIZES = {5000, 50000, 1500000, 2000000000};
    public static final String STR_RESULT_RETURN_RATE = "총 수익률은 %.2f입니다.";
    public static final String STR_RESULT_RETURN_RATE_UNDER_1 = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    
}
