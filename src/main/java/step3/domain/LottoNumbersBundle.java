package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import step3.domain.strategy.numbers.NumbersStrategy;

public class LottoNumbersBundle {
    private final List<LottoNumbers> lottoNumbersBundle = new ArrayList<>();

    public LottoNumbersBundle() {
    }

    public void addLottoNumbers(NumbersStrategy numbersStrategy) {
        lottoNumbersBundle.add(new LottoNumbers(numbersStrategy));
    }

    public int size() {
        return lottoNumbersBundle.size();
    }

    public LottoRanks lottoRanksOf(LottoNumbers winLottoNumbers) {
        LottoRanks lottoRanks = new LottoRanks();
        for (LottoNumbers lottoNumbers : lottoNumbersBundle) {
            lottoRanks.matchOfMatchCount(lottoNumbers.containCount(winLottoNumbers));
        }
        return lottoRanks;
    }

    public List<String> toList() {
        List<String> result = new ArrayList<>();
        for (LottoNumbers lottoNumbers : lottoNumbersBundle) {
            result.add(lottoNumbers.toString());
        }
        return Collections.unmodifiableList(result);
    }
}
