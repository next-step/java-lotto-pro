package lotto;

import lotto.domain.Number;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class LotteryProducerTest {
    @Test
    void 일부터_사십오사이_숫자_여섯개_생성() {
        List<Number> numbers = LotteryProducer.issue();
        Set<Number> set = new HashSet<>(numbers);

        assertThat(set).hasSize(6);
        assertThatCode(() -> {
            for (Number number : numbers) {
                if (number.value() < 1 || number.value() > 45) {
                    throw new NoSuchElementException("범위 밖의 숫자가 존재합니다.");
                }
            }
        }).doesNotThrowAnyException();
    }
}
