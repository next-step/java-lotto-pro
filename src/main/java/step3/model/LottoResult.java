package step3.model;

import step3.constant.ErrorMessageConstant;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {
    private static final int LOTTO_NUMBER_SIZE = 6;
    List<LottoNumber> lottoNumbers;

    public LottoResult(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers.stream().distinct().collect(Collectors.toList());
        checkLottoOutOfSize();
    }

    public LottoResult(String[] lottoNumbersText) {
        if (lottoNumbersText == null || lottoNumbersText.length == 0) {
            throw new RuntimeException(ErrorMessageConstant.EMPTY_TEXT);
        }
        this.lottoNumbers = getLottoNumbersFromTexts(lottoNumbersText);
        checkLottoOutOfSize();
    }

    private List<LottoNumber> getLottoNumbersFromTexts(String[] lottoNumbers) {
        HashSet<LottoNumber> lottoSet = new HashSet<>();
        for (String numberText : lottoNumbers) {
            lottoSet.add(new LottoNumber(numberText));
        }
        List<LottoNumber> result = new ArrayList<>(lottoSet);
        Collections.sort(result);
        return result;
    }

    private void checkLottoOutOfSize() {
        if (this.lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new RuntimeException(ErrorMessageConstant.NOT_LOTTO_SIZE);
        }
    }

    public int getEqualCount(LottoResult o) {
        List<LottoNumber> checkNumbers = lottoNumbers;
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
