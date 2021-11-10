package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
        String[] textLottoNumbers = {"1,2,3,4,5,6"};
        assertThat(lotteryTicket).isEqualTo(new LotteryTicket(textLottoNumbers));
    }

    @DisplayName("두개의 LotteryTicket을 병합한다")
    @Test
    void testMerge() {
        List<LottoNumbers> addedLottoNumbers = Arrays.asList(LottoNumbers.of("5,6,7,8,9,10"));
        List<LottoNumbers> resultLottoNumbers = new ArrayList<>(result);
        resultLottoNumbers.addAll(addedLottoNumbers);
        assertThat(lotteryTicket.merge(new LotteryTicket(addedLottoNumbers)))
                .isEqualTo(new LotteryTicket(resultLottoNumbers));
    }

    @DisplayName("수동 번호 갯수를 반환한다")
    @Test
    void testGetManualLottoSize() {
        assertThat(lotteryTicket.getManualLottoSize()).isEqualTo(1);
    }

    @DisplayName("자동 번호 갯수를 반환한다")
    @Test
    void testGetAutoLottoSize() {
        CollectionsShuffler shuffler = new CollectionsShuffler();
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(LottoNumbers.of("5,6,7,8,9,10"));
        lottoNumbers.addAll(Arrays.asList(LottoNumbers.create(shuffler), LottoNumbers.create(shuffler)));
        assertThat(new LotteryTicket(lottoNumbers).getAutoLottoSize()).isEqualTo(2);
    }
}
