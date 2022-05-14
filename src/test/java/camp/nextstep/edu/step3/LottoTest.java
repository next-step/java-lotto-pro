package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoTest {

    @DisplayName("로또는 숫자 6개를 입력이 안될 경우 RuntimeException 을 발생한다")
    @ParameterizedTest
    @MethodSource("provideIntegerArrays")
    void invalidInputTest(final List<LottoNumber> numbers) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(numbers))
                .withMessageContaining("invalid LottoNumbers");
    }

    private static Stream<Arguments> provideIntegerArrays() {
        return Stream.of(
                Arguments.of(createLottoNumberList(new int[]{1})),
                Arguments.of(createLottoNumberList(new int[]{1, 2, 3, 4, 5})),
                Arguments.of(createLottoNumberList(new int[]{1, 2, 3, 4, 5,5}))
        );
    }

    @DisplayName("로또는 입력값을 정렬해서 저장한다.")
    @ParameterizedTest
    @MethodSource("provideSourceLottoAndTargetLotto")
    void inputSortTest(final Lotto source, final Lotto target) {
        assertThat(source).isEqualTo(target);
    }

    private static Stream<Arguments> provideSourceLottoAndTargetLotto() {
        return Stream.of(
                Arguments.of(
                        new Lotto(createLottoNumberList(new int[]{1, 2, 4, 3, 5, 6})),
                        new Lotto(createLottoNumberList(new int[]{2, 1, 3, 4, 6, 5}))
                ),
                Arguments.of(
                        new Lotto(createLottoNumberList(new int[]{9, 8, 7, 6, 5, 4})),
                        new Lotto(createLottoNumberList(new int[]{4, 5, 6, 7, 8, 9}))
                )
        );
    }

    @DisplayName("checkTo 메소드에 당첨 Lotto 를 입력하면 일치한 정보를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideUserLottoAndPrizeLotto")
    void checkTest(final Lotto myLotto, final Lotto prizeLotto, final Hit expectedHit) {
        assertThat(myLotto.checkTo(prizeLotto)).isEqualTo(expectedHit);
    }

    private static Stream<Arguments> provideUserLottoAndPrizeLotto() {
        return Stream.of(
                Arguments.of(
                        new Lotto(createLottoNumberList(new int[]{1, 2, 4, 3, 5, 6})),
                        new Lotto(createLottoNumberList(new int[]{2, 1, 3, 4, 6, 5})),
                        Hit.ALL
                ),
                Arguments.of(
                        new Lotto(createLottoNumberList(new int[]{1, 2, 4, 9, 10, 11})),
                        new Lotto(createLottoNumberList(new int[]{2, 1, 3, 4, 6, 5})),
                        Hit.THREE
                )
        );
    }

     static List<LottoNumber> createLottoNumberList(final int[] numbers) {
        return Arrays.stream(numbers).mapToObj(LottoNumber::new).collect(Collectors.toList());
    }
}
