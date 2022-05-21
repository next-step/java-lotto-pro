package lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.factory.LottoNumbersFactory;
import lotto.game.BuyLotto;
import lotto.game.LottoGame;
import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BuyLottoTest {
    private static final int LOTTO_BUY_COUNT = 10;
    private BuyLotto buyLotto;

    @BeforeEach
    void setUp() {
        int budget = LOTTO_BUY_COUNT * LottoGame.LOTTO_PRICE;
        buyLotto = new BuyLotto(budget, new LottoNumbersFactory());
    }

    @Test
    void 수동_구매시_예산_초과_예외_테스트() {
        assertThatIllegalStateException().isThrownBy(() -> {
            int buyUntilExceedBudget = LOTTO_BUY_COUNT + 1;
            for (int i = 0; i < buyUntilExceedBudget; i++) {
                buyLotto.manual(randomLottoNumberList());
            }
        });
    }

    private List<Integer> randomLottoNumberList() {
        List<Integer> numbers = IntStream
                .range(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER + 1)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.subList(0, LottoNumbers.LOTTO_NUMBERS_SIZE);
    }
}
