package camp.nextstep.edu.level1.lotto.lotto;

import camp.nextstep.edu.until.RandomGenerator;
import helper.LottoNumbersGenerator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

class LottoRankTest {

    static MockedStatic<RandomGenerator> util;

    @BeforeAll
    static void beforeAll() {
        util = mockStatic(RandomGenerator.class);
    }

    @AfterAll
    static void afterAll() {
        util.close();
    }

    @Test
    void 일치하는_수에_해당하는_로또_랭크를_반환해야_한다() {
        LottoNumbers winnerLottoNumbers = LottoNumbersGenerator.createLottoNumbersHasValue(1, 2, 3, 4, 5, 6);
        LottoNumbers firstLottoNumbers = LottoNumbersGenerator.createLottoNumbersHasValue(1, 2, 3, 4, 5, 6);
        LottoNumbers secondLottoNumbers = LottoNumbersGenerator.createLottoNumbersHasValue(1, 2, 3, 4, 5, 7);
        LottoNumbers thirdLottoNumbers = LottoNumbersGenerator.createLottoNumbersHasValue(1, 2, 3, 4, 7, 8);
        LottoNumbers forthLottoNumbers = LottoNumbersGenerator.createLottoNumbersHasValue(1, 2, 3, 7, 8, 9);

        assertThat(LottoRank.checkLottoRank(firstLottoNumbers, winnerLottoNumbers)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.checkLottoRank(secondLottoNumbers, winnerLottoNumbers)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.checkLottoRank(thirdLottoNumbers, winnerLottoNumbers)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.checkLottoRank(forthLottoNumbers, winnerLottoNumbers)).isEqualTo(LottoRank.FORTH);
    }
}
