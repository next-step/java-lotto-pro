package camp.nextstep.edu.step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoGenerator() {
        initLottoNumbers();
    }

    private void initLottoNumbers() {
        final int START_NUMBER = 1;
        final int END_NUMBER = 45;
        for (int i = START_NUMBER; i <= END_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
    }

    public Lotto[] auto(final int count) {
        Lotto[] lottoArray = new Lotto[count];
        for (int i = 0; i < lottoArray.length; i++) {
            Collections.shuffle(lottoNumbers);
            lottoArray[i] = (new Lotto(lottoNumbers.subList(0, 6).toArray(new LottoNumber[0])));
        }
        return lottoArray;
    }

    public Lotto manual(final int[] numbers) {
        return new Lotto(Arrays.stream(numbers).mapToObj(LottoNumber::new).distinct().toArray(LottoNumber[]::new));
    }
}
