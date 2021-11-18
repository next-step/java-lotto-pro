package lotto.domain;

import lotto.exception.IllegalLottoNumberSizeException;
import lotto.exception.NumberDuplicationException;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoNumbers {
    public static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLottoNumbers(List<Integer> lottoNumbers, int bonusNumber) {
        checkLottoNumberSize(lottoNumbers);
        checkNumberDuplication(lottoNumbers);
        this.lottoNumbers = getLottoNumbers(lottoNumbers);
        this.bonusNumber = LottoNumber.from(bonusNumber);
    }

    private List<LottoNumber> getLottoNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    private void checkNumberDuplication(List<Integer> lottoNumbers) {
        if (new HashSet<>(lottoNumbers).size() < LOTTO_NUMBER_SIZE) {
            throw new NumberDuplicationException();
        }
    }

    private void checkLottoNumberSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalLottoNumberSizeException();
        }
    }

    public boolean hasBonusNumber(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
