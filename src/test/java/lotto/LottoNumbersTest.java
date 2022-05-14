package lotto;

import static java.util.stream.IntStream.range;
import static org.assertj.core.api.Assertions.assertThat;
import static util.ListUtils.sort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoNumbersTest {

    @Test
    void 전체_기본_로또번호_1_45_확인() {
        // given
        List<LottoNumber> lottoNumberList = range(1, 46)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());

        // when & then
        assertThat(LottoNumbers.ALL_NUMBERS).isEqualTo(new LottoNumbers(lottoNumberList));
    }

    @Test
    void 로또_번호_6개를_랜덤으로_선택() {
        // when
        LottoNumbers lottoNumbers = LottoNumbers.ALL_NUMBERS.pickNumbersRandom();

        // then
        assertThat(lottoNumbers.isPicked()).isTrue();
    }

    @Test
    void 로또_번호_6개_선택() {
        // when
        final LottoNumbers lottoNumbers = LottoNumbers.pickNumbers(range(1, 7)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList()));

        // then
        assertThat(lottoNumbers.isPicked()).isTrue();
    }

    @Test
    @DisplayName("로또 번호가 순서에 상관없이 번호끼리 같은지 비교")
    void 로또_번호_비교() {
        // given
        List<LottoNumber> lottoNumberList = range(1, 7)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());

        final LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);
        final LottoNumbers expectedLottoNumbers = new LottoNumbers(
                sort(lottoNumberList, (o1, o2) -> o2.getNumber() - o1.getNumber()));

        // when & then
        assertThat(lottoNumbers).isEqualTo(expectedLottoNumbers);
    }

    @Test
    @DisplayName("로또 번호가 1 ~ 6 과 2 ~ 7 비교")
    void 로또_다른_번호_비교() {
        // given
        final LottoNumbers lottoNumbers = new LottoNumbers(range(1, 7)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList()));
        final LottoNumbers expectedLottoNumbers = new LottoNumbers(range(2, 8)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList()));

        // when & then
        assertThat(lottoNumbers).isNotEqualTo(expectedLottoNumbers);
    }

    @ParameterizedTest
    @MethodSource("compareLottoNumberListSource")
    void 로또_번호를_비교하여_같은_갯수_찾기(List<LottoNumber> lottoNumberList, List<LottoNumber> expectedLottoNumberList,
                              int result) {
        // given
        final LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);
        final LottoNumbers expectedLottoNumbers = new LottoNumbers(expectedLottoNumberList);

        // when & then
        assertThat(lottoNumbers.compareCount(expectedLottoNumbers)).isEqualTo(result);

    }

    static Stream<Arguments> compareLottoNumberListSource() {
        return Stream.of(
                Arguments.of(range(1, 7)
                                .mapToObj(LottoNumber::valueOf)
                                .collect(Collectors.toList()),
                        range(2, 8)
                                .mapToObj(LottoNumber::valueOf)
                                .collect(Collectors.toList()), 5
                ),
                Arguments.of(range(1, 7)
                                .mapToObj(LottoNumber::valueOf)
                                .collect(Collectors.toList()),
                        range(7, 13)
                                .mapToObj(LottoNumber::valueOf)
                                .collect(Collectors.toList()), 0
                ),
                Arguments.of(range(1, 7)
                                .mapToObj(LottoNumber::valueOf)
                                .collect(Collectors.toList()),
                        range(4, 10)
                                .mapToObj(LottoNumber::valueOf)
                                .collect(Collectors.toList()), 3
                )
        );
    }
}