package camp.nextstep.edu.level1.lotto.lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @Test
    void 일치하는_수에_해당하는_로또_랭크를_반환해야_한다() {
        LottoNumbers winnerLottoNumbers = new LottoNumbers(createLottoNumberCollection(1, 2, 3, 4, 5, 6));
        LottoNumbers firstLottoNumbers = new LottoNumbers(createLottoNumberCollection(1, 2, 3, 4, 5, 6));
        LottoNumbers secondLottoNumbers = new LottoNumbers(createLottoNumberCollection(1, 2, 3, 4, 5, 45));
        LottoNumbers thirdLottoNumbers = new LottoNumbers(createLottoNumberCollection(1, 2, 3, 4, 5, 7));
        LottoNumbers forthLottoNumbers = new LottoNumbers(createLottoNumberCollection(1, 2, 3, 4, 7, 45));
        LottoNumbers fifthLottoNumbers = new LottoNumbers(createLottoNumberCollection(1, 2, 3, 7, 8, 45));

        LottoNumber bonusBall = new LottoNumber(45);

        assertThat(LottoRank.findLottoRank(firstLottoNumbers, winnerLottoNumbers, bonusBall)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.findLottoRank(secondLottoNumbers, winnerLottoNumbers, bonusBall)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.findLottoRank(thirdLottoNumbers, winnerLottoNumbers, bonusBall)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.findLottoRank(forthLottoNumbers, winnerLottoNumbers, bonusBall)).isEqualTo(LottoRank.FORTH);
        assertThat(LottoRank.findLottoRank(fifthLottoNumbers, winnerLottoNumbers, bonusBall)).isEqualTo(LottoRank.FIFTH);
    }

    private List<LottoNumber> createLottoNumberCollection(Integer ...args) {
        List<LottoNumber> result = new ArrayList<>();

        for (Integer arg : args) {
            result.add(new LottoNumber(arg));
        }

        return result;
    }
}
