package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.model.Lotto;
import step3.model.LottoNumber;
import step3.model.Lottos;

import java.util.List;

public class LottoTest {
    private Lotto lotto = new Lotto();

    @Test
    @DisplayName("1~45의 랜덤한 6자리 숫자 생성")
    void 랜덤_숫자_테스트() {
        lotto.generateRandomNumbers();
    }
}
