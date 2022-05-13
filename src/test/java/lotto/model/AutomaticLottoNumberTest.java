package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AutomaticLottoNumberTest {
    private LottoNumber automaticNumber;

    @BeforeEach
    void setUp() {
        automaticNumber = AutomaticLottoNumber.generate();
    }

    @Test
    @DisplayName("자등으로 중복되지 않는 로또 한 세트 뽑기")
    void pickAutomaticNumber() {
        List<Integer> lottoNumbers = automaticNumber.getLottoNumber();

        assertAll(
                () -> assertThat(lottoNumbers).hasSize(6),
                () -> assertThat(new HashSet<>(lottoNumbers)).hasSize(6)
        );
    }

    @Test
    @DisplayName("자동으로 뽑은 로또가 정렬되어있는지 확인")
    void verifySortedAutomaticNumber() {
        List<Integer> lottoNumbers = automaticNumber.getLottoNumber();
        List<Integer> copy = new ArrayList<>(lottoNumbers);
        Collections.sort(copy);

        assertEquals(lottoNumbers, copy);
    }
}
