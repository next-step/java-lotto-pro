package lotto.fixture;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.Arrays;

public class LottoTicketFixture {
    public static LottoTicket create() {
        return LottoTicket.create(
                Arrays.asList(
                        LottoNumber.get(1),
                        LottoNumber.get(2),
                        LottoNumber.get(3),
                        LottoNumber.get(4),
                        LottoNumber.get(5),
                        LottoNumber.get(6)
                )
        );
    }
}
