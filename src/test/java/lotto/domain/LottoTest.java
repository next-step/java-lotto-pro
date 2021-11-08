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
        this.lotto = new Lotto("1,2,3,4,5,6");
    }

    @Test
    @DisplayName("유효한 로또번호를 생성한다")
    public void T01_validLotto() {
        //THEN
        assertThat(lotto.has(LottoNumber.valueOf(1))).isTrue();
        assertThat(lotto.has(LottoNumber.valueOf(7))).isFalse();
    }

    @Test
    @DisplayName("로또는 6개의 번호가 있어야한다.")
    public void T02_invalidLotto1() {
        //THEN
        assertThatThrownBy(() -> new Lotto(Arrays.asList(LottoNumber.valueOf(1), LottoNumber.valueOf(2), LottoNumber.valueOf(3), LottoNumber.valueOf(4)))).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("볼 개수가 일치하지 않습니다.");
        assertThatThrownBy(() -> new Lotto("1,2,3,4")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("볼 개수가 일치하지 않습니다.");
        assertThatThrownBy(() -> Lotto.valueOf("1,2,3,4")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("볼 개수가 일치하지 않습니다.");

    }

    @Test
    @DisplayName("로또 번호는 null값을 가질 수 없다.")
    public void T02_invalidLotto2() {
        String given = null;
        //THEN
        assertThatThrownBy(() -> new Lotto(given)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈값이나 null은 허용되지 않습니다.");
        assertThatThrownBy(() -> new Lotto("")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈값이나 null은 허용되지 않습니다.");
        assertThatThrownBy(() -> Lotto.valueOf("")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈값이나 null은 허용되지 않습니다.");
    }

    @Test
    @DisplayName("로또 번호는 각기 다른 6개의 숫자로 구성되어야 한다.")
    public void T03_invalidLotto3() {
        //THEN
        assertThatThrownBy(() -> new Lotto(Arrays.asList(LottoNumber.valueOf(1), LottoNumber.valueOf(1), LottoNumber.valueOf(1), LottoNumber.valueOf(1), LottoNumber.valueOf(1), LottoNumber.valueOf(1)))).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 볼은 올 수 없습니다.");
        assertThatThrownBy(() -> new Lotto("1,1,1,1,1,1")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 볼은 올 수 없습니다.");
        assertThatThrownBy(() -> Lotto.valueOf("1,1,1,1,1,1")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 볼은 올 수 없습니다.");
    }

    @Test
    @DisplayName("정적 팩토리 메소드 사용")
    public void T04_staticFactoryMethod() {
        //WHEN
        LottoNumber number = LottoNumber.valueOf(LottoNumber.MIN_NUMBER);
        //THEN
        assertThat(number).isEqualTo(LottoNumber.valueOf(1));
        assertThatThrownBy(() -> LottoNumber.valueOf(LottoNumber.MAX_NUMBER +1)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45 사이의 숫자만 가능합니다.");

    }
}
