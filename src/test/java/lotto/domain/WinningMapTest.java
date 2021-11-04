package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningMapTest {

    private static LottoTicket lottoTicket;

    @BeforeAll
    public static void beforeEach() {
        lottoTicket = new LottoTicket(Arrays.asList(
                new LottoNumbers(Arrays.asList(1, 2, 30, 34, 37, 42))
        ));
    }

    private static Stream<Arguments> inputWinningTest() {
        return Stream.of(
                Arguments.of(lottoTicket, new Winning("1,2,37,41,43,44"), new HashMap<Rank, Integer>() {{
                    put(Rank.FIFTH, 1);
                }}, Rank.FIFTH),
                Arguments.of(lottoTicket, new Winning("2,30,34,37,40,41"), new HashMap<Rank, Integer>() {{
                    put(Rank.FOURTH, 1);
                }}, Rank.FOURTH),
                Arguments.of(lottoTicket, new Winning("1,2,8,30,37,42"), new HashMap<Rank, Integer>() {{
                    put(Rank.THIRD, 1);
                }}, Rank.THIRD),
                Arguments.of(lottoTicket, new Winning("1,2,30,34,37,42"), new HashMap<Rank, Integer>() {{
                    put(Rank.FIRST, 1);
                }}, Rank.FIRST)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("각 등수별로 맞췄을 경우")
    public void inputWinningTest(LottoTicket lottoTicket, Winning winning, Map<Rank, Integer> resultMap) {
        WinningMap winningMap = WinningMap.winningOf(lottoTicket, winning);

        assertThat(winningMap.getWinningMap().equals(resultMap)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "5,6,7,8,9,10",
            "1,7,23,31,33,44",
            "1,41,42,43,44,45"
    })
    @DisplayName("맞춘 번호가 2개 이하일 경우")
    public void lottoMatchNothing(String input) {
        Winning winning = new Winning(input);

        WinningMap winningMap = WinningMap.winningOf(lottoTicket, winning);

        assertThat(winningMap.getWinningMap()
                .keySet()
                .size()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,7,30,40,41|5",
            "1,2,30,34,40,41|50",
            "1,2,30,37,42,45|1500",
            "1,2,30,34,37,42|2000000"
    }, delimiter = '|')
    @DisplayName("맞춘 번호가 2개 이하일 경우")
    public void lottoMatchNothing(String input, int revenuePercent) {
        Winning winning = new Winning(input);
        BoughtLotto boughtLotto = new BoughtLotto(1000);

        WinningMap winningMap = WinningMap.winningOf(lottoTicket, winning);

        int revenue = winningMap.revenue(boughtLotto);

        assertThat(revenue).isEqualTo(revenuePercent);
    }

}
