package lotto.ticket;


import lotto.system.MessageConstant;

public class WinnerLottoTicket {
    private final LottoTicket lotto;
    private final int bonusNo;

    public WinnerLottoTicket(LottoTicket lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
        if(matchBonus(lotto)){
            throw new IllegalArgumentException(MessageConstant.ERROR_VALID_NOT_WINNER_NUMBER_SELECT);
        }
    }

    public LottoTicket getLotto(){
        return this.lotto;
    }

    public boolean matchBonus(LottoTicket ticket) {
        return ticket.contains(bonusNo);
    }

}
