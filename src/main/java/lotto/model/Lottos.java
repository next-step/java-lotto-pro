package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final static int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;

    public Lottos(long purchasePrice) {
        this.lottos = new ArrayList<>();

        int count = getPurchaseLottoCount(purchasePrice);
        for (int i = 0; i < count; i++) {
            this.lottos.add(new Lotto());
        }
    }

    private int getPurchaseLottoCount(long purchasePrice) {
        if(purchasePrice < LOTTO_PRICE){
            throw new IllegalArgumentException("금액이 적어 구입할 수 없습니다.");
        }

        return (int) (purchasePrice / LOTTO_PRICE);
    }

    public int getLottosSize() {
        return this.lottos.size();
    }
}
