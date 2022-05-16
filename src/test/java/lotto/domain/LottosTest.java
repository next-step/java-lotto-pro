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
    private List<LottoNumber> prizeNumbers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        prizeNumbers = new ArrayList<>();
        prizeNumbers.add(LottoNumber.from(1));
        prizeNumbers.add(LottoNumber.from(2));
        prizeNumbers.add(LottoNumber.from(3));
        prizeNumbers.add(LottoNumber.from(4));
        prizeNumbers.add(LottoNumber.from(5));
        prizeNumbers.add(LottoNumber.from(6));
    }

    @Test
    void 당첨_로또_리스트() {
        List<Lotto> lottoList = new ArrayList<>();

        lottoList.add(createLotto(1, 2, 3, 4, 5, 6));
        lottoList.add(createLotto(1, 2, 3, 4, 5, 7));
        lottoList.add(createLotto(1, 2, 3, 4, 7, 8));
        lottoList.add(createLotto(1, 2, 3, 7, 8, 9));

        Lottos lottos = Lottos.from(lottoList);
        lottos.matchedLottoList(prizeNumbers, MatchResult.THREE);

        assertAll(
                () -> assertThat(lottos.matchedLottoList(prizeNumbers, MatchResult.THREE).size()).isEqualTo(1),
                () -> assertThat(lottos.matchedLottoList(prizeNumbers, MatchResult.FOUR).size()).isEqualTo(1),
                () -> assertThat(lottos.matchedLottoList(prizeNumbers, MatchResult.FIVE).size()).isEqualTo(1),
                () -> assertThat(lottos.matchedLottoList(prizeNumbers, MatchResult.SIX).size()).isEqualTo(1)
        );
    }

    private Lotto createLotto(int input0, int input1, int input2, int input3, int input4, int input5) {
        LottoNumber[] lottoNumbers = new LottoNumber[NUMBER_COUNT];
        lottoNumbers[0] = LottoNumber.from(input0);
        lottoNumbers[1] = LottoNumber.from(input1);
        lottoNumbers[2] = LottoNumber.from(input2);
        lottoNumbers[3] = LottoNumber.from(input3);
        lottoNumbers[4] = LottoNumber.from(input4);
        lottoNumbers[5] = LottoNumber.from(input5);

        return new Lotto(PRICE, lottoNumbers);
    }
}