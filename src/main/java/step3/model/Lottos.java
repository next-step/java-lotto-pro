package step3.model;

import java.util.List;

import static step3.constant.Constant.EACH_LOTTO_PRICE;

public class Lottos {
    public List<Lotto> lottos;
    public int purchasedCount;

    public void setPurchasedCount(int price) {
        this.purchasedCount = price / EACH_LOTTO_PRICE;
    }


}
