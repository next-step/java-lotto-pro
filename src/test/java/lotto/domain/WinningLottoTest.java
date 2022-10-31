package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {

    @Test
    @DisplayName("당첨 로또 생성")
    void creat() {
        assertThat(new WinningLotto(new Lotto("1,2,3,4,5,6"))).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,3,3,4,4,4", ",", "1:2,3,4,5,600"})
    @DisplayName("잘못된 로또 번호 문자열 입력받아 생성 오류 테스트")
    void create_문자열_에러(String numbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningLotto(new Lotto(numbers));
        });
    }

    @Test
    @DisplayName("당첨 확인 1등")
    void match() {
        WinningLotto winningLotto = new WinningLotto(new Lotto("1,2,3,4,5,6"));
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("당첨 확인 2등")
    void match_2등() {
        WinningLotto winningLotto = new WinningLotto(new Lotto("1,2,3,4,5,6"));
        Lotto lotto = new Lotto("1,2,3,4,5,7");
        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.SECOND);
    }

}
