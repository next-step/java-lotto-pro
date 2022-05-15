package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottiesTest {

    @Test
    void Lotties_생성() {
        LottoNumberStrategy strategy = getLottoNumberStrategy();

        Lotties lotties = new Lotties(Arrays.asList(Lotto.from(strategy)));

        assertThat(lotties).isNotNull();
    }

    @Test
    void 비어있는_Lotties는_생성불가() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Lotties(Arrays.asList())
        ).withMessageContaining("로또는 1개 이상 구매해야 합니다.");
    }

    @Test
    void 로또_개수_조회(){
        LottoNumberStrategy strategy = getLottoNumberStrategy();

        Lotties lotties = new Lotties(Arrays.asList(Lotto.from(strategy)));
        assertThat(lotties.count()).isOne();
    }

    private LottoNumberStrategy getLottoNumberStrategy() {
        return () -> IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
