package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또 발행 테스트")
    @Test
    public void lottoIssueTest() {
        Lotto lotto = LottoMachine.issue();
        assertThat(lotto).isNotNull();
    }

    @DisplayName("로또의 숫자 발행 테스트")
    @Test
    public void lottoNumberCountTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.numberCount()).isEqualTo(6);
    }

    @DisplayName("로또 숫자를 비교하는 테스트")
    @Test
    public void lottoNumberEqualTest() {
        LottoNumber one = new LottoNumber(1);
        assertThat(one).isEqualTo(new LottoNumber(1));
    }

    @DisplayName("제한된 범위의 숫자 생성 시 예외 테스트")
    @Test
    public void lottoNumber_OutOfRange_ExceptionTest() {
        assertThatThrownBy(() -> new LottoNumber(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoNumber(46)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또의 숫자를 오름차순으로 정렬 테스트")
    @Test
    public void lottoNumberAscendingSortedTest() {
        Lotto lotto = new Lotto(Arrays.asList(6, 5, 2, 1, 15, 42));
        assertThat(lotto).containsExactly(new LottoNumber(1), new LottoNumber(2), new LottoNumber(5),
                new LottoNumber(6), new LottoNumber(15), new LottoNumber(42));
    }

    @DisplayName("로또의 숫자를 다음과 같은 형식으로 출력한다. [숫자, 숫자, 숫자, 숫자, 숫자, 숫자]")
    @Test
    public void printLottoNumbersTest() {
        Lotto lotto = new Lotto(Arrays.asList(6, 5, 2, 1, 15, 42));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 5, 6, 15, 42]");
    }

}
