package lotto.domain;

import java.util.List;

public interface NumberSupplier {

    List<Integer> getAsInts(int digit);
}
