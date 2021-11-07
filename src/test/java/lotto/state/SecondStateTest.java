package lotto.state;

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

public class SecondStateTest {
    private SecondState secondState;
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
        secondState = new SecondState(new SecondStateView(), new LotteryTicket(lottoNumbersList));
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
        secondState.printQuestion(System.out);
        assertThat(captor.toString().trim()).isEqualTo("지난 주 당첨 번호를 입력해 주세요.");
    }

    @DisplayName("당첨 번호를 입력 받고 통계를 출력한다")
    @Test
    void testResult() {
        secondState.printResult("1,2,3,4,5,6", System.out);
        assertThat(captor.toString()).contains("3개 일치 (5000원)- 1개", "4개 일치 (50000원)- 2개", "5개 일치 (1500000원)- 1개", "6개 일치 (2000000000원)- 1개");
    }
}
