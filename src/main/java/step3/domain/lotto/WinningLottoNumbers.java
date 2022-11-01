package step3.domain.lotto;

import java.util.*;
import java.util.stream.Collectors;

import static step3.domain.lotto.LottoNumbers.DEFAULT_LOTTO_SIZE;
import static step3.type.ErrorMessageType.*;

public class WinningLottoNumbers {

    private static final String REGEX = ",";

    private final List<LottoNumber> lottoNumbers;

    public WinningLottoNumbers(String input) {
        List<LottoNumber> numbers = getLottoNumbers(input);
        validateDuplicate(numbers);
        this.lottoNumbers = numbers;
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers);
        if (lottoNumberSet.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE.getMessage());
        }
    }

    private List<LottoNumber> getLottoNumbers(String input) {
        return Arrays.stream(getStrings(input))
                .map(s -> {
                    try {
                        int lottoNumber = Integer.parseInt(s.trim());
                        return LottoNumber.of(lottoNumber);
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
        return Collections.unmodifiableList(lottoNumbers);
    }

    @Override
    public String toString() {
        return "WinningLottoNumber{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
