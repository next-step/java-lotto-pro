package step3.domain;

import step3.enums.Rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {



    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumber) {
        if(lottoNumber.size() != Rule.LOTTO_END_NUMBER.getRange()){
            throw new IllegalArgumentException("6자리 숫자만 가능합니다.");
        }
        this.lottoNumbers = new ArrayList<>(lottoNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public static LottoNumbers gainNumbers(String numbersWithComma) {
        List<LottoNumber> winnerNumbers = LottoFactory.split(numbersWithComma);
        return new LottoNumbers(winnerNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}


