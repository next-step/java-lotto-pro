package domain.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumberGenerateStrategy implements NumberGenerateStrategy {
    public static NumberGenerateStrategy DEFAULT = new RandomNumberGenerateStrategy();

    private RandomNumberGenerateStrategy() {
    }

    @Override
    public Set<Integer> generate(List<Integer> numberPool, int size) {
        Collections.shuffle(numberPool);
        Set<Integer> result = new HashSet<>();
        int count = 0;
        while (result.size() < size) {
            result.add(numberPool.get(count));
            count++;
        }
        return result;
    }
}
