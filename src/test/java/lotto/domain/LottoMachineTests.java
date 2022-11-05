package lotto.domain;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 발급기 테스트")
class LottoMachineTests {

    @Test
    @DisplayName("받은 금액만큼 생성된 로또를 가지고 있는 일급 컬렉션을 생성한다.")
    void should_CreateLottos() {
        int money = 1_000;

        List<LottoNumber> lottoNumbers = createLottoNumbers();
        LottoMachine lottoMachine = new LottoMachine(money, () -> lottoNumbers);

        Lottos lottos = lottoMachine.issue(money);

        Lottos expectedLottos = new Lottos(singletonList(new Lotto(lottoNumbers)));
        assertThat(lottos).isEqualTo(expectedLottos);
    }

    @Test
    @DisplayName("로또 1개 금액보다 적은 금액을 입력하면 빈 로또 일급 컬렉션을 생성한다.")
    void should_CreateEmptyLottos() {
        int money = 1_000;

        List<LottoNumber> lottoNumbers = createLottoNumbers();
        LottoMachine lottoMachine = new LottoMachine(1_500, () -> lottoNumbers);

        Lottos lottos = lottoMachine.issue(money);
        assertThat(lottos).isEqualTo(new Lottos(new ArrayList<>()));
    }

    private List<LottoNumber> createLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoNumbers.add(new LottoNumber(i + 1));
        }
        return lottoNumbers;
    }
}
