package study.lotto.domain.lottomachine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import study.lotto.domain.AutomaticLottoGenerator;
import study.lotto.domain.Lotto;
import study.lotto.domain.Lottos;

class LottoMachineTest {
    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        Price lottoPrice = LottoMachine.DEFAULT_LOTTO_PRICE;
        lottoMachine = new LottoMachine(new AutomaticLottoGenerator(), lottoPrice);
    }

    @Test
    @DisplayName("1000원으로 1장을 발급한다.")
    void 로또_1장_발급() {
        Lottos lottos = lottoMachine.issueLotto(new Price("1000")).getLottos();
        assertThat(lottos.get()).hasSize(1);
    }

    @Test
    @DisplayName("1장에 1000원씩 돈이 가능한만큼 발급한다.")
    void 로또_5장_발급() {
        Lottos lottos = lottoMachine.issueLotto(new Price("5500")).getLottos();
        assertThat(lottos.get()).hasSize(5);
    }

    @Test
    @DisplayName("돈이 부족하면 IllegalArgumentException 를 발생시킨다.")
    void 로또금액_부족() {
        final Price notEnoughMonth = new Price("900");
        assertThatThrownBy(() -> lottoMachine.issueLotto(notEnoughMonth)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액이 null이면 IllegalArgumentException 를 발생시킨다.")
    void 로또금액_null() {
        assertThatThrownBy(() -> lottoMachine.issueLotto(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    @DisplayName("수동 발급")
    class 수동_발급 {
        private Price purchasePrice;

        @BeforeEach
        void setUp() {
            purchasePrice = new Price("2200");
        }

        @Test
        @DisplayName("입력한 금액이 수동로또의 개수보다 부족할 경우 예외를 반환한다.")
        void 금액_부족() {
            List<Lotto> lottoList = Arrays.asList(
                    Lotto.from("1,2,3,4,5,6"),
                    Lotto.from("7,8,9,10,11,12"),
                    Lotto.from("13,14,15,16,17,18")
            );
            Lottos manualLottos = new Lottos(lottoList);
            assertThatThrownBy(() -> lottoMachine.issueLotto(purchasePrice, manualLottos))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("수동 로또의 개수가 입력한 구매 금액으로 살 수 있으면 로또를 발급한다.")
        void 수동_발급_성공() {
            List<Lotto> lottoList = Arrays.asList(
                    Lotto.from("1,2,3,4,5,6"),
                    Lotto.from("7,8,9,10,11,12")
            );
            Lottos manualLottos = new Lottos(lottoList);
            assertThat(lottoMachine.issueLotto(purchasePrice, manualLottos)).isNotNull();
        }

        @Test
        @DisplayName("수동 로또를 발급하고 남은 금액으로 자동 로또를 발급한다.")
        void 수동_및_자동_발급() {
            List<Lotto> lottoList = Arrays.asList(
                    Lotto.from("1,2,3,4,5,6")
            );
            Lottos manualLottos = new Lottos(lottoList);

            LottoPurchaseHistory lottoPurchaseHistory = lottoMachine.issueLotto(purchasePrice, manualLottos);
            assertThat(lottoPurchaseHistory.getLottos().get()).hasSize(2);
        }
    }
}
