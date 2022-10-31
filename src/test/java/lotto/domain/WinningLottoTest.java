package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {

    @Test
    @DisplayName("당첨 로또는 번호 6자리와 보너스 번호를 받아 생성한다")
    void creat() {
        assertThat(new WinningLotto(new Lotto("1,2,3,4,5,6"), LottoNumber.of("7"))).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,3,3,4,4,4", ",", "1:2,3,4,5,600"})
    @DisplayName("잘못된 로또 번호 문자열 입력받아 생성 오류 테스트")
    void create_문자열_에러(String numbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningLotto(new Lotto(numbers), LottoNumber.of("7"));
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:1"}, delimiter = ':')
    @DisplayName("로또 번호 6자리와 중복되는 보너스 번호를 가지고 당첨 로또를 생성하면 오류발생")
    void create_문자열_에러(String numbers, String bonusNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningLotto(new Lotto(numbers), LottoNumber.of(bonusNumber));
        });
    }

    @Test
    @DisplayName("당첨 확인 1등")
    void match() {
        WinningLotto winningLotto = new WinningLotto(new Lotto("1,2,3,4,5,6"), LottoNumber.of("7"));
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("당첨 확인 2등")
    void match_2등() {
        WinningLotto winningLotto = new WinningLotto(new Lotto("1,2,3,4,5,6"), LottoNumber.of("7"));
        Lotto lotto = new Lotto("1,2,3,4,5,7");
        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.SECOND);
    }

}
