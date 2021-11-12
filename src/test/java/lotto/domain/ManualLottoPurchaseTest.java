package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ManualLottoPurchaseTest {

    private static List<List<Integer>> lottos = null;

    @BeforeEach
    void setUp() {
        lottos = Arrays.asList(
                Arrays.asList(1,2,3,4,5,6),
                Arrays.asList(10,20,30,40,41,44),
                Arrays.asList(18,20,23,25,32,33)
        );
    }

    @Test
    void validate_예외_문자입력() {
        assertThatThrownBy(() -> ManualLottoPurchase.from("a")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Only numbers can be entered.");
    }

    @Test
    void from_예외_수동_로또_구매() {
        ManualLottoPurchase manualLottoPurchase = ManualLottoPurchase.from("3");
        assertThatThrownBy(()-> manualLottoPurchase.from(Payment.from(2000), lottos)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Must be less than the number of lottery tickets purchased.");
    }
}
