import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void match() {
        Lottos lottos = new Lottos(Arrays.asList(new Lotto("1,2,3,4,5,6"), new Lotto("1,2,5,6,7,8"), new Lotto("1,2,3,7,8,9")));
        lottos.checkMatch(new Lotto("1,2,3,4,11,12"));
        assertThat(lottos.match(3)).isEqualTo(1);
        assertThat(lottos.match(4)).isEqualTo(1);
    }

    @Test
    void getProfitTest() {
        Lottos lottos = new Lottos(Arrays.asList(new Lotto("1,2,3,4,5,6"), new Lotto("1,2,5,6,7,8"), new Lotto("1,2,3,7,8,9")));
        lottos.checkMatch(new Lotto("1,2,3,4,11,12"));
        assertThat(lottos.getProfit()).isEqualTo(55000);
    }
}
