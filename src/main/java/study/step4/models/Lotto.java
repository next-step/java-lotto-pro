package study.step4.models;

import study.step4.exception.LottoInvalidSizeException;
import study.step4.helper.LottoStringParser;

import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private List<LottoNumber> lottoNumbers;

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

    public int countNumberOfMatching(Lotto winLotto) {
        return (int) lottoNumbers.stream()
                .filter(winLotto::containsNumber)
                .count();
    }

    private boolean containsNumber(LottoNumber lottoNumber) {
        return lottoNumbers.stream()
                .anyMatch(number -> number.compare(lottoNumber) == 0);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
