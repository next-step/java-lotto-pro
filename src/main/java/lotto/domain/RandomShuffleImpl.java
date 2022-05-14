package lotto.domain;

import java.util.Collections;
import java.util.List;

public class RandomShuffleImpl implements RandomShuffle {
    @Override
    public void shuffle(List<Integer> list) {
        Collections.shuffle(list);
    }
}
