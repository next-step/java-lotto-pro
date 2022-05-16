package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class GenerateLottoNumberTest {

    @Test
    void 셔플을_통해_로또_번호를_생성할_수_있다() {
        GenerateLottoNumber generateLottoNumber = new GenerateLottoNumber((list) -> Collections.swap(list, 0, 1));
        assertThat(generateLottoNumber.initNumbers()).containsExactly(2, 1, 3, 4, 5, 6);
    }

}