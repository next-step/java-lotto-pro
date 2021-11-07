package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LottoCalculator 테스트")
public class LottoCalculatorTest {

    private PurchaseAmount purchaseAmount;

    @BeforeEach
    void setUp() {
        purchaseAmount = new PurchaseAmount(10_000);
    }

    @Test
    @DisplayName("로또 계산기를 생성한다.")
    void create() {
        // given
        Lotto manualLotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto manualLotto2 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        Lottos manualLottos = new Lottos(Arrays.asList(manualLotto1, manualLotto2), 2);

        // when
        LottoCalculator lottoCalculator = new LottoCalculator(purchaseAmount, manualLottos);
        List<Lotto> lottos = lottoCalculator.getLottos().getLottos();

        // then
        assertAll(
                () -> assertThat(lottoCalculator.getTotalQuantity()).isEqualTo(purchaseAmount.getQuantity()),
                () -> assertThat(lottoCalculator.getAutoQuantity()).isEqualTo(purchaseAmount.getQuantity() - manualLottos.getManualQuantity()),
                () -> assertThat(lottoCalculator.getManualQuantity()).isEqualTo(manualLottos.getManualQuantity()),
                () -> assertThat(lottos.get(0)).isEqualTo(manualLotto1),
                () -> assertThat(lottos.get(1)).isEqualTo(manualLotto2)
        );
    }

    @Test
    @DisplayName("구매 수량보다 큰 수동 로또 번호로 로또 계산기를 생성하면 예외가 발생한다.")
    void createThrowException() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(1_000);
        Lotto manualLotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto manualLotto2 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        Lottos manualLottos = new Lottos(Arrays.asList(manualLotto1, manualLotto2), 2);

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoCalculator(purchaseAmount, manualLottos))
                .withMessageMatching(ErrorMessage.LOTTO_CALCULATOR_MANUAL_OVER_ERROR.getMessage());
    }

    @Test
    @DisplayName("구입된 로또 개수를 반환한다.")
    void getTotalQuantity() {
        // given
        LottoCalculator lottoCalculator = new LottoCalculator(purchaseAmount, new Lottos(new ArrayList<>(), 0));

        // when
        int lottosSize = lottoCalculator.getTotalQuantity();

        // then
        assertThat(lottosSize).isEqualTo(purchaseAmount.getQuantity());
    }

    @Test
    @DisplayName("로또 수익률을 반환한다.")
    void getProceedsRate() {
        // given
        WinningResults winningResults = new WinningResults(Collections.singletonList(WinningResult.FIFTH));
        LottoCalculator lottoCalculator = new LottoCalculator(purchaseAmount, winningResults);

        // when
        float proceedsRate = lottoCalculator.getProceedsRate();

        // then
        assertThat(proceedsRate).isEqualTo(0.5F);
    }
}
