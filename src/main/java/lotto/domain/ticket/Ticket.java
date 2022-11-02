package lotto.domain.ticket;

import lotto.util.Constants;

public class Ticket {
    public LottoNumbers lottoNumbers;
    public LottoNumber bonusNum;

    public Ticket() {
        this.lottoNumbers = new LottoNumbers();
    }

    public Ticket(String ticket) {
        this.lottoNumbers = new LottoNumbers(ticket);
    }

    public Ticket(String ticket, String bonusNum) {
        this.lottoNumbers = new LottoNumbers(ticket);
        this.bonusNum = new LottoNumber(bonusNum);

        isBonusballDuplicate();
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }

    public boolean isBonusballMatch(LottoNumber bonusNum) {
        return this.lottoNumbers.isNumberContains(bonusNum);
    }

    public int getCountOfMatch(LottoNumbers winningNumbers) {
        return this.lottoNumbers.getCountOfMatch(winningNumbers);
    }

    private void isBonusballDuplicate() {
        if (this.lottoNumbers.isNumberContains(this.bonusNum)) {
            throw new IllegalArgumentException(Constants.ERR_DUP_NUMBERS);
        }
    }
}
