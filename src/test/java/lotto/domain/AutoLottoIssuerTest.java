package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AutoLottoIssuerTest {

    private AutoLottoIssuer issuer;

    @BeforeEach
    void setUp() {
        issuer = new AutoLottoIssuer(new LottoRandomFactory(new RandomNumberMachine()));
    }

    @Test
    void 주문금액이_맞아_떨어지지_않으면_최대금액_주문() {
        Money input = Money.from(10100);
        assertThat(issuer.issueAutomatically(input).size()).isEqualTo(10);
    }

    @Test
    void 수동으로_발행() {
        List<String[]> inputs = new ArrayList<>();
        inputs.add(new String[]{"1", "2", "3", "4", "5", "6"});
        inputs.add(new String[]{"1", "2", "3", "4", "5", "7"});

        assertThat(issuer.issueManually(inputs).size()).isEqualTo(2);
    }

    @Test
    void 추가_발행() {

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(createLotto(new int[]{1, 2, 3, 4, 5, 6}));

        Lottos lottos = Lottos.from(lottoList);

        assertThat(issuer.issueMore(lottos, Money.from(2000)).size()).isEqualTo(1);
    }

    private Lotto createLotto(int[] inputs) {
        LottoNumber[] lottoNumbers = new LottoNumber[inputs.length];

        for (int index = 0; index < inputs.length; index++) {
            lottoNumbers[index] = LottoNumber.from(inputs[index]);
        }

        return new Lotto(lottoNumbers);
    }
}