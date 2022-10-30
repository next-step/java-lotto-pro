package lotto.util;

public class Constants {
    public static final String COMMA = ",";
    public static final String BLANK = " ";

    public static final int TICKET_MIN_IDX = 0;
    public static final int TICKET_MAX_IDX = 5;
    public static final int TICKET_MIN_LOTTO_NUM = 1;
    public static final int TICKET_MAX_LOTTO_NUM = 45;
    
    public static final String REGEX_1_TO_45_CHAR = "^.{1,45}$";
    public static final String REGEX_NUMBER = "^[0-9]+$";
    
    public static final String ERR_NULL_VALUE = "값을 입력해 주세요";
    public static final String ERR_VALUE_NOT_VALID = "올바른 숫자를 입력해 주세요.";
    public static final String ERR_MORE_THAN_1000 = "1000 이상의 숫자를 입력해 주세요.";
    public static final String ERR_SIX_NUMBERS = "여섯 개의 숫자를 입력해 주세요.";
    public static final String ERR_DUP_NUMBERS = "중복된 숫자는 허용되지 않습니다.";
}
