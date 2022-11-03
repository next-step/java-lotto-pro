package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyManualCountTest {

    @Test
    void 수동구매시_전달된_카운트수만큼_구매한다() {
        InputManualNumber inputManualNumber = () -> new Integer[]{1, 2, 3, 4, 5, 6};
        BuyManualCount buyManualCount = new BuyManualCount(inputManualNumber, 3);

        List<Integer[]> giveNumbers = new ArrayList<>();
        while (buyManualCount.hasCount()) {
            giveNumbers.add(buyManualCount.give());
        }

        assertThat(giveNumbers).hasSize(3);
    }
}
