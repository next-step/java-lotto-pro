package lotto.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.ExceptionType;

public class Lotto {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private final List<LottoNo> lottoNumbers;

    public Lotto(List<LottoNo> lottoNumbers) {
        validateLottoNumberSize(lottoNumbers);
        lottoNumbers = lottoNumbers.stream().sorted(Comparator.comparing(LottoNo::getLottoNo))
            .collect(Collectors.toList());
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoNumberSize(List<LottoNo> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(
                ExceptionType.INVALID_LOTTO_NUMBER_SIZE.getMessage());
        }
    }

    public int getWinningOfNumbersCount(WinningNumbers winningNumbers) {
        int countOfMatch = (int) winningNumbers.getWinningNumbers().stream()
            .filter(lottoNumbers::contains).count();
        countOfMatch += winningNumbers.bonusCount(this);

        return countOfMatch;
    }

    public boolean contains(int number) {
        return this.lottoNumbers.contains(new LottoNo(number));
    }

    public List<LottoNo> getNumbers() {
        return lottoNumbers;
    }
}
