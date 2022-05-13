package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {
    @Test
    @DisplayName("로또 티켓들과 당첨 번호를 파라미터로 LottoResult 객체가 생성되어야 한다")
    void create() {
        // given
        final LottoTickets lottoTickets = new LottoTickets(10);
        final LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        final LottoResult lottoResult = new LottoResult(lottoTickets, winningNumbers);

        // then
        assertThat(lottoResult).isInstanceOf(LottoResult.class);
        assertThat(lottoResult).isEqualTo(new LottoResult(lottoTickets, winningNumbers));
    }
}
