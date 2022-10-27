package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<Integer> range;

    private List<Integer> lottoNumbers;

    private int matchCount;

    public Lotto() {
        this.range = new ArrayList<>();
        initLotto();
        shuffle(range);
        this.lottoNumbers = range.subList(0, 6);
    }

    public Lotto(List<Integer> manualLottoNumbers) {
        this.lottoNumbers = manualLottoNumbers;
    }

    public List<Integer> gainAutoNumbers() {
        return lottoNumbers;
    }

    public void match(List<Integer> winningNumbers) {
        Collections.sort(winningNumbers);
        Collections.sort(lottoNumbers);
        lottoNumbers.retainAll(winningNumbers);
        this.matchCount = lottoNumbers.size();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    private List<Integer> initLotto() {
        for (int i = 1; i <= 45; i++) {
            range.add(i);
        }
        return range;
    }

    private void shuffle(List<Integer> initLottoNumbers) {
        Collections.shuffle(initLottoNumbers);
    }

}
