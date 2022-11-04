package lotto.view;

public abstract class Error {
    public static final String CANNOT_BUY = "수동으로 구매할 로또 수가 구매할 수 있는 로또 수보다 많습니다.";
    public static final String LOTTO_NUMBER = "로또 번호가 유효하지 않습니다.";
    public static final String LOTTO_NUMBER_LENGTH = "로또 번호는 6개의 숫자만 설정 가능합니다.";
    public static final String LOTTO_NUMBER_DUPLICATE = "로또 번호가 중복됩니다.";
    public static final String LOTTO_NUMBER_RANGE = "로또 번호는 1 이상 45 이하의 숫자만 가능합니다.";
    public static final String MONEY = "투입 금액이 유효하지 않습니다.";
    public static final String MONEY_ALLOW_POSITIVE = "투입 금액은 0 이상의 숫자만 가능합니다.";
    public static final String MONEY_UNIT = "투입 금액은 1000 단위의 숫자만 가능합니다.";
    public static final String BONUS_BALL_DUPLICATE = "로또 번호와 보너스 볼 번호가 중복됩니다.";
}