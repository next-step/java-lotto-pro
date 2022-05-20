package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.enums.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 생성시 입력된 숫자열의 사이즈와 동일한 사이즈를 가진 로또 객체 생성 확인")
    @Test
    void lottoSize() {
        List<Integer> inputList = Arrays.asList(5, 41, 23, 7, 8, 1);
        Lotto result = new Lotto(inputList.stream().map(LottoNumber::new).collect(Collectors.toList()));

        assertThat(result.size()).isEqualTo(inputList.size());
    }

    @DisplayName("로또 생성시 정의된 로또숫자 사이즈가 아닌경우 Exception 발생 확인")
    @Test
    void lottoWrongSize() {
        assertThatThrownBy(() -> new Lotto(
                Stream.of(1, 5, 10, 12, 20, 40, 3).map(LottoNumber::new).collect(Collectors.toList())));
    }

    @DisplayName("로또 생성시 숫자열을 null 로 입력할 경우 Exception 발생 확인")
    @Test
    void lottoNull() {
        assertThatThrownBy(() -> new Lotto(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 생성시 숫자열을 empty list 로 입력할 경우 Exception 발생 확인")
    @Test
    void lottoEmptyList() {
        assertThatThrownBy(() -> new Lotto(new ArrayList<>())).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 숫자 3개 매칭시 5등")
    @Test
    void lottoMatchingThree() {
        List<Integer> referenceList = Arrays.asList(1, 5, 10, 23, 42, 3);
        Lotto reference = new Lotto(referenceList.stream().map(LottoNumber::new).collect(Collectors.toList()));

        List<Integer> lottoList = Arrays.asList(1, 5, 7, 8, 23, 41);
        Lotto lotto = new Lotto(lottoList.stream().map(LottoNumber::new).collect(Collectors.toList()));

        assertThat(reference.match(lotto).convertToLottoRank()).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("로또 숫자 6개 매칭시 1등")
    @Test
    void lottoMatchingSix() {
        List<Integer> referenceList = Arrays.asList(1, 5, 10, 23, 42, 3);
        Lotto reference = new Lotto(referenceList.stream().map(LottoNumber::new).collect(Collectors.toList()));

        List<Integer> lottoList = Arrays.asList(23, 5, 1, 42, 3, 10);
        Lotto lotto = new Lotto(lottoList.stream().map(LottoNumber::new).collect(Collectors.toList()));

        assertThat(reference.match(lotto).convertToLottoRank()).isEqualTo(LottoRank.FIRST);
    }
}
