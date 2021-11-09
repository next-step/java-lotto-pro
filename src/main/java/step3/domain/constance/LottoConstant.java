package step3.domain.constance;

public class LottoConstant {
    public static final int MIN_NUMBER_RANGE = 1;
    public static final int MAX_NUMBER_RANGE = 45;
    public static final int LOTTO_MINIMUM_PRICE = 1000;
    public static final int MAX_LOTTO_NUMBERS_SIZE = 6;

    public static final String LOTTO_RANGE_OVER_EXCEPTION = String.format("%s부터 %s 까지의 숫자를 입력해주세요.",
        MIN_NUMBER_RANGE,
        MAX_NUMBER_RANGE);
    public static final String LOTTO_REPORT_FORMAT = "%s개 일치 (%d원)- %d개";
    public static final String WON = "원";
    public static final String BONUS_NUMBER_ALREADY_EXIST_MESSAGE = "지난 주 우승 번호에 포함된 숫자는 보너스번호가 될 수 없습니다.";
    public static final String LACK_OF_AMOUNT = "구매 비용이 부족합니다.";

    private LottoConstant() {
    }
}
