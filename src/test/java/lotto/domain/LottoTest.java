package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {
    private static final List<LottoNumber> LOTTO_NUMBERS = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    private static final WinningLotto WINNING_LOTTO = WinningLotto.of("1,2,3,4,5,6", 40);

    @Test
    void 로또_생성_성공() {
        LottoNumberStrategy strategy = () -> IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        Lotto lotto = new Lotto(LOTTO_NUMBERS);

        assertThat(lotto).isNotNull();
        assertThat(Lotto.from(strategy)).isEqualTo(new Lotto(LOTTO_NUMBERS));
    }

    @Test
    void 로또_생성_실패_로또번호_개수다름() {
        List<LottoNumber> invalidNumbers = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5));

        assertThatIllegalArgumentException().isThrownBy(
                () -> new Lotto(invalidNumbers)
        ).withMessageContaining("로또 번호는 6개여야 합니다.");
    }

    @ParameterizedTest
    @MethodSource("match")
    void 로또_매치(List<LottoNumber> lottoNumbers, WinningLotto winningLotto, Rank rank) {

        assertThat(new Lotto(lottoNumbers)
                .match(winningLotto))
                .isEqualTo(rank);
    }

    private static Stream<Arguments> match() {
        return Stream.of(
                Arguments.of(
                        LOTTO_NUMBERS,
                        WINNING_LOTTO,
                        Rank.FIRST),
                Arguments.of(
                        Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(40)),
                        WINNING_LOTTO,
                        Rank.SECOND),
                Arguments.of(
                        Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(35)),
                        WINNING_LOTTO,
                        Rank.THIRD),
                Arguments.of(
                        LOTTO_NUMBERS,
                        WinningLotto.of("11,12,13,14,15,16", 30),
                        Rank.NONE)
        );
    }


}

