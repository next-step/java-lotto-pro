package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CustomLottoGeneratorTest {


    @ParameterizedTest
    @ValueSource(strings = {"1,22,3,2,44,55", "1, -1, 2,3,5,6"})
    void 수동로또구매실패(String lottoNumbers) {
        Assertions.assertThatThrownBy(() -> new CustomLottoGenerator(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

}