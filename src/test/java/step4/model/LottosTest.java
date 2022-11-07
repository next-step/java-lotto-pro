package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("로또_리스트_값_저장_클래스")
public class LottosTest {
    @DisplayName("Lottos_정상_입력")
    @Test
    void Lottos_pass_01() {
        assertThatNoException().isThrownBy(() -> new Lottos(
                Arrays.asList(
                        new Lotto("1,2,3,4,5,6"),
                        new Lotto("1,2,3,4,5,6"),
                        new Lotto("1,2,3,4,5,6"),
                        new Lotto("1,2,3,4,5,6")
                )
        ));
    }

    @DisplayName("Lottos_간_더하기_성공")
    @Test
    void Lottos_plus_01() {
        Lottos lottos = new Lottos(
                Arrays.asList(
                        new Lotto("1,2,3,4,5,6"),
                        new Lotto("1,2,3,4,5,6"),
                        new Lotto("1,2,3,4,5,6"),
                        new Lotto("1,2,3,4,5,6")
                )
        );
        Lottos otherLottos = new Lottos(
                Arrays.asList(
                        new Lotto("7,8,9,10,11,12"),
                        new Lotto("13,14,15,16,17,18")
                )
        );
        Lottos expectedLottos = new Lottos(
                Arrays.asList(
                        new Lotto("1,2,3,4,5,6"),
                        new Lotto("1,2,3,4,5,6"),
                        new Lotto("1,2,3,4,5,6"),
                        new Lotto("1,2,3,4,5,6"),
                        new Lotto("7,8,9,10,11,12"),
                        new Lotto("13,14,15,16,17,18")
                )
        );
        Lottos totalLottos = lottos.plus(otherLottos);
        assertThat(totalLottos).isEqualTo(expectedLottos);
    }

    @DisplayName("Rank에_해당하는_Lotto_개수_반환")
    @Test
    void Lottos_matchCountAboutRank_01() {
        Lottos lottos = new Lottos(
                Arrays.asList(
                        new Lotto("1,2,3,4,5,6"),
                        new Lotto("1,2,3,4,5,6"),
                        new Lotto("1,2,3,4,5,6"),
                        new Lotto("1,2,3,4,5,6")
                )
        );
        WinningLotto winningLotto = new WinningLotto(new Lotto("1,2,3,4,5,6"), LottoNumber.valueOf("7"));

        assertThat(lottos.matchCountAboutRank(winningLotto, Rank.FIRST)).isEqualTo(4);
    }

}