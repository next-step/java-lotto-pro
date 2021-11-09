package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTicketTest {
    private List<LottoNumbers> result;
    private LotteryTicket lotteryTicket;

    @BeforeEach
    void setUp() {
        result = Arrays.asList(LottoNumbers.of("1,2,3,4,5,6"));
        lotteryTicket = new LotteryTicket(result);
    }

    @DisplayName("같은 LottoNumbers를 가졌다면 동등하다")
    @Test
    void testEquals() {
        assertThat(lotteryTicket).isEqualTo(new LotteryTicket(result));
    }

    @DisplayName("Record에 당첨 기록을 한다")
    @Test
    void testWriteRecord() {
        WinningLottoNumbers winningNumber = new WinningLottoNumbers(LottoNumbers.of("1,2,3,4,5,6"));
        Record record = new Record(lotteryTicket, winningNumber);
        assertThat(record.getWinningCount(Rank.FIRST)).isEqualTo(1);
    }

    @DisplayName("String[]으로 생성 가능")
    @Test
    void testCreateTexts() {
        String[] texts = {"1,2,3,4,5,6"};
        assertThat(lotteryTicket).isEqualTo(new LotteryTicket(texts));
    }
}
