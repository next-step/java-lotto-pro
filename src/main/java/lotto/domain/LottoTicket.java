package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private LottoNumbers numbers;
    
    public LottoTicket(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public LottoTicket(NumberGenerator numberGenerator) {
        List<Integer> generatedNumber = numberGenerator.generate();
        Collections.sort(generatedNumber);
        this.numbers = new LottoNumbers(generatedNumber);
    }

    private List<LottoNumber> convertIntToLottoNumbers(List<Integer> generatedNumber) {
        List<LottoNumber> lottoNumbers = new ArrayList<LottoNumber>();
        if (generatedNumber.size() > 6) {
            throw new IllegalArgumentException("Array size should be 6.");
        }

        for (Integer integer : generatedNumber) {
            lottoNumbers.add(new LottoNumber(integer));
        }

        return lottoNumbers;
    }

    public int[] getNumbersAsArray() {
        return this.numbers.getNumbersAsArray();
    }

    public boolean contains(LottoNumber number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        return Arrays.toString(getNumbersAsArray());
    }
}
