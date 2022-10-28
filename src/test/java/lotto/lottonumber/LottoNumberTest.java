package lotto.lottonumber;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    LottoNumber lottoNumber = new LottoNumber();

    @Test
    @DisplayName("로또번호는 1 ~ 45 사이의 숫자이다")
    void range() {
        Iterator<Integer> iterator = lottoNumber.createIterator();
        while (iterator.hasNext()) {
            int lottoNumber = iterator.next();
            assertThat(lottoNumber).isGreaterThan(0);
            assertThat(lottoNumber).isLessThan(46);
        }
    }

    @Test
    @DisplayName("로또번호는 서로 겹치지 않는다")
    void duplicate() {
        Set<Integer> lottoNumbers = new HashSet<>();
        Iterator<Integer> iterator = lottoNumber.createIterator();
        while (iterator.hasNext()) {
            lottoNumbers.add(iterator.next());
        }
        assertThat(lottoNumbers).hasSize(6);
    }

    @Test
    @DisplayName("로또번호는 6개의 숫자를 가진다")
    void count() {
        Iterator<Integer> iterator = lottoNumber.createIterator();
        int iteratorCount = 0;
        while (iterator.hasNext()) {
            iterator.next();
            iteratorCount++;
        }
        assertThat(iteratorCount).isEqualTo(6);
    }
}
