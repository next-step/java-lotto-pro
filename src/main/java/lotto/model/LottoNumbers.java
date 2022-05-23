package lotto.model;

import lotto.generator.LottoNumbersGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers createLottoNumbers(LottoNumbersGenerator lottoNumbersGenerator) {
        List<LottoNumber> lottoNumbers = Collections.unmodifiableList(lottoNumbersGenerator.drawNumbers());
        return new LottoNumbers(lottoNumbers);
    }

    public int matchCount(LottoNumbers winningNumbers) {
        List<LottoNumber> copiedWinningNumbers = new ArrayList<>(winningNumbers.lottoNumbers);
        copiedWinningNumbers.retainAll(lottoNumbers);
        return copiedWinningNumbers.size();
    }

    public int size() {
        return lottoNumbers.size();
    }

    public boolean hasBonusNumber(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
