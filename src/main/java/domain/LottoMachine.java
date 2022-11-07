package domain;

public interface LottoMachine {

    Lottos purchaseLotto(int lottoTicketCount, Lottos lottos);

    public Lotto splitPurchaseLottoNumbers(String inputWinLottNumbers);

}
