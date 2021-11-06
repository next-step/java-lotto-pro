package step3.domain.constance;

public class LottoConstant {
    public static final int MIN_NUMBER_RANGE = 1;
    public static final int MAX_NUMBER_RANGE = 45;
    public static final int LOTTO_MINIMUM_PRICE = 1000;

    public static final String LOTTO_RANGE_OVER_EXCEPTION = String.format("%s부터 %s 까지의 숫자를 입력해주세요.",
        MIN_NUMBER_RANGE,
        MAX_NUMBER_RANGE);
    public static final int MAX_LOTTO_NUMBERS_SIZE = 6;
    public static final String LOTTO_REPORT_FORMAT = "%s개 일치 (%d원)- %d개";
    public static final String WON = "원";

    private LottoConstant() {
    }
}
