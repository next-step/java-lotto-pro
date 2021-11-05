package lotto.view.strategy;

import lotto.exception.InvalidInputException;
import utils.Console;

import java.util.regex.Pattern;

public interface Input {

    String getMessage();

    Pattern inputRegexCompiler();

    String getErrorMessage();

    /**
     * 입력 값에 대한 유효성 검사
     */
    default String getValue() {
        System.out.println(this.getMessage());
        String inputValue = Console.readLine();

        if (!this.inputRegexCompiler().matcher(inputValue).matches()) {
            throw new InvalidInputException(this.getErrorMessage());
        }

        return inputValue;
    }

}
