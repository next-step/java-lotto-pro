package calculator.domain.target.validation;

public interface CalculatorValidator {

    String ERROR_NUMBER_MESSAGE = "[ERROR] 양수(0포함)를 입력해주세요.";

    void validate(String target);
}
