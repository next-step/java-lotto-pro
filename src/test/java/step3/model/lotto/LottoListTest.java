package step3.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoListTest {
    private Lotto winningLotto;
    private List<Lotto> lottoList = new ArrayList<>();

    @BeforeEach
    void setup() {
        winningLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto ticket_match_6 = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto ticket_match_4 = new Lotto(Arrays.asList(3,4,5,6,7,8));
        Lotto ticket_match_2 = new Lotto(Arrays.asList(5,6,7,8,9,10));
        lottoList.addAll(Arrays.asList(ticket_match_6, ticket_match_4, ticket_match_2));

    }

    @Test
    void 매치만_같으면_섞어도_결과는_같다() {
        LottoList lottoList1 = new LottoList(lottoList);
        Collections.shuffle(lottoList);
        LottoList lottoList2 = new LottoList(lottoList);
        assertThat(lottoList1.getResults(winningLotto)).isEqualTo(lottoList2.getResults(winningLotto));
    }


}