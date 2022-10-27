package step3.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<LottoNumber> numbers;

    public void create() {
        List<LottoNumber> allNumbers = settingLottoRangeNumber();
        Collections.shuffle(allNumbers);

        this.numbers = allNumbers.subList(0, 6);
        Collections.sort(this.numbers);
    }

    private List<LottoNumber> settingLottoRangeNumber() {
        List<LottoNumber> allNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            allNumbers.add(new LottoNumber(i));
        }
        return allNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "" + numbers;
    }
}
