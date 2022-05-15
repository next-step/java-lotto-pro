package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static step3.constant.LottoInfoConstant.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
        assertThat(testLottoManager.checkWin(new LottoTicket("1,2,3,4,5,6"))).containsEntry("ZERO", 0).containsEntry("ONE", 0).containsEntry("TWO", 1)
            .containsEntry("THREE", 2).containsEntry("FOUR", 1).containsEntry("FIVE", 0).containsEntry("SIX", 2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "3000", "4000", "5000", "6000", "7000", "8000", "9000", "10000", "12000"})
    @DisplayName("금액에 맞춰 로또를 생성한다")
    public void createTicketByMoney(String money) {
        assertThat(lottoManager.buyRandomTicket(money)).isEqualTo(Integer.parseInt(money) / LOTTO_PRICE);
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
