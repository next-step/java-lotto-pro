package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class LotteryTicket {
    private final List<Lotto> lotteryTicket = new ArrayList<>();

    public LotteryTicket() {
    }

    public List<Lotto> getLotteryTicket() {
        return this.lotteryTicket;
    }

    public void add(Lotto lotto) {
        this.lotteryTicket.add(lotto);
    }

    public int getCount() {
        return this.lotteryTicket.size();
    }
}
