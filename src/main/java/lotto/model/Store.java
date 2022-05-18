package lotto.model;

public class Store {
    private final int lottoOneGamePrice;

    public Store(int lottoPrice) {
        this.lottoOneGamePrice = lottoPrice;
    }

    public Lottos giveLotto(int receiveMoney) {
        return new Lottos(receiveMoney / lottoOneGamePrice);
    }
}
