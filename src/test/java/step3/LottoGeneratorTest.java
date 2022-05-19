package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.LottoElement;
import step3.domain.LottoTicket;
import step3.model.LottoGenerator;

public class LottoGeneratorTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    public void init() {
        lottoGenerator = new LottoGenerator();
    }

    @Test
    @DisplayName("1~45 사이의 숫자 6개가 반환된다")
    public void makeRandomLottoTest() {
        LottoTicket lottoTicket = lottoGenerator.makeRandomLottoTicket();
        Assertions.assertThat(lottoTicket.getLottoNumbers()).hasSize(6);
        for (LottoElement lottoNumber : lottoTicket.getLottoNumbers()) {
            assertThat(lottoNumber.getElement()).isBetween(1, 45);
        }
    }

    @Test
    @DisplayName("manual Lotto를 생성한다.")
    public void makeManualLottoTest() {
        assertThat(lottoGenerator.makeManualLottoTicket("1,2,3,4,5,6").getLottoNumbers())
            .hasSize(6)
            .contains(new LottoElement(1))
            .contains(new LottoElement(2))
            .contains(new LottoElement(3))
            .contains(new LottoElement(4))
            .contains(new LottoElement(5))
            .contains(new LottoElement(6));
    }
}
