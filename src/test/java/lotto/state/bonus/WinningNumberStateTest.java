package lotto.state.bonus;

import lotto.domain.LotteryTicket;
import lotto.domain.LottoNumbers;
import lotto.state.SecondState;
import lotto.state.SecondStateView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberStateTest {
    private WinningNumberState winningNumberState;
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
        winningNumberState = new WinningNumberState(new SecondStateView(), new LotteryTicket(lottoNumbersList));
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @DisplayName("지난주 당첨 번호를 묻는다")
    @Test
    void testQuestion() {
        winningNumberState.printQuestion(System.out);
        assertThat(captor.toString().trim()).isEqualTo("지난 주 당첨 번호를 입력해 주세요.");
    }
}
