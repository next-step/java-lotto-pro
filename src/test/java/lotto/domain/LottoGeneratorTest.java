package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @DisplayName("랜덤 로또 생성시 6개의 LottoNumber를 가진 Lotto가 생성되는 것을 확인")
    @Test
    void generateLotto() {
        assertThat(lottoGenerator.generateLotto().size()).isEqualTo(6);
    }

    @DisplayName("랜덤 로또 생성시 동일한 로또 번호가 중복으로 들어가지 않은 것을 확인")
    @RepeatedTest(10)
    void generateLottoNotDuplication() {
        Lotto lotto = lottoGenerator.generateLotto();

        HashSet<Integer> integerSet = new HashSet<>();
        for(int i = 0; i < lotto.size(); i++) {
            integerSet.add(lotto.get(i).getNumber());
        }

        assertThat(integerSet).hasSize(lotto.size());
    }

    @DisplayName("랜덤 로또 생성시 랜덤 생성된 로또의 숫자가 1~45인 것을 확인")
    @RepeatedTest(10)
    void generateLottoInRange() {
        Lotto lotto = lottoGenerator.generateLotto();

        for(int i = 0; i < lotto.size(); i++) {
            assertThat(lotto.get(i).getNumber()).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(45);
        }
    }

    @DisplayName("랜덤 로또번호 5개 생성시 size 5 확인")
    @Test
    void generateLottos() {
        Lottos lottos = lottoGenerator.generateLottos(5);
        assertThat(lottos.size()).isEqualTo(5);
    }

    @DisplayName("수동 로또번호 2개에 랜덤 로또번호 5개 생성시 size 7 확인")
    @Test
    void generateLottosWithManual() {
        Lotto lottoFirst = new Lotto(
                Stream.of(1, 5, 10, 12, 20, 33).map(LottoNumber::new).collect(Collectors.toList()));
        Lotto lottoSecond = new Lotto(
                Stream.of(1, 5, 33, 12, 20, 40).map(LottoNumber::new).collect(Collectors.toList()));
        List<Lotto> manualList = Arrays.asList(lottoFirst, lottoSecond);

        Lottos lottos = lottoGenerator.generateLottos(manualList, 5);
        assertThat(lottos.size()).isEqualTo(7);
    }
}
