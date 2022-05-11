package camp.nextstep.edu.until;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomGenerator {
    private static final Random random = new Random();

    public static Set<Integer> createNonDuplicatedIntegerSet(int from, int to, int range) {
        checkValidRange(from, to, range);

        Set<Integer> result = new HashSet<>();

        while (result.size() < range) {
            int randomIntResult = random.ints(from, to)
                    .findFirst()
                    .orElseThrow(RuntimeException::new);

            result.add(randomIntResult);
        }

        return result;
    }

    private static void checkValidRange(int from, int to, int range) {
        if (to - from - range < 0) {
            String message = String.format("범위가 생성할 수 있는 수보다 큽니다. from: %d, to: %d, range: %d", from, to, range);

            throw new IllegalArgumentException(message);
        }
        if (range < 0) {
            String message = String.format("번위는 음수일 수 없습니다. range: %d", range);

            throw new IllegalArgumentException(message);
        }
    }
}
