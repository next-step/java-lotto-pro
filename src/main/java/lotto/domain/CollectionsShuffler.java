package lotto.domain;

import java.util.Collections;
import java.util.List;

public class CollectionsShuffler implements Shuffleable {
    @Override
    public <E> void shuffle(List<E> list) {
        Collections.shuffle(list);
    }
}
