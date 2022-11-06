package lotto;

import lotto.common.LottoAutoUtils;
import lotto.common.exception.LottoNullException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static lotto.common.Constants.DELIMITER;
import static lotto.common.Constants.LOTTO_LENGTH;

// 일급콜렉션
public class LottoNumbers {
    private List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        setUp();
    }

    public LottoNumbers(String inputStr) {
        setUp();
        stringToNumbersByToken(inputStr);
    }

    public LottoNumbers(List<LottoNumber> inputNumList) {
        this.lottoNumbers = new ArrayList<>(inputNumList);
    }

    private void setUp() {
        lottoNumbers = new ArrayList<>();
    }

    private void stringToNumbersByToken(String inputStr) {
        Optional.ofNullable(inputStr)
                .orElseThrow(() -> new LottoNullException("입력하신 내용이 없습니다."));
        String[] str = inputStr.split(DELIMITER);
        if (str.length != LOTTO_LENGTH) {
            throw new IllegalArgumentException("로또의  길이는 " + LOTTO_LENGTH + " 입니다.");
        }
        for (String number : str) {
            this.lottoNumbers.add(LottoNumber.of(new LottoAutoUtils().stringToNumber(number)));
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public void add(LottoNumber lottoNumber) {
        lottoNumbers.add(lottoNumber);
    }

    public void sort() {
        List<Integer> sortLottoNumbers = new ArrayList<>();
        for (LottoNumber lottoNumber : this.lottoNumbers) {
            sortLottoNumbers.add(lottoNumber.getLottoNum());
        }
        this.lottoNumbers = new ArrayList<>();
        for (int num : sortLottoNumbers) {
            lottoNumbers.add(LottoNumber.of(num));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
