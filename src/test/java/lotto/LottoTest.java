package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(new int[]{1,2,3,4,5,6});
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:true","5:true","6:true","7:false"}, delimiter = ':')
    void isMatch_로또_숫자_일치_테스트(int input, boolean expected) {
        assertThat(lotto.isMatch(input)).isEqualTo(expected);
    }

    static Stream<Arguments> getMatchNumber_로또_당첨숫자_개수확인_테스트() {
        return Stream.of(Arguments.of(new int[]{1,7,8,9,10,11},1,new int[] {1,2,3,4,5,6},6,new int[]{7,8,9,10,11,12},0));
    }

    @ParameterizedTest
    @MethodSource
    void getMatchNumber_로또_당첨숫자_개수확인_테스트(int[] input, int expected) {
        assertThat(lotto.getMatchNumber(input)).isEqualTo(expected);
    }
}
