package lotto.view.strategy;

import java.util.regex.Pattern;

public abstract class InputLottoNumbers implements Input {

    private static final Pattern REGEX_PATTERN = Pattern.compile("^[0-9]{1,2}+(,\\s?[0-9]{1,2}+)*$");
    private static final String ERROR_MESSAGE= "숫자와 구분자(,)만 입력할 수 있습니다.";

    @Override
    public Pattern inputRegexCompiler() {
        return REGEX_PATTERN;
    }

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }

}
