package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final static int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;

    public Lottos(long purchasePrice) {
        this.lottos = new ArrayList<>();

        int count = purchaseLottoCount(purchasePrice);
        for (int i = 0; i < count; i++) {
            this.lottos.add(new Lotto());
        }
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private int purchaseLottoCount(long purchasePrice) {
        if(purchasePrice < LOTTO_PRICE){
            throw new IllegalArgumentException("금액이 적어 구입할 수 없습니다.");
        }

        return (int) (purchasePrice / LOTTO_PRICE);
    }

    public int lottosSize() {
        return this.lottos.size();
    }

    public long lottosTotalPrice() {
        return (long) this.lottos.size() * LOTTO_PRICE;
    }

    public void compareLottos(WinningLotto winningLotto) {
        for (Lotto lotto : this.lottos) {
            winningLotto.compareWinningLotto(lotto);
        }
    }
}
