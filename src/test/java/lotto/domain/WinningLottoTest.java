package lotto.domain;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * packageName : lotto.domain
 * fileName : WinningLottoTest
 * author : haedoang
 * date : 2021/11/07
 * description : 로또 당첨 번호(보너스 번호 있음) 클래스
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class WinningLottoTest {

    private List<LottoNumber> lottoNumberList;
    private int bonusNumber = 7;
    private Lotto lottoPlace1;
    private Lotto lottoPlace2;
    private Lotto lottoPlace3;
    private Lotto lottoPlace4;
    private Lotto lottoPlace5;
    private Lotto bankruptcy;

    @BeforeEach
    void setUp() {
        this.lottoNumberList = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        this.lottoPlace1 = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        this.lottoPlace2 = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(bonusNumber)));
        this.lottoPlace3 = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(9)));
        this.lottoPlace4 = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(8), new LottoNumber(9)));
        this.lottoPlace5 = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(9), new LottoNumber(8), new LottoNumber(7)));
        this.bankruptcy = new Lotto(Arrays.asList(new LottoNumber(31), new LottoNumber(24), new LottoNumber(23), new LottoNumber(19), new LottoNumber(8), new LottoNumber(11)));
    }

    @Test
    @DisplayName("유효한 로또번호 생성하기")
    public void T1_create() {
        //GIVEN
        WinningLotto winningLotto = WinningLotto.valueOf("1,2,3,4,5,6", LottoNumber.valueOf(bonusNumber));
        //THEN
        assertThat(winningLotto.has(LottoNumber.valueOf(1))).isTrue();
        assertThat(winningLotto.has(LottoNumber.valueOf(6))).isTrue();
        assertThat(winningLotto.has(LottoNumber.valueOf(13))).isFalse();
        assertThat(winningLotto.isBonus(LottoNumber.valueOf(bonusNumber))).isTrue();
        assertThat(winningLotto.isBonus(LottoNumber.valueOf(LottoNumber.MAX_NUMBER))).isFalse();
    }


}
