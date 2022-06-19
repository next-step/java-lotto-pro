package lotto.model;

import java.util.LinkedList;
import java.util.List;

public class Receipt {
    private final Lotteries auto;
    private final Lotteries manual;

    public Receipt(Lotteries auto, Lotteries manual) {
        this.auto = auto;
        this.manual = manual;
    }

    public int getAutoGameCount() {
        return auto == null ? 0 : auto.size();
    }

    public int getManualGameCount() {
        return manual == null ? 0 : manual.size();
    }

    public Lotteries getLotteries() {
        List<Lottery> lotteries = new LinkedList<>();
        if (getManualGameCount() > 0) {
            lotteries.addAll(manual.getLotteries());
        }
        lotteries.addAll(auto.getLotteries());
        return new Lotteries(lotteries);
    }

    public List<Lottery> getAllLotteries() {
        List<Lottery> lotteries = new LinkedList<>();
        if (getManualGameCount() > 0) {
            lotteries.addAll(manual.getLotteries());
        }
        lotteries.addAll(auto.getLotteries());
        return lotteries;
    }

    public Money getMoney() {
        return new Money((getAutoGameCount() + getManualGameCount() * 1000));
    }
}
