package lotto.domain;

import lotto.util.Constants;

public class Ticket {
    private static final String STR_LOTTO_NUM_LIST = "[%d, %d, %d, %d, %d, %d]\n";

    public LottoNumbers lottoNumbers;
    public BonusNum bonusNum;

    public Ticket() {
        this.lottoNumbers = new LottoNumbers();
    }

    public Ticket(String ticketStr) {
        this.lottoNumbers = new LottoNumbers(ticketStr);
    }

    public Ticket(String ticketStr, String bonusNumStr) {
        this.lottoNumbers = new LottoNumbers(ticketStr);
        this.bonusNum = new BonusNum(bonusNumStr);

        isBonusballDuplicate();
    }

    public String toString() {
        return String.format(STR_LOTTO_NUM_LIST, lottoNumbers.numbers);
    }

    public boolean isBonusballMatch(BonusNum bonusNum) {
        return this.lottoNumbers.isNumberContains(bonusNum.num);
    }

    public int getCountOfMatch(LottoNumbers winningNumbers) {
        return this.lottoNumbers.getCountOfMatch(winningNumbers);
    }

    private void isBonusballDuplicate() {
        if (this.lottoNumbers.isNumberContains(this.bonusNum.num)) {
            throw new IllegalArgumentException(Constants.ERR_DUP_NUMBERS);
        }
    }
}
