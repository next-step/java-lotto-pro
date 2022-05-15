package lotto;

public class LottoMachine {
    static Lottos lottos;
    static final int LOTTO_PRICE = 1000;

    public static Lottos createLottos(int i) {
        int lottoPaperCount = i / LOTTO_PRICE;

        lottos = new Lottos(lottoPaperCount);
        return lottos;
    }
}
