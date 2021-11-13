package lotto.view.strategy;

import java.util.regex.Pattern;

public class InputPurchaseManualGameCount implements Input {

    private static final String MESSAGE = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    private static final Pattern REGEX_PATTERN = Pattern.compile("^[0-9]{1,}$");
    private static final String ERROR_MESSAGE= "숫자만 입력할 수 있습니다.";

    @Override
    public String getMessage() {
        return MESSAGE;
    }

    @Override
    public Pattern inputRegexCompiler() {
        return REGEX_PATTERN;
    }

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }

}
