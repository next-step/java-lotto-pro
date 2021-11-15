package step3.component;

import static step3.domain.LottoNumber.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import step3.domain.Lotto;
import step3.domain.LottoNumber;

@FunctionalInterface
public interface LottoShuffleable {

    Lotto shuffle();

    default List<LottoNumber> preparedLottoNumbers() {
        final List<LottoNumber> preparedLottoNumbers = new ArrayList<>(MAXIMUM_LOTTO_NUMBER);

        for (int number = MINIMUM_LOTTO_NUMBER; number <= MAXIMUM_LOTTO_NUMBER; number++) {
            preparedLottoNumbers.add(new LottoNumber(number));
        }

        return Collections.unmodifiableList(preparedLottoNumbers);
    }
}
