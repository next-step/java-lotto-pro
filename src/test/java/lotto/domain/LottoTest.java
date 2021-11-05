package lotto.domain;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * packageName : lotto.domain
 * fileName : LottoTest
 * author : haedoang
 * date : 2021-11-05
 * description : 로또 테스트
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        this.lotto = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
    }

    @Test
    @DisplayName("유효한 로또번호를 생성한다")
    public void T01_validLotto() {
        //THEN
        assertThat(lotto.has(new LottoNumber(1))).isTrue();
        assertThat(lotto.has(new LottoNumber(7))).isFalse();
    }

    @Test
    @DisplayName("로또는 6개의 번호가 있어야한다.")
    public void T02_invalidLotto1() {
        //THEN
        assertThatThrownBy(() -> new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4)))).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("볼 개수가 일치하지 않습니다.");
    }

    @Test
    @DisplayName("로또 번호는 null값을 가질 수 없다.")
    public void T02_invalidLotto2() {
        //THEN
        assertThatThrownBy(() -> new Lotto(null)).isInstanceOf(NullPointerException.class)
                .hasMessageContaining("null값이 올 수 없습니다.");
    }

    @Test
    @DisplayName("로또 번호는 각기 다른 6개의 숫자로 구성되어야 한다.")
    public void T03_invalidLotto3() {
        //THEN
        assertThatThrownBy(() -> new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(1), new LottoNumber(1), new LottoNumber(1), new LottoNumber(1), new LottoNumber(1)))).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 볼을 가질 수 없습니다.");
    }
}
