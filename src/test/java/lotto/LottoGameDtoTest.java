package lotto;

import com.sun.org.glassfish.gmbal.Description;
import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameDtoTest {
    private LottoGameDto generatorLottoGameDto() {
        Money money = Money.of(2000, 0);
        List<String> stringList = new ArrayList<>();
        ManualLotto manualLotto = ManualLotto.of(money, stringList);

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(LottoFactory.manualGenerator("1,2,3,4,5,6"));
        lottoList.add(LottoFactory.manualGenerator("2,3,4,5,6,45"));
        LottoGameDto totalLotto = LottoGameDto.of(manualLotto, new Lottos(lottoList));
        return totalLotto;
    }

    @Test
    @Description(value = "TotalLotto 생성 시 금액에 맞는 개수로 생성되는지 확인")
    void getLottoGameDto() {
        LottoGameDto totalLotto = generatorLottoGameDto();
        assertThat(totalLotto.getCount()).isEqualTo(2);
    }
}
