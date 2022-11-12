package study.step4.models;

import study.step4.exception.LottoInvalidSizeException;
import study.step4.helper.LottoStringParser;

import java.util.List;

public class Lotto {
    public static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateLottoSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(String lottoNumbers) {
        this(LottoStringParser.stringToLottoNumbers(lottoNumbers));
    }

    private void validateLottoSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new LottoInvalidSizeException(String.format("로또 사이즈는 %d이어야 합니다.", LOTTO_SIZE));
        }
    }

    public int countNumberOfMatching(WinningLotto winningLotto) {
        return (int) lottoNumbers.stream()
                .filter(winningLotto::contains)
                .count();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public boolean hasBonusBall(LottoNumber bonusBall) {
        return lottoNumbers.contains(bonusBall);
    }
}
