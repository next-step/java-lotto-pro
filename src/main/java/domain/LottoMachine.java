package domain;

public interface LottoMachine {
    Lotto createLottoNumber();

    Lottos purchaseLotto(int lottoTicketCount);

}
