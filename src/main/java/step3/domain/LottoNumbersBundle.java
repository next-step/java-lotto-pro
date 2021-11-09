package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import step3.domain.strategy.numbers.NumbersStrategy;

public class LottoNumbersBundle {
    private final List<LottoNumbers> lottoNumbersBundle = new ArrayList<>();

    public LottoNumbersBundle() {
    }

    public void addLottoNumbers(NumbersStrategy numbersStrategy) {
        List<Integer> numbers = numbersStrategy.getNumbers();
        LottoNumbers lottoNumbers = LottoNumbers.of(numbers);

        lottoNumbersBundle.add(lottoNumbers);
    }

    public LottoRanks lottoRanksOf(WinningLotto winningLotto) {
        LottoRanks lottoRanks = new LottoRanks();

        for (LottoNumbers lottoNumbers : lottoNumbersBundle) {
            int matchCount = winningLotto.containCount(lottoNumbers);
            boolean isBonusMatch = winningLotto.bonusMatch(lottoNumbers);
            lottoRanks.matchIncrementCount(matchCount, isBonusMatch);
        }

        return lottoRanks;
    }

    public int size() {
        return lottoNumbersBundle.size();
    }

    public List<LottoNumbers> getLottoNumbersBundle() {
        return lottoNumbersBundle;
    }

    public List<String> getResult() {
        return lottoNumbersBundle.stream()
            .map(LottoNumbers::toCommaSerialize)
            .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public void merge(LottoNumbersBundle autoLottoNumbersBundle) {
        lottoNumbersBundle.addAll(autoLottoNumbersBundle.getLottoNumbersBundle());
    }
}
