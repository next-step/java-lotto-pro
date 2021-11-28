package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class ManualLottos extends Lottos {

    private final int size;

    public ManualLottos(Price price, int size) {
        super(new ArrayList<>());
        if (price.getNumberOfLotto() < size) {
            throw new IllegalArgumentException();
        }
        this.size = size;
    }

    /**
     * Constructor for test
     */
    public ManualLottos(List<Lotto> lottos) {
        super(lottos);
        this.size = lottos.size();
    }

    public void addLotto(List<Integer> numbers) {
        if (lottos.size() < size) {
            lottos.add(new Lotto(numbers));
        }
    }

    public int getSize() {
        return size;
    }
}
