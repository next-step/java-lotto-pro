package lotto.domain;

import lotto.enums.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 티켓 테스트")
public class LottoTicketTest {

    @DisplayName("로또를 만들 수 있다.")
    @Test
    void create_lotto() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(new LottoTicket(lottoNumbers)).isNotNull();
    }

    @DisplayName("로또 당첨 여부를 확인 할 수 있다.")
    @ParameterizedTest(name = "#{index} - {0}는 {1}와 {3}개가 일치한다.")
    @MethodSource("lotto_tickets")
    void number_match(List<Integer> input, LottoNumbers winningNumbers, LottoRank lottoRank, int matchCount) {
        LottoTicket lottoTicket = new LottoTicket(new LottoNumbers(input));
        assertThat(lottoTicket.compareLotto(winningNumbers)).isEqualTo(lottoRank);
    }

    private static Stream<Arguments> lotto_tickets() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoRank.FIRST, 6),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoRank.THIRD, 5),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 7, 8), new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoRank.FOURTH, 4),
                Arguments.of(Arrays.asList(1, 2, 3, 7, 8, 9), new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoRank.FIFTH, 3),
                Arguments.of(Arrays.asList(1, 2, 7, 8, 9, 10), new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoRank.NONE, 2)
        );
    }

}
