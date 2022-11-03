package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.model.Lotto;
import step3.model.LottoNumber;
import step3.model.WinnerLotto;
import step3.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerLottoTest {
    private Lotto lotto = new Lotto();

    @Test
    @DisplayName("위너_로또_상속_테스트")
    void 위너_로또_상속_테스트() {
        List<LottoNumber> list = new ArrayList<>();
        String[] numbers = {"1","2","3","4","5","6"};
        for (String str : numbers) {
            list.add(new LottoNumber(CommonUtils.commonStringToNumber(str)));
        }
        WinnerLotto winnerLotto = new WinnerLotto(list, "7");
        assertThat(winnerLotto.getBonusNumber()).isEqualTo(new LottoNumber(7));
        assertThat(winnerLotto.getNumbers()).isEqualTo(list);
    }
}
