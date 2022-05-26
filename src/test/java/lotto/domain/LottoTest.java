package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("6자리가 아닌 로또 번호 생성 시 오류 테스트")
    void create_lotto_range_exception_test() {
        assertThatThrownBy(() -> new Lotto("1, 2, 3, 4, 5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복 로또 번호 생성 시 오류 테스트")
    void create_lotto_overlap_test() {
        assertThatThrownBy(() -> new Lotto("1, 2, 3, 4, 5, 5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("lottoes")
    @DisplayName("로또 번호 맞은 횟수 테스트")
    void lotto_matches_test(Lotto lotto, int count) {
        Lotto lottoTicket = new Lotto("1, 2, 3, 4, 5, 7");
        assertThat(lottoTicket.matchCount(lotto)).isEqualTo(count);
    }

    static Stream<Arguments> lottoes() {
        return Stream.of(
                Arguments.of(new Lotto("1,2,3,4,5,6"), 5),
                Arguments.of(new Lotto("1,2,3,4,5,7"), 6)
        );
    }
}
