package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LottoTest {
    @Test
    public void 로또_생성() {
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=45; i++) {
            list.add(i);
        }
        Lotto lotto = new Lotto(list);
        lotto.printLottoNumber();
    }
}
