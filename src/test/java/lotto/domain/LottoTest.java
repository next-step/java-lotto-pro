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

    @Test
    void 로또_생성_성공() {
        LottoNumber bonusNumber = new LottoNumber(40);
        LottoNumberStrategy strategy = () -> IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        Lotto lotto = new Lotto(LOTTO_NUMBERS, bonusNumber);

        assertThat(lotto).isNotNull();
        assertThat(Lotto.from(strategy)).isEqualTo(new Lotto(LOTTO_NUMBERS, bonusNumber));
    }

    @Test
    void 로또_생성_실패_로또번호_개수다름() {
        List<LottoNumber> invalidNumbers = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5));
        LottoNumber bonusNumber = new LottoNumber(40);

        assertThatIllegalArgumentException().isThrownBy(
                () -> new Lotto(invalidNumbers, bonusNumber)
        ).withMessageContaining("로또 번호는 6개여야 합니다.");
    }

    @Test
    void 로또_생성_실패_로또번호_보너스번호포함() {
        List<LottoNumber> invalidNumbers = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        LottoNumber bonusNumber = new LottoNumber(6);

        assertThatIllegalArgumentException().isThrownBy(
                () -> new Lotto(invalidNumbers, bonusNumber)
        ).withMessageContaining("당첨번호에 보너스 번호가 포함될 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("match")
    void 로또_매치(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber, List<LottoNumber> winLottoNumbers, Rank rank) {

        assertThat(new Lotto(lottoNumbers)
                .match(new Lotto(winLottoNumbers,bonusNumber)))
                .isEqualTo(rank);
    }

    private static Stream<Arguments> match() {
        return Stream.of(
                Arguments.of(
                        LOTTO_NUMBERS,
                        new LottoNumber(40),
                        LOTTO_NUMBERS,
                        Rank.FIRST),
                Arguments.of(
                        Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(40)),
                        new LottoNumber(40),
                        LOTTO_NUMBERS,
                        Rank.SECOND),
                Arguments.of(
                        Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(35)),
                        new LottoNumber(40),
                        LOTTO_NUMBERS,
                        Rank.THIRD),
                Arguments.of(
                        LOTTO_NUMBERS,
                        new LottoNumber(40),
                        Arrays.asList(new LottoNumber(13), new LottoNumber(14), new LottoNumber(15), new LottoNumber(16), new LottoNumber(17), new LottoNumber(18)),
                        Rank.NONE)
        );
    }


}

