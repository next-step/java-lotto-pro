package step3.model;

import step3.constant.ErrorMessageConstant;
import step3.constant.LottoConstant;
import step3.exception.LottoFormatException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoResult {
    List<LottoNumber> lottoNumbers;

    public LottoResult(List<LottoNumber> lottoNumbers) {
        checkLottoOutOfSize((int) lottoNumbers.stream().distinct().count());
        this.lottoNumbers = lottoNumbers.stream().distinct().sorted().collect(Collectors.toList());
    }

    public LottoResult(String[] lottoNumbersText) {
        if (lottoNumbersText == null || lottoNumbersText.length == 0) {
            throw new IllegalArgumentException(ErrorMessageConstant.EMPTY_TEXT);
        }
        this.lottoNumbers = getLottoNumbersFromTexts(lottoNumbersText);
    }

    private List<LottoNumber> getLottoNumbersFromTexts(String[] lottoNumbers) {
        HashSet<LottoNumber> lottoSet = new HashSet<>();
        for (String numberText : lottoNumbers) {
            lottoSet.add(new LottoNumber(numberText));
        }
        checkLottoOutOfSize(lottoSet.size());
        return new ArrayList<>(lottoSet).stream().sorted().collect(Collectors.toList());
    }

    private void checkLottoOutOfSize(int lottoNumbersSize) {
        if (lottoNumbersSize != LottoConstant.PICK_LOTTO_MAX_NUM) {
            throw new LottoFormatException(ErrorMessageConstant.NOT_LOTTO_SIZE);
        }
    }

    public int getEqualCount(LottoResult otherLottoResult) {
        List<LottoNumber> checkNumbers = lottoNumbers;
        checkNumbers.retainAll(otherLottoResult.lottoNumbers);
        return checkNumbers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
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
