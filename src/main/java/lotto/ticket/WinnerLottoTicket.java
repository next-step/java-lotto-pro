package lotto.ticket;


public class WinnerLottoTicket {
    private final LottoTicket lotto;
    private final int bonusNo;

    public WinnerLottoTicket(LottoTicket lotto, int bonusNo) {
        this.lotto = lotto;
        if(this.lotto.contains(bonusNo)){
            throw new IllegalArgumentException();
        }
        this.bonusNo = bonusNo;
    }

    public LottoTicket getLotto(){
        return this.lotto;
    }

    public boolean matchBonus(LottoTicket ticket) {
        return ticket.contains(bonusNo);
    }

}
