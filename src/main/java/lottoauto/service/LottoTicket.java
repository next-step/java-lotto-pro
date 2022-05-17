package lottoauto.service;

import lottoauto.wrapper.Lotto;
import lottoauto.wrapper.Price;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    List<Lotto> listLotto;

    public LottoTicket() {
        this.listLotto = new ArrayList<>();
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
}
