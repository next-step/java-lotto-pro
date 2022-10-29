package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    @Test
    @DisplayName("중복 숫자를 입력하여 실패하는 테스트")
    void winning_lotto_number_duplication_test() {
        assertThatThrownBy(() -> new WinningNumbers("1,1,1,1,1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("몇 개의 숫자가 매치되는지 확인하는 테스트")
    void winning_lotto_number_match_test() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        Set<LottoNumber> lottoNumberSet = new HashSet<>();

        lottoNumberSet.add(new LottoNumber(1));
        lottoNumberSet.add(new LottoNumber(2));
        lottoNumberSet.add(new LottoNumber(3));
        lottoNumberSet.add(new LottoNumber(4));
        lottoNumberSet.add(new LottoNumber(11));
        lottoNumberSet.add(new LottoNumber(21));

        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberSet);

        assertThat(winningNumbers.match(lottoNumbers)).isEqualTo(4);
    }
}