package lotto.constants;

public class ErrorMessage {
    public static String ERROR_PREFIX = "[ERROR]";
    public static final String OUT_OF_RANGE_NUMBER = formatErrorMessage("1부터 45까지의 숫자만 입력 가능합니다.");
    public static final String NOT_EMPTY_LOTTO = formatErrorMessage("로또 번호는 빈 값일 수 없습니다.");
    public static final String OUT_OF_SIZE_LOTTO = formatErrorMessage("로또의 번호는 6개만 가능합니다.");
    public static final String DUPLICATE_NUMBER = formatErrorMessage("중복된 번호는 포함될 수 없습니다.");
    public static final String OUT_OF_RANGE_MATCH = formatErrorMessage("0개부터 6개 까지만 매칭 가능합니다.");
    public static final String LESS_THEN_MIN_MONEY = formatErrorMessage("0원 이상의 금액만 입력 가능합니다.");
    public static final String LESS_THEN_PRICE_MONEY = formatErrorMessage("최소 1000원부터 구매 가능합니다.");
    public static final String MAX_PURCHASE_LOTTO = formatErrorMessage("구입 가능한 최대 개수는 100개 입니다.");
    public static final String NOT_NUMBER_FORMAT = formatErrorMessage("숫자 값만 입력할 수 있습니다.");

    private static String formatErrorMessage(String message) {
        return String.format("%s %s", ERROR_PREFIX, message);
    }
}
