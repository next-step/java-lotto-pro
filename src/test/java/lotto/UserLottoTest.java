package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserLottoTest {
    @Test
    void 갯수만큼_로또를_구입한다() {
        UserLotto userLotto = new UserLotto(3);
        assertThat(userLotto.getLottoNumbers()).hasSize(3);
    }
}