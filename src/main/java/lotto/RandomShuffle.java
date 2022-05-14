package lotto;

import java.util.List;

@FunctionalInterface
public interface RandomShuffle {
    void shuffle(List<Integer> list);
}
