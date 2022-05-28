package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.enums.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("당첨 로또 정보 생성시 로또 정보를 null로 입력시 Exception 발생 확인")
    @Test
    void winningLottoWithLottoNull() {
        assertThatThrownBy(() -> new WinningLotto(null, new LottoNumber(45)));
    }

    @DisplayName("당첨 로또 정보 생성시 보너스볼 정보를 null로 입력시 Exception 발생 확인")
    @Test
    void winningLottoWithBonusNull() {
        List<Integer> inputList = Arrays.asList(5, 41, 23, 7, 8, 1);
        Lotto lotto = new Lotto(inputList.stream().map(LottoNumber::new).collect(Collectors.toList()));

        assertThatThrownBy(() -> new WinningLotto(lotto, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 볼이 당첨로또에 포함되어 있는 숫자일 경우 Exception 발생 확인")
    @Test
    void winningLottoWithExistedBonusNull() {
        List<Integer> inputList = Arrays.asList(5, 41, 23, 7, 8, 1);
        Lotto lotto = new Lotto(inputList.stream().map(LottoNumber::new).collect(Collectors.toList()));

        assertThatThrownBy(() -> new WinningLotto(lotto, new LottoNumber(5))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 숫자 3개 매칭시 5등")
    @Test
    void matchThree() {
        List<Integer> referenceList = Arrays.asList(1, 5, 10, 23, 42, 3);
        Lotto reference = new Lotto(referenceList.stream().map(LottoNumber::new).collect(Collectors.toList()));
        WinningLotto winningLotto = new WinningLotto(reference, new LottoNumber(45));

        List<Integer> lottoList = Arrays.asList(1, 5, 7, 8, 23, 41);
        Lotto lotto = new Lotto(lottoList.stream().map(LottoNumber::new).collect(Collectors.toList()));

        assertThat(winningLotto.match(lotto)).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("로또 숫자 6개 매칭시 1등")
    @Test
    void matchSix() {
        List<Integer> referenceList = Arrays.asList(1, 5, 10, 23, 42, 3);
        Lotto reference = new Lotto(referenceList.stream().map(LottoNumber::new).collect(Collectors.toList()));
        WinningLotto winningLotto = new WinningLotto(reference, new LottoNumber(45));

        List<Integer> lottoList = Arrays.asList(23, 5, 1, 42, 3, 10);
        Lotto lotto = new Lotto(lottoList.stream().map(LottoNumber::new).collect(Collectors.toList()));

        assertThat(winningLotto.match(lotto)).isEqualTo(LottoRank.FIRST);
    }

}
