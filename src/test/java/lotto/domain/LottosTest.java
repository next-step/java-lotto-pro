package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottosTest {

    private int NUMBER_COUNT = 6;
    private Money PRICE = Money.from(1000);
    private WinningNumbers winningNumbers;
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        LottoNumber[] winningNumberInputs = new LottoNumber[NUMBER_COUNT];
        winningNumberInputs[0] = LottoNumber.from(1);
        winningNumberInputs[1] = LottoNumber.from(2);
        winningNumberInputs[2] = LottoNumber.from(3);
        winningNumberInputs[3] = LottoNumber.from(4);
        winningNumberInputs[4] = LottoNumber.from(5);
        winningNumberInputs[5] = LottoNumber.from(6);

        winningNumbers = new WinningNumbers(winningNumberInputs);

        List<Lotto> lottoList = new ArrayList<>();

        lottoList.add(createLotto(1, 2, 3, 4, 5, 6));
        lottoList.add(createLotto(1, 2, 3, 4, 5, 7));
        lottoList.add(createLotto(1, 2, 3, 4, 7, 8));
        lottoList.add(createLotto(1, 2, 3, 7, 8, 9));

        lottos = Lottos.from(lottoList);
    }

    @Test
    void 당첨_로또_리스트() {

        assertAll(
                () -> assertThat(lottos.matchedLottoList(winningNumbers, MatchResult.THREE).size()).isEqualTo(1),
                () -> assertThat(lottos.matchedLottoList(winningNumbers, MatchResult.FOUR).size()).isEqualTo(1),
                () -> assertThat(lottos.matchedLottoList(winningNumbers, MatchResult.FIVE).size()).isEqualTo(1),
                () -> assertThat(lottos.matchedLottoList(winningNumbers, MatchResult.SIX).size()).isEqualTo(1)
        );
    }

    @Test
    void 로또_총_금액() {
        assertThat(lottos.totalPrice()).isEqualTo(Money.from(4000));

    }

    private Lotto createLotto(int input0, int input1, int input2, int input3, int input4, int input5) {
        LottoNumber[] lottoNumbers = new LottoNumber[NUMBER_COUNT];
        lottoNumbers[0] = LottoNumber.from(input0);
        lottoNumbers[1] = LottoNumber.from(input1);
        lottoNumbers[2] = LottoNumber.from(input2);
        lottoNumbers[3] = LottoNumber.from(input3);
        lottoNumbers[4] = LottoNumber.from(input4);
        lottoNumbers[5] = LottoNumber.from(input5);

        return new Lotto(lottoNumbers);
    }
}