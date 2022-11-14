package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinLottoTest {

    @DisplayName("당첨번호 대비 일치 개수 확인")
    @Test
    void 일치_개수_확인() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        WinLotto winLotto = new WinLotto(lotto, LottoNumber.getLottoNumberByInt(9));
        Lotto userLotto = new Lotto(Arrays.asList(1,2,3,4,5,9));

        MatchCount expected = new MatchCount(5, 1);

        assertThat(winLotto.compareWithLotto(userLotto)).isEqualTo(expected);
    }
}
