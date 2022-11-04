package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoRankTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    @DisplayName("1등 테스트")
    @Test
    void FIRST_테스트() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(IntStream
                .rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()))
                , new LottoNumber(7));
        WinningLottoRank rank = winningLotto.rank(lotto);

        assertThat(rank).isEqualTo(WinningLottoRank.FIRST);
    }

    @DisplayName("2등 테스트")
    @Test
    void SECOND_테스트() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(IntStream
                .rangeClosed(2, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()))
                , new LottoNumber(1));
        WinningLottoRank rank = winningLotto.rank(lotto);

        assertThat(rank).isEqualTo(WinningLottoRank.SECOND);
    }

    @DisplayName("3등 테스트")
    @Test
    void THIRD_테스트() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(IntStream
                .rangeClosed(2, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()))
                , new LottoNumber(8));
        WinningLottoRank rank = winningLotto.rank(lotto);

        assertThat(rank).isEqualTo(WinningLottoRank.THIRD);
    }

    @DisplayName("4등 테스트")
    @Test
    void FOURTH_테스트() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(IntStream
                .rangeClosed(3, 8)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()))
                , new LottoNumber(9));
        WinningLottoRank rank = winningLotto.rank(lotto);

        assertThat(rank).isEqualTo(WinningLottoRank.FOURTH);
    }

    @DisplayName("5등 테스트")
    @Test
    void FIFTH_테스트() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(IntStream
                .rangeClosed(4, 9)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()))
                , new LottoNumber(10));
        WinningLottoRank rank = winningLotto.rank(lotto);

        assertThat(rank).isEqualTo(WinningLottoRank.FIFTH);
    }

    @DisplayName("낙첨 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5:10:11"
            , "6:11:12"
            , "7:12:13"
            , "8:13:14"
            , "9:14:15"
            , "10:15:16"
            , "11:16:17"
    }, delimiter = ':')
    void MISS_테스트(int left, int right, int bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(new Lotto(IntStream
                .rangeClosed(left, right)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()))
                , new LottoNumber(bonusNumber));
        WinningLottoRank rank = winningLotto.rank(lotto);
        assertThat(rank).isEqualTo(WinningLottoRank.MISS);
    }
}
