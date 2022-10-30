package lotto.domain;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
    @ParameterizedTest
    @ValueSource(ints = {3000, 5000, 13200})
    void 돈을_입력받고_구한갯수만큼_로또를구매한다(int money) {
        assertThat(new Lotto(money).getPurchaseLottoList()).hasSize(new LottoMoney(money).count());
    }

    @ParameterizedTest
    @MethodSource("로또번호_및_당첨번호")
    void 당첨번호를_입력받아_당첨결과를_얻는다(Set<Integer> lottoNumbers, Set<Integer> winningNumbers, Prize prize) {
        Lotto lotto = new Lotto(Collections.singletonList(new LottoNumbers(lottoNumbers)));
        LottoResult result = lotto.computeResult(new LottoNumbers(winningNumbers));
        assertThat(result.getCount(prize)).isEqualTo(1);
    }

    private static Stream<Arguments> 로또번호_및_당첨번호() {
        return Stream.of(
            Arguments.of(//0개일치
                new HashSet<>(asList(1, 2, 3, 4, 5, 6)), new HashSet<>(asList(7, 8, 9, 10, 11, 12)), Prize.NOTHING),
            Arguments.of(//1개일치
                new HashSet<>(asList(1, 2, 3, 4, 5, 6)), new HashSet<>(asList(1, 7, 8, 9, 10, 11)), Prize.NOTHING),
            Arguments.of(//2개일치
                new HashSet<>(asList(1, 2, 3, 4, 5, 6)), new HashSet<>(asList(1, 2, 7, 8, 9, 10)), Prize.NOTHING),
            Arguments.of(//3개일치
                new HashSet<>(asList(1, 2, 3, 4, 5, 6)), new HashSet<>(asList(1, 2, 3, 7, 8, 9)), Prize.FOURTH),
            Arguments.of(//4개일치
                new HashSet<>(asList(1, 2, 3, 4, 5, 6)), new HashSet<>(asList(1, 2, 3, 4, 7, 8)), Prize.THIRD),
            Arguments.of(//5개일치
                new HashSet<>(asList(1, 2, 3, 4, 5, 6)), new HashSet<>(asList(1, 2, 3, 4, 5, 7)), Prize.SECOND),
            Arguments.of(//6개일치
                new HashSet<>(asList(1, 2, 3, 4, 5, 6)), new HashSet<>(asList(1, 2, 3, 4, 5, 6)), Prize.FIRST)
        );
    }

}