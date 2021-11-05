package lotto.domain;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName : lotto.domain
 * fileName : RankTest
 * author : haedoang
 * date : 2021-11-05
 * description : 랭크 클래스 테스트
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class RankTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        this.lotto = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
    }


    @Test
    @DisplayName("번호6개일치")
    public void T04_matchCount6() {
        //GIVEN
        Lotto winning = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        //WHEN
        Rank rank = this.lotto.getRank(winning);
        //THEN
        assertThat(rank).isEqualTo(new Rank(6));
    }

    @Test
    @DisplayName("번호5개일치")
    public void T05_matchCount5() {
        //GIVEN
        Lotto winning = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(7)));
        //WHEN
        Rank rank = this.lotto.getRank(winning);
        //THEN
        assertThat(rank).isEqualTo(new Rank(5));
    }

    @Test
    @DisplayName("번호4개일치")
    public void T06_matchCount4() {
        //GIVEN
        Lotto winning = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(8), new LottoNumber(7)));
        //WHEN
        Rank rank = this.lotto.getRank(winning);
        //THEN
        assertThat(rank).isEqualTo(new Rank(4));
    }

    @Test
    @DisplayName("번호3개일치")
    public void T07_matchCount3() {
        //GIVEN
        Lotto winning = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(9), new LottoNumber(8), new LottoNumber(7)));
        //WHEN
        Rank rank = this.lotto.getRank(winning);
        //THEN
        assertThat(rank).isEqualTo(new Rank(3));
    }

    @Test
    @DisplayName("번호2개일치")
    public void T08_matchCount2() {
        //GIVEN
        Lotto winning = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(10), new LottoNumber(9), new LottoNumber(8), new LottoNumber(7)));
        //WHEN
        Rank rank = this.lotto.getRank(winning);
        //THEN
        assertThat(rank).isEqualTo(new Rank(2));
    }

    @Test
    @DisplayName("번호1개일치")
    public void T09_matchCount1() {
        //GIVEN
        Lotto winning = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(11), new LottoNumber(10), new LottoNumber(9), new LottoNumber(8), new LottoNumber(7)));
        //WHEN
        Rank rank = this.lotto.getRank(winning);
        //THEN
        assertThat(rank).isEqualTo(new Rank(1));
    }

    @Test
    @DisplayName("꽝")
    public void T10_matchCountNone() {
        //GIVEN
        Lotto winning = new Lotto(Arrays.asList(new LottoNumber(12), new LottoNumber(11), new LottoNumber(10), new LottoNumber(9), new LottoNumber(8), new LottoNumber(7)));
        //WHEN
        Rank rank = this.lotto.getRank(winning);
        //THEN
        assertThat(rank).isEqualTo(new Rank(1));
    }
}
