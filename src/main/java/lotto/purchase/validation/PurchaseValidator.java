package lotto.purchase.validation;

public interface PurchaseValidator {

    String ERROR_NUMBER_MESSAGE = "[ERROR] 구입 금액은 숫자로만 입력해주세요.";

    void validate(String purchase);
}
