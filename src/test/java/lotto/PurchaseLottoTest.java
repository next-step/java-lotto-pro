package lotto;

import static lotto.Rank.SECOND;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PurchaseLottoTest {
    private final List<Lotto> fakePurchaseLottoNumbers = new ArrayList<>();
    private final List<Lotto> fakePurchaseLotto2 = new ArrayList<>();

    @BeforeEach
    void setUp() {
        fakePurchaseLottoNumbers.add(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)));
        fakePurchaseLottoNumbers.add(Lotto.from(Arrays.asList(7, 8, 9, 10, 11, 12)));
        fakePurchaseLotto2.add(Lotto.from(Arrays.asList(13, 14, 15, 16, 17, 18)));
    }

    @Test
    void 구매한_로또_번호를_다른_로또_번호들과_합치기() {
        Lottos lottos = new Lottos(fakePurchaseLottoNumbers);
        lottos.addLottoNumbers(fakePurchaseLotto2);
        assertThat(lottos.printPurchaseLottoNumber()).isEqualTo(
                "[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]\n[13, 14, 15, 16, 17, 18]\n");
    }

    @Test
    void 구매한_로또_번호_출력() {
        Lottos lottos = new Lottos(fakePurchaseLottoNumbers);
        assertThat(lottos.printPurchaseLottoNumber()).isEqualTo(
                "[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]\n");
    }

    @Test
    void 로또_등수_반환() {
        Lottos lottos = new Lottos(fakePurchaseLottoNumbers);
        assertThat(lottos.getRank(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 7)),
                LottoNumber.from(6)).get(0)).isEqualTo(SECOND);
    }
}
