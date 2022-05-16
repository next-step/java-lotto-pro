package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTicketTest {

    LottoTicket lottoTicket = new LottoTicket(Arrays.asList("1", "2", "3", "4", "5", "6"));

    @Test
    @DisplayName("String값들과 Int값들을 통해 ticket을 발행할때 검증")
    public void createLottoTicket() {
        //given
        List<String> 정상티켓 = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<String> 숫자5개티켓 = Arrays.asList("1", "2", "3", "4", "5");
        List<String> 음수티켓 = Arrays.asList("-1", "2", "3", "4", "5", "6");
        List<String> 문자티켓 = Arrays.asList("a", "2", "3", "4", "5", "6");
        //when
        assertAll(
            () -> assertThat(new LottoTicket(정상티켓)).isNotInstanceOf(IllegalArgumentException.class).as("정상동작"),
            () -> assertThatThrownBy(() -> new LottoTicket(숫자5개티켓)).isInstanceOf(IllegalArgumentException.class).as("Throw동작"),
            () -> assertThatThrownBy(() -> new LottoTicket(음수티켓)).isInstanceOf(IllegalArgumentException.class).as("Throw동작"),
            () -> assertThatThrownBy(() -> new LottoTicket(문자티켓)).isInstanceOf(IllegalArgumentException.class).as("Throw동작")
        );
    }

    @ParameterizedTest
    @MethodSource("generateLottoData")
    @DisplayName("로또 정답 갯수를 확인한다.")
    public void checkLottoWin(List<String> lottoInfo, int expected) {
        LottoTicket winnerLotto = new LottoTicket(lottoInfo);
        assertThat(lottoTicket.getMatchCountWithWinnerTicket(winnerLotto.getLottoNumbers())).isEqualTo(expected);
    }

    static Stream<Arguments> generateLottoData() {
        return Stream.of(
            Arguments.of(Arrays.asList("1", "2", "3", "4", "5", "7"), 5),
            Arguments.of(Arrays.asList("1", "2", "3", "11", "8", "7"), 3),
            Arguments.of(Arrays.asList("1", "23", "41", "9", "8", "7"), 1),
            Arguments.of(Arrays.asList("11", "23", "41", "9", "8", "7"), 0)
        );
    }

    @Test
    @DisplayName("로또 번호를 가져올수 있어야한다")
    public void getLottoNumbersTest() {
        List<String> lottoSource = Arrays.asList("1", "2", "3", "4", "5", "6");
        LottoTicket lotto = new LottoTicket(lottoSource);
        assertThat(lotto.getLottoNumbers()).containsExactly(
            new LottoElement(1),
            new LottoElement(2),
            new LottoElement(3),
            new LottoElement(4),
            new LottoElement(5),
            new LottoElement(6)
        );
    }
}
