package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    void getMatchingCounts_복수_로또_생성_중_1등당첨() {
        Lottos lottos = Lottos.from(Arrays.asList(
                Lotto.from("1,2,3,4,5,6"),
                Lotto.from("2,3,4,5,6,7"),
                Lotto.from("1,2,4,5,6,7"),
                Lotto.from("10,20,30,40,41,44"),
                Lotto.from("18,20,23,25,32,33"),
                Lotto.from("3,4,5,9,10,20")
        ));
        Lotto winningLotto = Lotto.from("3,4,5,9,10,20");
        List<Integer> matchList = lottos.getMatchingCounts(winningLotto);
        assertThat(matchList.contains(6)).isTrue();
    }

    @Test
    void buy_로또구매_생성() {
        Lottos lottos = Lottos.buy(10);
        assertThat(lottos.count()).isEqualTo(10);
    }
}
