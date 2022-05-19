package step3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import step3.domain.LottoElement;
import step3.domain.LottoTicket;
import step3.domain.Money;

public class LottoUser {

    private Money money = null;
    private int ticket = 0;
    private List<LottoTicket> lottoTickets = new ArrayList<>();

    public boolean setMoney(String money) {
        try {
            this.money = new Money(money);
            return true;
        } catch (IllegalArgumentException e) {
            this.money = new Money(0);
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean setTicket(int ticket) {
        int noTicket = 0;
        this.ticket = ticket;
        return ticket != noTicket;
    }


    public void setUserLotto(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<List<LottoElement>> getLottoNumbers() {
        return lottoTickets.stream().map(LottoTicket::getLottoNumbers).collect(Collectors.toList());
    }

    public Money getMoney() {
        return money;
    }

    public int getTicket() {
        return ticket;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

}
