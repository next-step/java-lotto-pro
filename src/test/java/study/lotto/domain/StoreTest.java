package study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import study.lotto.domain.order.Order;
import study.message.LottoExceptionCode;
import study.message.NumberExceptionCode;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("로또를 구매하는 클래스 테스트")
class StoreTest {

    @ParameterizedTest
    @ValueSource(ints = { 1, 5, 10, 20, 50 })
    void 입력된_숫자만큼_로또를_자동으로_구매하는_기능_테스트(int quantity) {
        List<Lotto> lottos = Store.buyLottosAutomatically(quantity);

        assertThat(lottos).hasSize(quantity);
    }

    @ParameterizedTest
    @ValueSource(strings = { "1,2", "1,2,3,1,2,3" })
    void 수동으로_구매시_중복_숫자가_포함되거나_개수가_적은_경우_IllegalArguemntException(String lotto) {
        assertThatThrownBy(() -> {
            Store.buyLottoManually(lotto);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionCode.NOT_MATCH_LOTTO_SIZE.getMessage());
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = { "-", "1,2,3,4,5,&" })
    void 수동으로_구매시_숫자로_변경할_수_없는_문자가_포함된_경우_IllegalArgumentException(String lotto) {
        assertThatThrownBy(() -> {
            Store.buyLottoManually(lotto);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NumberExceptionCode.INVALID_NUMBER_STRING.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = { "1,2,3,4,5,49", "11,22,33,44,55,66" })
    void 수동으로_구매시_로또_숫자_범위가_아닌_숫자가_포함된_경우_IllegalArgumentException(String lotto) {
        assertThatThrownBy(() -> {
            Store.buyLottoManually(lotto);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionCode.INVALID_LOTTO_NUMBER.getMessage());
    }

    @Test
    void lottos_구매_테스트() {
        Order order = new Order("14000");
        order.addManualQuantity(2);
        order.addManualLotto("1, 2, 3, 4, 5, 6");
        order.addManualLotto("1, 2, 3, 4, 5, 6");

        Lottos lottos = Store.buyLottos(order);

        assertEquals("2,12", lottos.countByOrderType());
    }
}
