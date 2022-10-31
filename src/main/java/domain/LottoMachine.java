package domain;

import java.util.List;

public interface LottoMachine {

    Lotto createLottoNumber();

    List<Lotto> purchaseLotte(int lottoTicketCount);
}
