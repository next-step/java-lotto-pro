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

    public static LottoNumbers getRandomSixNumbers() {
        Collections.shuffle(LottoNumber.RANGE);
        return new LottoNumbers(LottoNumber.RANGE.subList(0, 6).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList())
        );
    }

    public static LottoNumbers gainNumbers(String numbersWithComma) {
        List<LottoNumber> winnerNumbers = split(numbersWithComma);
        return new LottoNumbers(winnerNumbers);
    }

    private static List<LottoNumber> split(String numbersWithComma) {
        return Arrays.stream(numbersWithComma.replace(" ", "").split(","))
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}


