package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @ParameterizedTest(name = "로또는_6개의_정렬된_로또_번호를_가지고_있어야_한다")
    @MethodSource("possibleLottoNumbersFixture")
    void 로또는_6개의_정렬된_로또_번호를_가지고_있어야_한다(LottoNumberGenerateStrategy given, LottoNumberGenerateStrategy expected) {
        Lotto lotto = Lotto.valueOf(given);

        assertThat(lotto).isEqualTo(Lotto.valueOf(expected));
    }

    static Stream<Arguments> possibleLottoNumbersFixture() {
        return Stream.of(Arguments.of(
                new ManualLottoNumberGenerateStrategy(Arrays.asList(9, 18, 27, 36, 45, 1)),
                new ManualLottoNumberGenerateStrategy(Arrays.asList(9, 18, 27, 36, 45, 1))
            ));
    }

    @ParameterizedTest(name = "초기화시에_로또번호가_6개가_아니면_에러처리")
    @MethodSource("impossibleLottoNumbersFixture")
    void 초기화시에_로또번호가_6개가_아니면_에러처리(LottoNumberGenerateStrategy given) {
        assertThatThrownBy(() -> Lotto.valueOf(given))
            .isInstanceOf(RuntimeException.class);
    }

    static Stream<LottoNumberGenerateStrategy> impossibleLottoNumbersFixture() {
        return Stream.of(
            new ManualLottoNumberGenerateStrategy(Arrays.asList(9, 18, 27)),
            new ManualLottoNumberGenerateStrategy(Arrays.asList(9, 18, 27, 36)),
            new ManualLottoNumberGenerateStrategy(Arrays.asList(9, 18, 27, 36, 45))
        );
    }

    @ParameterizedTest(name = "초기화시에_로또번호가_중복된_숫자이면_에러처리")
    @MethodSource("duplicatedLottoNumbersFixture")
    void 초기화시에_로또번호가_중복된_숫자이면_에러처리(LottoNumberGenerateStrategy given) {
        assertThatThrownBy(() -> Lotto.valueOf(given))
            .isInstanceOf(RuntimeException.class);
    }

    static Stream<LottoNumberGenerateStrategy> duplicatedLottoNumbersFixture() {
        return Stream.of(
                new ManualLottoNumberGenerateStrategy(Arrays.asList(9, 18, 27, 36, 45, 45)),
                new ManualLottoNumberGenerateStrategy(Arrays.asList(9, 18, 27, 36, 18, 45)),
                new ManualLottoNumberGenerateStrategy(Arrays.asList(9, 20, 27, 36, 45, 20)),
                new ManualLottoNumberGenerateStrategy(Arrays.asList(1, 18, 27, 1, 45, 45))
        );
    }

    @ParameterizedTest(name = "다른_로또와_몇개가_일치하는지_확인한다")
    @MethodSource("lottoMatchTestFixture")
    void 다른_로또와_몇개가_일치하는지_확인한다(Lotto lotto, Lotto other, LottoMatchType expectedMatchType) {
        assertThat(lotto.match(other)).isSameAs(expectedMatchType);
    }

    static Stream<Arguments> lottoMatchTestFixture() {
        return Stream.of(
            Arguments.of(
                Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(1, 2, 3, 10, 11, 12))),
                LottoMatchType.THREE
            ),
            Arguments.of(
                Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(1, 2, 3, 4, 11, 12))),
                LottoMatchType.FOUR
            ),
            Arguments.of(
                Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(1, 2, 3, 4, 5, 12))),
                LottoMatchType.FIVE
            ),
            Arguments.of(
                Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(1, 2, 3, 4, 5, 6))),
                LottoMatchType.SIX
            ),
            Arguments.of(
                Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(1, 2, 23, 10, 11, 12))),
                LottoMatchType.OTHER
            )
        );
    }
}
