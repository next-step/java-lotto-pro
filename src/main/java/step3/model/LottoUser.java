package step3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import step3.domain.LottoElement;
import step3.domain.LottoTicket;
import step3.domain.Money;
import step3.domain.Ticket;

public class LottoUser {

    private Money money = null;
    private Ticket ticket = null;
    private List<LottoTicket> lottoTickets = new ArrayList<>();

    public boolean setMoney(String money) {
        try {
            this.money = new Money(money);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean buyTicket() {
        try {
            this.ticket = new Ticket(money);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    public void buyLotto(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<List<LottoElement>> getLottoNumbers() {
        return lottoTickets.stream().map(LottoTicket::getLottoNumbers).collect(Collectors.toList());
    }

    public Money getMoney() {
        return money;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
