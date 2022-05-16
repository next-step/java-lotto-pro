package lotto.lotto;

import java.util.ArrayList;
import java.util.List;

public interface BatchLottoGenerator extends LottoGenerator {

    boolean hasMore();

    default List<Lotto> batchGenerate() {
        final List<Lotto> lottoes = new ArrayList<>();
        while (hasMore()) {
            lottoes.add(generate());
        }
        return lottoes;
    }
}
