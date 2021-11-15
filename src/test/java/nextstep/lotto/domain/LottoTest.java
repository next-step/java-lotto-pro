package nextstep.lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class LottoTest {

    @DisplayName("당첨된 번호와 내가 산 로또 번호가 몇개 매칭이 되었는지 테스트")
    @ParameterizedTest
    @MethodSource("provideParameter")
    public void matchWithPurchaseLottoCountTest(Lotto winningNumbers, Lotto purchased, BonusBall bonusBall, Integer expected) {

        // when
        Integer result = winningNumbers.matchWithPurchaseLottoCount(purchased);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }


    private static Stream<Arguments> provideParameter() {

        Lotto winningLotto1 = new Lotto(new LottoNumbers(
                Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6))
        ));

        Lotto winningLotto2 = new Lotto(new LottoNumbers(
                Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6))
        ));

        return Stream.of(
                Arguments.of(winningLotto1,
                        new Lotto(new LottoNumbers(
                                Arrays.asList(
                                        new LottoNumber(1),
                                        new LottoNumber(2),
                                        new LottoNumber(3),
                                        new LottoNumber(4),
                                        new LottoNumber(5),
                                        new LottoNumber(6)
                                ))
                        ),
                        new BonusBall(new LottoNumber(10), winningLotto1),
                        6
                ),
                Arguments.of(winningLotto2,
                        new Lotto(new LottoNumbers(
                                Arrays.asList(
                                        new LottoNumber(1),
                                        new LottoNumber(2),
                                        new LottoNumber(3),
                                        new LottoNumber(7),
                                        new LottoNumber(8),
                                        new LottoNumber(9)
                                ))
                        ),
                        new BonusBall(new LottoNumber(7), winningLotto2),
                        4
                )
        );
    }
}
