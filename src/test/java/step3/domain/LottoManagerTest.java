package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.enums.LottoReward;

public class LottoManagerTest {

    private LottoManager lottoManager;

    @BeforeEach
    public void init() {
        lottoManager = new LottoManager();
    }

    @Test
    @DisplayName("로또 번호를 가져올수 있어야한다")
    public void getLottoNumbersTest() {
        LottoManager testLottoManager = initTestManager();
        assertThat(testLottoManager.getLottoNumbers().toString()).isEqualTo(
            "[[1, 2, 3, 4, 5, 6], [1, 2, 3, 4, 5, 6], [1, 2, 3, 4, 7, 8], [1, 2, 3, 7, 8, 9], [1, 2, 3, 7, 8, 9], [1, 2, 7, 8, 9, 10]]");

    }

    @Test
    @DisplayName("각 로또별 매칭 갯수를 HashMap으로 반환한다")
    public void testCheckWin() {
        LottoManager testLottoManager = initTestManager();
        LottoElement bonusNumber = new LottoElement(7);
        assertThat(testLottoManager.checkWin(new LottoTicket("1,2,3,4,5,6"), bonusNumber))
            .containsEntry(LottoReward.MISS, 0)
            .containsEntry(LottoReward.THREE, 1)
            .containsEntry(LottoReward.FOUR, 2)
            .containsEntry(LottoReward.FIVE, 0)
            .containsEntry(LottoReward.FIVE_BONUS, 1)
            .containsEntry(LottoReward.SIX, 2);
    }


    private LottoManager initTestManager() {
        List<LottoTicket> tickets = new ArrayList<>();
        List<String> lottoSources = new ArrayList<>();
        lottoSources.add("1,2,3,4,5,6");
        lottoSources.add("1,2,3,4,5,6");
        lottoSources.add("1,2,3,4,7,8");
        lottoSources.add("1,2,3,7,8,9");
        lottoSources.add("1,2,3,7,8,9");
        lottoSources.add("1,2,7,8,9,10");

        for (int i = 0; i < lottoSources.size(); i++) {
            tickets.add(new LottoTicket(lottoSources.get(i)));
        }

        return new LottoManager(tickets);
    }


}
