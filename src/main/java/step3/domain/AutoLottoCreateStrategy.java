package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoCreateStrategy implements LottoCreateStrategy {
    @Override
    public Lotto createLotto() {
        List<LottoNumber> origin = new ArrayList<>(lottoNumberMap.values());
        Collections.shuffle(origin);

        List<LottoNumber> destination = new ArrayList<>(origin.subList(0, 6));
        Collections.sort(destination);
        return new Lotto(destination);
    }
}
