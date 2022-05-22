package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerTicket {

    private LottoNumbers numbers;

    public WinnerTicket(String stringNumbers) {
        this.numbers = convertStringNumberToLottoNumbers(stringNumbers);
    }

    private LottoNumbers convertStringNumberToLottoNumbers(String stringNumber) {
        NumberGenerator generator = new LottoNumberGenerator();
        return new LottoNumbers(generator.generate(stringNumber));
    }

    public int[] getNumbersAsArray() {
        return this.numbers.getNumbersAsArray();
    }

    public boolean contains(LottoNumber number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
