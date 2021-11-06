package lotto.view.strategy;

import java.util.regex.Pattern;

public class InputPurchaseAmount implements Input {

    private static final String MESSAGE = "구입금액을 입력해 주세요.";
    private static final Pattern REGEX_PATTERN = Pattern.compile("^(?!(?:\\d{1,2}|999)$)[0-9]\\d+$");
    private static final String ERROR_MESSAGE= "숫자 1000 이상만 입력할 수 있습니다.";

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
