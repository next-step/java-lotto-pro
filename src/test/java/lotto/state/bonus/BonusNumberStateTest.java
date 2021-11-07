package lotto.state.bonus;

import lotto.domain.LotteryTicket;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.WinningLottoNumbers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BonusNumberStateTest {
    private BonusNumberState bonusNumberState;
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    void setUp() {
        List<LottoNumbers> lottoNumbersList = Arrays.asList(
                LottoNumbers.of("1,2,3,7,8,9"),
                LottoNumbers.of("1,2,3,4,7,8"),
                LottoNumbers.of("9,8,3,4,5,6"),
                LottoNumbers.of("1,2,3,4,5,45"),
                LottoNumbers.of("1,2,3,4,5,6")
        );
        LottoNumbers winningNumbers = LottoNumbers.of("1,2,3,4,5,6");
        bonusNumberState = new BonusNumberState(new BonusNumberStateView(), new LotteryTicket(lottoNumbersList), new WinningLottoNumbers(winningNumbers, new LottoNumber(45)));
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void testQuestion() {
        bonusNumberState.printQuestion(System.out);
        assertThat(captor.toString().trim()).isEqualTo("보너스 볼을 입력해 주세요.");
    }

    @Test
    void name() {
        bonusNumberState.printResult("45", System.out);
        assertThat(captor.toString())
                .contains(
                        "3개 일치 (5000원)- 1개",
                        "4개 일치 (50000원)- 2개",
                        "5개 일치, 보너스 볼 일치(30000000원)- 1개",
                        "6개 일치 (2000000000원)- 1개");
    }
}
