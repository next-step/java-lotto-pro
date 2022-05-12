package helper;

import camp.nextstep.edu.until.RandomGenerator;

import java.util.Set;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

public class RandomGeneratorHelper {
    private RandomGeneratorHelper() {}

    public static void changeRandomUniqueNumberResult(Set<Integer> value) {
        given(RandomGenerator.createNonDuplicatedIntegerSet(anyInt(), anyInt(), anyInt())).willReturn(value);
    }
}
