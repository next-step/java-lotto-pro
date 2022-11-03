package step4.constant;

public class ErrorMessageConstant {
    public final static String NOT_NUMBER = "숫자가 아닙니다";
    public final static String EMPTY_TEXT = "빈 문자열을 입력하였습니다";
    public final static String NEGATIVE_NUMBER = "0 미만의 숫자가 있습니다.";
    public final static String OUT_OF_SIZE_LOTTO_NUMBER = "로또 숫자의 범위를 넘어서는 숫자가 입력되었습니다.(허용 범위:"
            + LottoConstant.LOTTO_MIN_NUM + "~" + LottoConstant.LOTTO_MAX_NUM + ")";
    public final static String NOT_LOTTO_SIZE = "로또 숫가 개수는 서로 다른 수 " + LottoConstant.PICK_LOTTO_MAX_NUM + "+개이어야 합니다";
    public final static String ZERO_LOTTO_BUY_COUNT = "구매할 수 있는 로또의 개수가 0개 입니다.";
    public final static String BONUS_NUMBER_IN_LOTTO_WIN_RESULT = "보너스 번호는 당첨 번호와 같으면 안됩니다.";
    public final static String MANUAL_BUY_LOTTO_EQUAL_NOT_SIZE = "수동 구매할 로또 수와 구매할 번호 입력수가 다릅니다.";
    public final static String MANUAL_BUY_LOTTO_GREATER_THAN_TOTAL_BUY_LOTTO = "총 구매할 수 있는 로또수보다 수동으로 구매하려 하는 개수가 큽니다.";
}