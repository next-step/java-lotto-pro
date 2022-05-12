package helper;

import camp.nextstep.edu.level1.lotto.lotto.LottoNumbers;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.fail;

public class LottoNumbersGenerator {

    private LottoNumbersGenerator() {}

    public static LottoNumbers createLottoNumbersHasValue(Integer ...dist) {
        if (dist.length != 6) {
            fail("로또 번호는 6자리이어야 합니다.");
        }

        RandomGeneratorHelper.changeRandomUniqueNumberResult(Arrays.stream(dist).collect(Collectors.toSet()));
        return new LottoNumbers();
    }
}
