package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    public static final int LOTTO_NUMBER_SIZE = 6;

    private List<LottoNumber> lotto = new ArrayList<>();

    private Lotto(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        for (Integer number : lottoNumbers) {
            lotto.add(new LottoNumber(number));
        }
    }

    public static Lotto create(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
