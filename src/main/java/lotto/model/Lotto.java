package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.Config.LOTTO_SIZE;

public class Lotto {
    private List<LottoNumber> lottoNumber;

    public Lotto(List<Integer> numbers) {
        this.validateLotto(numbers);
        this.lottoNumber = numbers.stream()
                .map((number) -> new LottoNumber(number))
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumber() {
        return this.lottoNumber;
    }

    private void validateLotto(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개로 구성되어 있어야합니다.");
        }
    }
}
