package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LottosGenerator 테스트")
class LottosGeneratorTest {

    @Test
    @DisplayName("로또 리스트를 생성한다.")
    void generateOnlyAuto() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(10_000);

        // when
        Lottos lottos = LottosGenerator.generate(purchaseAmount);

        // then
        assertAll(
                () -> assertThat(lottos.getTotalQuantity()).isEqualTo(purchaseAmount.getQuantity()),
                () -> assertThat(lottos.getAutoQuantity()).isEqualTo(purchaseAmount.getQuantity()),
                () -> assertThat(lottos.getManualQuantity()).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("수동 로또가 포함된 로또 리스트를 생성한다.")
    void generateWithManual() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(10_000);
        Lottos manualLottos = Lottos.of(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)), Lotto.from(Arrays.asList(2, 3, 4, 5, 6, 7)));

        // when
        Lottos lottos = LottosGenerator.generate(purchaseAmount, manualLottos);

        // then
        assertAll(
                () -> assertThat(lottos.getTotalQuantity()).isEqualTo(purchaseAmount.getQuantity()),
                () -> assertThat(lottos.getAutoQuantity()).isEqualTo(purchaseAmount.getQuantity() - manualLottos.getManualQuantity()),
                () -> assertThat(lottos.getManualQuantity()).isEqualTo(manualLottos.getManualQuantity())
        );
    }

    @Test
    @DisplayName("자동 생성된 로또는 6개의 중복되지 않고 정렬된 숫자로 구성된다.")
    void generate() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(1_000);

        // when
        Lottos lottos = LottosGenerator.generate(purchaseAmount);

        // then
        assertAll(
                () -> assertThat(getUniqueSize(lottos.getLottos().get(0))).isEqualTo(Lotto.LOTTO_NUMBERS_SIZE),
                () -> assertThat(lottos.getLottos().get(0).getLottoNumbers()).isEqualTo(getSortedList(lottos.getLottos().get(0)))
        );
    }

    private int getUniqueSize(Lotto lotto) {
        return new HashSet<>(lotto.getLottoNumbers()).size();
    }

    private List<LottoNumber> getSortedList(Lotto lotto) {
        return lotto.getLottoNumbers()
                .subList(0, lotto.getLottoNumbers().size())
                .stream()
                .sorted(Comparator.comparing(LottoNumber::getNumber))
                .collect(Collectors.toList());
    }
}
