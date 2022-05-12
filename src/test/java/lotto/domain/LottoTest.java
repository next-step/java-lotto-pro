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

    @Test
    void 로또_생성_성공() {
        List<LottoNumber> numbers = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

        LottoNumberStrategy strategy = () -> IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        Lotto lotto = new Lotto(numbers);

        assertThat(lotto).isNotNull();
        assertThat(Lotto.create(strategy)).isEqualTo(new Lotto(numbers));
    }

    @Test
    void 로또_생성_실패() {
        List<LottoNumber> numbers = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5));

        assertThatIllegalArgumentException().isThrownBy(
                () -> new Lotto(numbers)
        ).withMessageContaining("로또 번호는 6개여야 합니다.");
    }

    @ParameterizedTest
    @MethodSource("match")
    void 로또_매치(List<LottoNumber> lottoNumbers, List<LottoNumber> winLottoNumbers, Rank rank) {
        assertThat(new Lotto(lottoNumbers).match(new Lotto(winLottoNumbers)))
                .isEqualTo(rank);
    }

    private static Stream<Arguments> match() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)),
                        Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)),
                        Rank.FIRST),
                Arguments.of(
                        Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)),
                        Arrays.asList(new LottoNumber(1), new LottoNumber(13), new LottoNumber(14), new LottoNumber(15), new LottoNumber(16), new LottoNumber(17)),
                        Rank.NONE),
                Arguments.of(
                        Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)),
                        Arrays.asList(new LottoNumber(13), new LottoNumber(14), new LottoNumber(15), new LottoNumber(16), new LottoNumber(17), new LottoNumber(18)),
                        Rank.NONE)
        );
    }


}
