package lottoauto.service;

import lottoauto.wrapper.Lotto;
import lottoauto.wrapper.Number;
import lottoauto.wrapper.Price;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    List<Lotto> listLotto;
    Lotto winnerLotto;
    public LottoTicket() {
        this.listLotto = new ArrayList<>();
    }

    public LottoTicket(Lotto winnerLotto) {
        this.listLotto = new ArrayList<>();
        this.winnerLotto = winnerLotto;
    }

    public void add(Lotto lotto) {
        listLotto.add(lotto);
    }

    public void addAll(Price price) {
        for (int i = 0; i < price.getTryTimes(); i++) {
            listLotto.add(new Lotto());
        }
    }

    public void printAll() {
        for (Lotto lotto : listLotto) {
            System.out.println(lotto.toString());
        }
    }

    public Lotto get(int index) {
        return listLotto.get(index);
    }


    public int size() {
        return listLotto.size();
    }

    public int compareTickets(Lotto compareLotto) {
        return winnerLotto.compare(compareLotto.toList());
    }

    public boolean compareBonusTickets(Lotto compareLotto) {
        return winnerLotto.compareBonus(compareLotto.toList());
    }

    public void getWinnerLotto(Lotto winnerLotto) {
        this.winnerLotto = winnerLotto;
    }
}
