package step3.model;

import step3.constant.ErrorMessageConstant;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoResult {
    private static final int LOTTO_NUMBER_SIZE = 6;
    Set<LottoNumber> lottoNumbers;

    public LottoResult(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new HashSet<>(lottoNumbers);
        checkLottoOutOfSize();
    }

    public LottoResult(String[] lottoNumbersText) {
        if (lottoNumbersText == null || lottoNumbersText.length == 0) {
            throw new RuntimeException(ErrorMessageConstant.EMPTY_TEXT);
        }
        this.lottoNumbers = getLottoNumbersFromTexts(lottoNumbersText);
        checkLottoOutOfSize();
    }

    private HashSet<LottoNumber> getLottoNumbersFromTexts(String[] lottoNumbers) {
        HashSet<LottoNumber> result = new HashSet<>();
        for (String numberText : lottoNumbers) {
            result.add(new LottoNumber(numberText));
        }
        return result;
    }

    private void checkLottoOutOfSize() {
        if (this.lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new RuntimeException(ErrorMessageConstant.NOT_LOTTO_SIZE);
        }
    }

    public int getEqualCount(LottoResult o) {
        Set<LottoNumber> checkNumbers = lottoNumbers;
        checkNumbers.retainAll(o.lottoNumbers);
        return checkNumbers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
