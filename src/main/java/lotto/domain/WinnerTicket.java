package lotto.domain;

import lotto.StringParserUtils;

public class WinnerTicket {

    private LottoNumbers numbers;

    private LottoNumber bonusNumber;

    public WinnerTicket(String stringNumbers, LottoNumber bonusNumber) {
        this.numbers = convertStringNumberToLottoNumbers(stringNumbers);
        validateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(LottoNumbers numbers, LottoNumber bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("Bonus number and winner number can't be duplicated.");
        }
    }

    private LottoNumbers convertStringNumberToLottoNumbers(String stringNumber) {
        return new LottoNumbers(StringParserUtils.parseNumbers(stringNumber));
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

    public boolean matchBonus(LottoTicket ticket) {
        return ticket.contains(bonusNumber);
    }
}
