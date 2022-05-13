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
        validatePurchasePrice(purchasePrice);

        return (int) (purchasePrice / LOTTO_PRICE);
    }

    private void validatePurchasePrice(long purchasePrice) {
        if(purchasePrice < LOTTO_PRICE){
            throw new IllegalArgumentException("금액이 적어 구입할 수 없습니다.");
        }

        if(purchasePrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("잔돈이 발생합니다. 천 원단위로 나누어떨어지도록 금액을 입력해야 합니다.");
        }
    }

    public int lottosCount() {
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

    public String numbersToString() {
        StringBuilder sb = new StringBuilder();

        for (Lotto lotto : this.lottos) {
            sb.append(lotto.numbersToString());
            sb.append("\n");
        }

        return sb.toString();
    }
}
