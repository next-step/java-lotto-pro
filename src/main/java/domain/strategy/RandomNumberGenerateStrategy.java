package domain.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerateStrategy implements NumberGenerateStrategy {
    public static NumberGenerateStrategy DEFAULT = new RandomNumberGenerateStrategy();

    private RandomNumberGenerateStrategy() {
    }

    @Override
    public List<Integer> generate(List<Integer> numberPool, int size) {
        Collections.shuffle(numberPool);
        return numberPool.subList(0, size);
    }
}
