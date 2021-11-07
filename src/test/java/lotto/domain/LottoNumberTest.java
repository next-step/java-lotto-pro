package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LottoNumberTest {

    static Stream<Arguments> autoLottoTest() {
        List<Number> number = Arrays.asList(Number.of(1), Number.of(2), Number.of(3),
                Number.of(4), Number.of(5), Number.of(6));
        return Stream.of(arguments(number));
    }

    @ParameterizedTest
    @MethodSource("autoLottoTest")
    @DisplayName("로또 번호 생성 확인")
    public void autoLottoTest(List<Number> activeNumbers) {
        LottoNumber lottoNumber = new LottoNumber(activeNumbers);

        int size = lottoNumber.getLottoNumbers().size();

        assertThat(size).isEqualTo(6);
    }

    static Stream<Arguments> activeLottoNumberSize() {
        List<Number> number = Arrays.asList(Number.of(1), Number.of(2), Number.of(3),
                Number.of(4), Number.of(5), Number.of(6), Number.of(7));
        return Stream.of(arguments(number));
    }

    @ParameterizedTest
    @MethodSource("activeLottoNumberSize")
    @DisplayName("로또 번호 길이 검증")
    public void activeLottoNumberSize(List<Number> activeNumbers) {
        assertThatThrownBy(() -> {
            new LottoNumber(activeNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    static Stream<Arguments> lottoRank() {
        List<Number> MatchNumber = Arrays.asList(Number.of(1), Number.of(2), Number.of(3),
                Number.of(4), Number.of(5), Number.of(6));
        List<Number> LottoNumber = Arrays.asList(Number.of(11), Number.of(12), Number.of(13),
                Number.of(4), Number.of(5), Number.of(6));
        return Stream.of(arguments(
                MatchNumber
                , Number.of(7)
                ,LottoNumber
        ));
    }

    @ParameterizedTest
    @MethodSource("lottoRank")
    @DisplayName("로또 번호 매칭 검증")
    public void lottoRank(List<Number> MatchNumbers, Number bonusNumber, List<Number> activeNumbers) {
        LottoNumber matchLotto = new LottoNumber(MatchNumbers);
        LottoNumber activeLotto = new LottoNumber(activeNumbers);
        Rank matchRank = activeLotto.getMatchRank(new WinningLotto(matchLotto, bonusNumber));

        Rank excepted = Rank.FIVE;

        assertThat(matchRank).isEqualTo(excepted);
    }

}