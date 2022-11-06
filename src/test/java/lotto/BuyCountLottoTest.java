package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyCountLottoTest {

    @Test
    @DisplayName("수동 구매 숫자가 구매금액 할 수 있는 개수보다 큰 경우 유효성 체크")
    void directBuyCount_over_buyAmount_test() {
        assertThatThrownBy(() -> new BuyCountLotto(3, new BuyAmount(1000)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수동구매 로또와 자동로또 발급 후 수동구매로또가 포함되어있는지 확인 테스트")
    void direct_lotto_auto_lotto_contain_test() {
        BuyCountLotto buyCountLotto = new BuyCountLotto(1, new BuyAmount(3000));
        assertThat(buyCountLotto.getLotteries(new AutoLottoCreator(),
                        Arrays.asList(getLotto(Arrays.asList(1,2,3,4,5,6))))
                .getLotteriesDto().getLotteries().stream()
                .anyMatch((list) -> list.equals(Arrays.asList(1,2,3,4,5,6))))
                .isTrue();
    }

    @Test
    @DisplayName("수동구매 로또와 자동로또 발급 후 자동로또 개수 확인 테스트")
    void direct_lotto_auto_lotto_count_test() {
        BuyCountLotto buyCountLotto = new BuyCountLotto(1, new BuyAmount(3000));
        assertThat(buyCountLotto.getLotteries(new AutoLottoCreator(),
                        Arrays.asList(getLotto(Arrays.asList(1,2,3,4,5,6))))
                .getLotteriesDto().getLotteries().size())
                .isEqualTo(3);
        BuyCountLotto buyCountLotto2 = new BuyCountLotto(1, new BuyAmount(1000));
        assertThat(buyCountLotto2.getLotteries(new AutoLottoCreator(),
                        Arrays.asList(getLotto(Arrays.asList(1,2,3,4,5,6))))
                .getLotteriesDto().getLotteries().size())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("수동구매 로또 개수가 유저가 입력한 로또 개수와 불일치 테스트")
    void direct_lotto_list_size_is_not_equal_to_user_input_test() {
        BuyCountLotto buyCountLotto = new BuyCountLotto(2, new BuyAmount(3000));
        assertThatThrownBy(() -> buyCountLotto.getLotteries(new AutoLottoCreator(),
                Arrays.asList(getLotto(Arrays.asList(1,2,3,4,5,6)))))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> buyCountLotto.getLotteries(new AutoLottoCreator(),
                Arrays.asList(getLotto(Arrays.asList(1,2,3,4,5,6)), getLotto(Arrays.asList(1,2,3,4,5,6)),
                        getLotto(Arrays.asList(1,2,3,4,5,6)))))
                .isInstanceOf(IllegalArgumentException.class);
    }


    public Lotto getLotto(List<Integer> intList) {
        return new Lotto(intList.stream().map(LottoNumber::of).collect(Collectors.toList()));
    }
}
