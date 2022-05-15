package lotto;

public class LottoMachine {
    static Lottos lottos;
    static final int LOTTO_PRICE = 1000;
    static final String PRINT_PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";

    public static Lottos createLottos(int i) {
        int lottoPaperCount = i / LOTTO_PRICE;

        lottos = new Lottos(lottoPaperCount);
        return lottos;
    }

    public static void printLottoPurchase() {
        System.out.println(lottos.getLottosSize() + PRINT_PURCHASE_COUNT_MESSAGE);
        lottos.printLottos();
    }
}
