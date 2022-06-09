package lotto.model;

import java.util.LinkedList;
import java.util.List;

public class Receipt {
    private final Money money;
    private Ticket ticket;
    private Lotteries auto;
    private Lotteries manual;

    public Receipt(Money input) {
        money = input;
        exchange();
    }

    public Money getMoney() {
        return money;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void addManualGames(Lotteries games) {
        manual = games;
        ticket.use(manual.size());
    }

    public void addAutoGames(Lotteries games) {
        auto = games;
        ticket.use(auto.size());
    }

    public int getAutoGameCount() {
        return auto == null ? 0 : auto.size();
    }

    public int getManualGameCount() {
        return manual == null ? 0 : manual.size();
    }

    public Lotteries getBuyingGames() {
        List<Lottery> lotteries = new LinkedList<>();
        if (getManualGameCount() > 0) {
            lotteries.addAll(manual.getLotteries());
        }
        lotteries.addAll(auto.getLotteries());
        return new Lotteries(lotteries);
    }

    private void exchange() {
        ticket = new Ticket(money);
    }
}
