package domain;

import java.util.List;

public interface LottoMachine {
    Lotto createLottoNumber();

    Lottos purchaseLotto(int lottoTicketCount);

}
