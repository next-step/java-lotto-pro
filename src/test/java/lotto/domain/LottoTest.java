package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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

    @DisplayName("로또 생성시 정렬된 로또 번호를 가지고 있는 로또 객체 생성 확인")
    @Test
    void lotto() {
        List<Integer> inputList = Arrays.asList(5, 41, 23, 7, 8, 1);
        Lotto result = new Lotto(inputList.stream().map(LottoNumber::new).collect(Collectors.toList()));

        List<Integer> answerList = Arrays.asList(1, 5, 7, 8, 23, 41);
        for(int i = 0; i < result.size(); i++) {
            assertThat(result.get(i)).isEqualTo(new LottoNumber(answerList.get(i)));
        }
    }
}