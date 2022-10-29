package step3.domain.lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static step3.type.ErrorMessageType.INPUT_ONLY_ALLOW_NUMBER;

public class WinningLottoNumbers {

    private static final String REGEX = ",";

    private final List<LottoNumber> lottoNumbers;

    public WinningLottoNumbers(String input) {
        this.lottoNumbers = getLottoNumbers(input);
    }

    private List<LottoNumber> getLottoNumbers(String input) {
        return Arrays.stream(getSplit(input))
                .map(s -> {
                    try {
                        int lottoNumber = Integer.parseInt(s.trim());
                        return new LottoNumber(lottoNumber);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(INPUT_ONLY_ALLOW_NUMBER.getMessage());
                    }
                })
                .collect(Collectors.toList());
    }

    private String[] getSplit(String input) {
        return input.split(REGEX);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return "WinningLottoNumber{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
