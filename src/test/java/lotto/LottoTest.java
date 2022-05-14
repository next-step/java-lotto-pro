package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void Integer_list_size가_6이_아닐경우_에러가_발생한다() {
        // when and then
        assertThatThrownBy(() -> {
            Lotto lotto = Lotto.create(Arrays.asList(1,2,3,4,5));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}