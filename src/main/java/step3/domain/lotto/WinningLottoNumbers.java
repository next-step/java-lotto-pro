package step3.domain.lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static step3.domain.lotto.LottoNumbers.DEFAULT_LOTTO_SIZE;
import static step3.type.ErrorMessageType.INPUT_ONLY_ALLOW_NUMBER;
import static step3.type.ErrorMessageType.LOTTO_NUMBER_WRONG_SIZE;

public class WinningLottoNumbers {

    private static final String REGEX = ",";

    private final LottoNumbers lottoNumbers;

    public WinningLottoNumbers(String input) {
        this.lottoNumbers = new LottoNumbers(getLottoNumbers(input));
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

    public List<LottoNumber> value() {
        return Collections.unmodifiableList(lottoNumbers.value());
    }

    @Override
    public String toString() {
        return "WinningLottoNumber{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
