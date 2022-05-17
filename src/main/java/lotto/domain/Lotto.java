package lotto.domain;

import lotto.view.OutputView;

import java.util.*;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto() {
        this.lottoNumbers = LottoNumber.generateLottoNumbers();
    }

    public Lotto(String input) {
        String[] inputArr = input.replace(" ", "").split(",");
        vaildCount(inputArr);
        List<LottoNumber> list = new ArrayList<>();
        for (String s : inputArr) {
            list.add(new LottoNumber(s));
        }
        Collections.sort(list);
        this.lottoNumbers = list;
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public int match(Lotto target) {
        int count = 0;
        for (LottoNumber lottoNumber : target.getLottoNumbers()) {
            if (this.lottoNumbers.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    private void vaildCount(String[] input) {
        Set<String> set = new HashSet<>();
        for (String s : input) {
            set.add(s);
        }
        if (set.size() != 6) {
            OutputView.printErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
