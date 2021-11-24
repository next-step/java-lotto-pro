package lotto.constants;

public class ErrorMessage {
  public static final String ERROR_PREFIX = "[Error] ";
  public static final String PURCHASE_AMOUNT_LOWER_ERROR_MESSAGE =
    ERROR_PREFIX + "로또 가격보다 낮은 가격을 입력할 수 없습니다.";
  public static final String LOTTO_QUANTITY_LOWER_ERROR_MESSAGE =
    ERROR_PREFIX + "1개 미만의 로또 수량을 구입할 수 없습니다.";
  public static final String INVALID_BONUS_NUMBER_INPUT_ERROR_MESSAGE =
    ERROR_PREFIX + "보너스번호는 당첨 번호와 중복될 수 없습니다.";
  public static final String INPUT_EMPTY_ERROR_MESSAGE =
    ERROR_PREFIX + "공백을 입력할 수 없습니다.";
  public static final String ILLEGAL_LOTTO_NUMBER_ERROR_MESSAGE =
    ERROR_PREFIX + "로또 숫자 범위를 벗어나 입력하였습니다.";
  public static final String LOTTO_NUMBERS_RANGE_ERROR_MESSAGE =
    ERROR_PREFIX + "로또는 6개의 숫자로 구성되어 있습니다.";
  public static final String LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE =
    ERROR_PREFIX + "로또 숫자를 중복되어 입력할 수 없습니다.";
  public static final String NUMBER_OUT_OF_RANGE_ERROR_MESSAGE =
    ERROR_PREFIX + "유효한 범위 밖의 숫자 입니다.";
  public static final String MANUAL_LOTTO_QUANTITY_OVER_ERROR_MESSAGE =
    ERROR_PREFIX + "수동 로또 수량이 총 수량보다 초과하였습니다.";
  public static final String MANUAL_LOTTO_QUANTITY_LOWER_ERROR_MESSAGE =
    ERROR_PREFIX + "수동 로또 수량을 -1 이하로 입력할 수 없습니다.";

}