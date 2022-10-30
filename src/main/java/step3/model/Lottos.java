package step3.model;

import java.util.ArrayList;
import java.util.List;

import static step3.constant.Constant.EACH_LOTTO_PRICE;

public class Lottos {
    public List<Lotto> lottos = new ArrayList<>();
    public int purchasedCount;


    public void addLottos() {
        for (int i = 0; i < purchasedCount; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
    }

    public void setPurchasedCount(int price) {
        this.purchasedCount = price / EACH_LOTTO_PRICE;
    }

    public int getPurchasedCount() {
        return purchasedCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }


}
