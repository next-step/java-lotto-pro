package lotto.winningnumber.validation;

import java.util.List;

public interface WinningNumberValidator {

    String ERROR_COUNT_MESSAGE = "[ERROR] 당첨 번호의 갯수를 다시 확인해주세요.";

    void validate(List<String> winningNumbers);
}
