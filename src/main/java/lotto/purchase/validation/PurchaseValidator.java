package lotto.purchase.validation;

public interface PurchaseValidator {

    String ERROR_NUMBER_MESSAGE = "[ERROR] 구입 금액은 숫자로만 입력해주세요.";
    String ERROR_MIN_COST_MESSAGE = "[ERROR] 구입 가능 금액은 최소 1000원 입니다";

    void validate(String purchase);
}
