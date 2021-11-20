package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LotteriesTest {

    @Test
    void 여러개의_로또로_로또컬렉션을_만들_수_있다() {
        //given
        final List<Lotto> givenLotteries = Arrays.asList(
            new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
            )),
            new Lotto(Arrays.asList(
                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9),
                new LottoNumber(10), new LottoNumber(11), new LottoNumber(12)
            ))
        );

        //when
        final Lotteries lotteries = new Lotteries(givenLotteries);

        //then
        assertAll(
            () -> assertThat(lotteries.get()).containsAll(givenLotteries),
            () -> assertThat(lotteries.size()).isEqualTo(2)
        );
    }

    @Test
    void 로또컬렉션에_로또를_더할수있다() {
        //given
        final ArrayList<Lotto> givenLotteries = new ArrayList<Lotto>() {{
            add(new Lotto(
                Arrays.asList(
                    new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                    new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
                ))
            );
        }};
        final Lotteries lotteries = new Lotteries(givenLotteries);

        final Lotto lotto = new Lotto(
            Arrays.asList(
                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9),
                new LottoNumber(10), new LottoNumber(11), new LottoNumber(12)
            )
        );

        //when
        lotteries.add(lotto);

        //then
        assertAll(
            () -> assertThat(lotteries.get()).containsAll(givenLotteries),
            () -> assertThat(lotteries.get()).contains(lotto),
            () -> assertThat(lotteries.size()).isEqualTo(2)
        );
    }

    @Test
    void 로또컬렉션들을_가지고_로또컬렉션들이_합쳐진_로또컬렉션을_만들_수_있다() {
        //given
        final Lotteries firstLotteries = new Lotteries(Arrays.asList(
            new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
            )),
            new Lotto(Arrays.asList(
                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9),
                new LottoNumber(10), new LottoNumber(11), new LottoNumber(12)
            ))
        ));

        final Lotteries secondLotteries = new Lotteries(Arrays.asList(
            new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
            )),
            new Lotto(Arrays.asList(
                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9),
                new LottoNumber(10), new LottoNumber(11), new LottoNumber(12)
            ))
        ));

        //when
        final Lotteries lotteries = Lotteries.of(firstLotteries, secondLotteries);

        //then
        assertAll(
            () -> assertThat(lotteries.get()).containsAll(firstLotteries.get()),
            () -> assertThat(lotteries.get()).containsAll(secondLotteries.get()),
            () -> assertThat(lotteries.size()).isEqualTo(4)
        );
    }
}