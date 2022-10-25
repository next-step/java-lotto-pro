package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 리스트로 구성된 로또 티켓세트 생성 성공")
    public void constructor() {
        Lotto firstLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));

        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(firstLotto, secondLotto));
        assertThat(lottoTicket.getLottoList()).hasSize(2);
    }
}
