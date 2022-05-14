package lotto.domain;

import lotto.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningRanksTest {
    private LottoWinningRanks lottoWinningRanks;

    @BeforeEach
    void setUp() {
        //given
        List<Integer> first = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoNumbers userNumbers = new LottoNumbers(first);
        LottoNumbers winningNumbers = new LottoNumbers(first);
        lottoWinningRanks = new LottoWinningRanks();
        lottoWinningRanks.addWinningRank(userNumbers.rank(winningNumbers));

        List<Integer> second = Arrays.asList(1, 2, 3, 4, 5, 7);
        userNumbers = new LottoNumbers(second);
        lottoWinningRanks.addWinningRank(userNumbers.rank(winningNumbers));

        List<Integer> lose = Arrays.asList(7, 8, 9, 10, 11, 12);
        userNumbers = new LottoNumbers(lose);
        lottoWinningRanks.addWinningRank(userNumbers.rank(winningNumbers));
    }

    @DisplayName("당첨된 로또 순위 추가")
    @Test
    void test_로또_순위_추가() {
        //when & then
        assertThat(lottoWinningRanks.size()).isEqualTo(2);
    }

    @DisplayName("로또 순위 개수 조회")
    @Test
    void test_순위_개수() {
        //when & then
        assertThat(lottoWinningRanks.rankCount(Rank.FIRST)).isEqualTo(1);
    }
}