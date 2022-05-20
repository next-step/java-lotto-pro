package lotto_auto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @Test
    void 로또들_생성() {
        PurchaseInfo info = new PurchaseInfo(new Money("4000"), new LottoCount("1"));

        Set<LottoNumber> lottoNumberList = new HashSet<>(Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),new LottoNumber(3),new LottoNumber(4),new LottoNumber(5),new LottoNumber(6)));

        Lotto lotto = new Lotto(new LottoNumbers(lottoNumberList));
        Lottos lottos = LottoGenerator.buyLottos(info, new Lottos(Arrays.asList(lotto)));

        assertThat(lottos.getLottoList().size()).isEqualTo(4);
    }

}
