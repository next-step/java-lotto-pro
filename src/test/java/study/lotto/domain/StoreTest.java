package study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import study.message.LottoExceptionCode;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@DisplayName("로또를 구매하는 클래스 테스트")
class StoreTest {

    @ParameterizedTest
    @ValueSource(ints = { 1, 5, 10, 20, 50 })
    void 입력된_숫자만큼_로또를_자동으로_구매하는_기능_테스트(int quantity) {
        List<Lotto> lottos = Store.buyLottosByAuto(quantity);

        assertThat(lottos).hasSize(quantity);
    }

    @ParameterizedTest
    @ValueSource(strings = { "1,2", "1,2,3,1,2,3" })
    void 수동으로_구매시_중복_숫자가_포함되거나_개수가_적은_경우_IllegalArguemntException(String lottos) {
        assertThatThrownBy(() -> {
            Store.buyLottoByManual(lottos);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionCode.NOT_MATCH_LOTTO_SIZE.getMessage());
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = { "-", "1,2,3,4,5,-", "1,2,3,4,90" })
    void 수동으로_구매시_로또_숫자와_매칭되지_않는_경우_IllegalArgumentException(String lottos) {
        assertThatThrownBy(() -> {
            Store.buyLottoByManual(lottos);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionCode.INVALID_LOTTO_NUMBER.getMessage());
    }
}
