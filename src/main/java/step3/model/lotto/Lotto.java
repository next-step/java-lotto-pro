package step3.model.lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import step3.model.util.InputValidation;
import step3.model.value.Rule;

public class Lotto{
    private List<LottoNumber> lotto;
    public Lotto(String input) {
        InputValidation.validateEmpty(input);
        List<String> lottoNumbers = splitLottoNumbers(input);
        this.lotto = createLotto(lottoNumbers);
    }

    private List<LottoNumber> createLotto(List<String> lottoNumbers) {
        InputValidation.validateLength(lottoNumbers);
        InputValidation.validateDuplication(lottoNumbers);
        return lottoNumbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    private List<String> splitLottoNumbers(String input) {
        return Arrays.stream(input.split(Rule.DELIMITER))
                .map(String::trim).distinct().collect(Collectors.toList());
    }
    public boolean isMatched(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lotto)) {
            return false;
        }
        Lotto that = (Lotto) o;
        return Objects.equals(lotto, that.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    @Override
    public String toString() {
        return this.lotto.stream().map(
                lottoNumber -> lottoNumber.toString()
        ).collect(Collectors.toList()).toString();
    }
}