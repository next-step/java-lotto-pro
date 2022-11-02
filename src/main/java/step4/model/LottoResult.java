package step4.model;

import step4.constant.ErrorMessageConstant;
import step4.constant.LottoConstant;
import step4.exception.LottoFormatException;

import java.util.Arrays;
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
        this(getLottoNumbersFromTexts(lottoNumbersText));
    }

    private static List<LottoNumber> getLottoNumbersFromTexts(String[] lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.length == 0) {
            throw new IllegalArgumentException(ErrorMessageConstant.EMPTY_TEXT);
        }

        return Arrays.stream(lottoNumbers).map(LottoNumber::new).collect(Collectors.toList());
    }

    private void checkLottoOutOfSize(int lottoNumbersSize) {
        if (lottoNumbersSize != LottoConstant.PICK_LOTTO_MAX_NUM) {
            throw new LottoFormatException(ErrorMessageConstant.NOT_LOTTO_SIZE);
        }
    }

    public int getEqualCount(LottoResult otherLottoResult) {
        return (int) this.lottoNumbers.stream().filter(otherLottoResult::isContains).count();
    }


    public boolean isContains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
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
