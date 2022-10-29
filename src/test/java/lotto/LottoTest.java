package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @ParameterizedTest(name = "로또는_6개의_정렬된_로또_번호를_가지고_있어야_한다")
    @MethodSource("possibleLottoNumbersFixture")
    void 로또는_6개의_정렬된_로또_번호를_가지고_있어야_한다(List<LottoNumber> possibleLottoNumbersFixture) {
        Lotto lotto = Lotto.valueOf(possibleLottoNumbersFixture);

        List<LottoNumber> expectedLottoNumbers = Arrays.asList(
            LottoNumber.valueOf(9),
            LottoNumber.valueOf(18),
            LottoNumber.valueOf(27),
            LottoNumber.valueOf(36),
            LottoNumber.valueOf(45),
            LottoNumber.valueOf(1)
        );

        assertThat(lotto).isEqualTo(Lotto.valueOf(expectedLottoNumbers));
    }

    static Stream<List<LottoNumber>> possibleLottoNumbersFixture() {
        return Stream.of(
            Arrays.asList(
                LottoNumber.valueOf(9),
                LottoNumber.valueOf(18),
                LottoNumber.valueOf(27),
                LottoNumber.valueOf(36),
                LottoNumber.valueOf(45),
                LottoNumber.valueOf(1)
            )
        );
    }

    @ParameterizedTest(name = "초기화시에_로또번호가_6개가_아니면_에러처리")
    @MethodSource("impossibleLottoNumbersFixture")
    void 초기화시에_로또번호가_6개가_아니면_에러처리(List<LottoNumber> impossibleLottoNumbersFixture) {
        assertThatThrownBy(() -> Lotto.valueOf(impossibleLottoNumbersFixture))
            .isInstanceOf(RuntimeException.class);
    }

    static Stream<List<LottoNumber>> impossibleLottoNumbersFixture() {
        return Stream.of(
            Arrays.asList(
                LottoNumber.valueOf(9),
                LottoNumber.valueOf(18),
                LottoNumber.valueOf(27),
                LottoNumber.valueOf(36),
                LottoNumber.valueOf(45)
            ),
            Arrays.asList(
                LottoNumber.valueOf(9),
                LottoNumber.valueOf(18),
                LottoNumber.valueOf(27),
                LottoNumber.valueOf(36),
                LottoNumber.valueOf(45),
                LottoNumber.valueOf(1),
                LottoNumber.valueOf(2)
            )
        );
    }
}
