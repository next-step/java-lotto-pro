package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("중복되지 않는 로또번호 생성 테스트. 45회 테스트")
    public void generateUniqueLottoNumberTest(){
        for(int i=0; i<45; i++){
            generateUniqueLottoNumber();
        }
    }

    @DisplayName("로또 번호 생성 1회")
    private void generateUniqueLottoNumber(){
        Lotto lotto = new Lotto();
        Set<Integer> uniqueNumbers = new HashSet<>(lotto.generateUniqueLottoNumbers());
        assertThat(uniqueNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("적중 로또번호 갯수 테스트")
    public void countCollectNumber(){
        List<Integer> lottoNumbers = Arrays.stream(new int[]{1,2,3,4,5,6}).boxed().collect(Collectors.toList());
        List<Integer> winningNumbers = Arrays.stream(new int[]{1,2,3,4,5,6}).boxed().collect(Collectors.toList());
        int collectNumberCount = new Lotto(lottoNumbers).countCollectNumber(new Lotto(winningNumbers));
        assertThat(collectNumberCount).isEqualTo(6);

        List<Integer> winningNumbers2 = Arrays.stream(new int[]{1,2,3,11,22,33}).boxed().collect(Collectors.toList());
        int collectNumberCount2 = new Lotto(lottoNumbers).countCollectNumber(new Lotto(winningNumbers2));
        assertThat(collectNumberCount2).isEqualTo(3);
    }
}
