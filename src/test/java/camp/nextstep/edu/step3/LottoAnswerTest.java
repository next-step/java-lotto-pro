package camp.nextstep.edu.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.step3.LottoTest.createLottoNumberList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoAnswerTest {
    private LottoAnswer lottoAnswer;
    @BeforeEach
    void setUp() {
        lottoAnswer = new LottoAnswer(createLottoNumberList(new int[] {1,2,3,4,5,6}), new LottoNumber(7));
    }

    @DisplayName("당첨 번호 6자리와 보너스 정보를 가진다.")
    @Test
    void createTest() {
        assertThat(lottoAnswer)
                .isEqualTo(new LottoAnswer(createLottoNumberList(new int[] {1,2,3,4,5,6}), new LottoNumber(7)));
    }

    @DisplayName("당첨번호에 보너스 번호가 들어있으면 에러를 발생한다.")
    @Test
    void invalidCreateTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoAnswer(createLottoNumberList(new int[] {1,2,3,4,5,6}), new LottoNumber(6)));
    }

    @DisplayName("사용자가 구매한 로또를 입력하면 당첨여부를 알려준다.")
    @Test
    void verifyTest() {
        assertThat(lottoAnswer.verify(new Lotto(createLottoNumberList(new int[]{1,2,3,4,5,7}))))
                .isEqualTo(Hit.FIVE_BONUS);
    }
}
