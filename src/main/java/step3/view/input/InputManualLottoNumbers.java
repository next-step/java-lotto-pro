package step3.view.input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static step3.domain.lotto.LottoNumbers.DEFAULT_LOTTO_SIZE;
import static step3.type.ErrorMessageType.INPUT_ONLY_ALLOW_NUMBER;
import static step3.type.ErrorMessageType.LOTTO_NUMBER_WRONG_SIZE;

public class InputManualLottoNumbers implements Input<List<Integer>> {

    private static final String REGEX = ",";

    @Override
    public List<Integer> create() {
        String input = scanner.nextLine();
        validateBlank(input);
        return getLottoNumbers(input);
    }

    private List<Integer> getLottoNumbers(String input) {
        return Arrays.stream(getStrings(input))
                .map(s -> {
                    try {
                        return Integer.parseInt(s.trim());
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(INPUT_ONLY_ALLOW_NUMBER.getMessage());
                    }
                })
                .collect(Collectors.toList());
    }

    private String[] getStrings(String input) {
        String[] split = getSplit(input);
        if (DEFAULT_LOTTO_SIZE != split.length) {
            throw new IllegalArgumentException(LOTTO_NUMBER_WRONG_SIZE.getMessage());
        }
        return split;
    }

    private String[] getSplit(String input) {
        return input.split(REGEX);
    }
}
