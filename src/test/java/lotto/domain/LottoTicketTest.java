package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {
    private LottoTicket lottoTicket;
    private WinningLotto winningLotto;
    private final int manualLottosCount = 3;
    private final int autoLottosCount = 3;

    @BeforeEach
    void setUp() {
        lottoTicket = new LottoTicket(
            Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)),
                new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
            ),
            new LottoTypesCount(manualLottosCount, autoLottosCount));
        winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.valueOf(7));
    }

    @DisplayName("당첨결과 1등부터 5등, 미당첨까지 모두 존재하는지 확인한다")
    @Test
    void createWinningRanks() {
        List<Rank> winningRanks = lottoTicket.createWinningRanks(winningLotto);

        assertThat(winningRanks).containsExactly(
            Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH, Rank.MISS
        );
    }

    @DisplayName("로또 타입별로 카운트 수를 가져오는지 확인한다")
    @Test
    void getCountOfLottoType() {
        assertEquals(manualLottosCount, lottoTicket.getCountOfLottoType(LottoType.MANUAL));
        assertEquals(autoLottosCount, lottoTicket.getCountOfLottoType(LottoType.AUTO));
    }
}
