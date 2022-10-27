package lotto.winningnumber.validation;

import java.util.List;

public interface WinningNumberValidator {

    String ERROR_COUNT_MESSAGE = "[ERROR] 당첨 번호의 갯수를 다시 확인해주세요.";
    String ERROR_WINNING_NUMBER_TYPE_MESSAGE = "[ERROR] 당첨 번호에 숫자가 아닌 값이 포함되어 있습니다.";
    String ERROR_RANGE_MESSAGE = "[ERROR] 당첨번호에 1 ~ 45 사이의 숫자가 아닌 값이 포함되어 있습니다.";

    void validate(List<String> winningNumbers);
}
