package step3.domain.constance;

public class LottoConstant {
    public static final int RANGE_MIN_LOTTO_NUMBER = 1;
    public static final int RANGE_MAX_LOTTO_NUMBER = 45;
    public static final String RANGE_OVER_EXCEPTION = String.format("%s부터 %s 까지의 숫자를 입력해주세요.", RANGE_MIN_LOTTO_NUMBER,
        RANGE_MAX_LOTTO_NUMBER);
    public static final int SUB_START_INDEX = 0;
    public static final int RANGE_MAX_ADD_VALUE = 1;
    public static final int LOTTO_TICKET_SIZE = 6;
    public static final String LOTTO_TICKET_OVER_SIZE_EXCEPTION_MESSAGE = String.format("로또 티켓은 %s 개의 숫자만 가능합니다.",
        LOTTO_TICKET_SIZE);

    private LottoConstant() {
    }
}
