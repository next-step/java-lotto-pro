package lotto.domain;

import java.util.List;

public interface Shuffleable {
    <E> void shuffle(List<E> list);
}
