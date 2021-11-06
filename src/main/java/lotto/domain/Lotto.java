package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Lotto {
    private final List<Integer> lottoNumbers;
    private WinningRank winningRank;

    public Lotto() {
        this.lottoNumbers = this.makeLottoNumber();
    }
    
    public Lotto(Lotto winningLotto) {
        this.lottoNumbers = this.makeLottoNumber();
        resultLotto(winningLotto);
    }

    public Lotto(String lottoNumber) {
        String[] splitNumbers = lottoNumber.split(",");
        this.lottoNumbers = Arrays.asList(Stream.of(splitNumbers).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new));
    }

    public int getSize() {
        return this.lottoNumbers.size();
    }
    

    public WinningRank getWinningRank() {
        return winningRank;
    }

    public List<Integer> makeLottoNumber() {
        List<Integer> numberRange = new ArrayList<Integer>();
        for (int i = 1; i <= 45; i++) {
            numberRange.add(i);
        }
        Collections.shuffle(numberRange);
        List<Integer> lottoNumber = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++) {
            lottoNumber.add(numberRange.get(i));
        }
        Collections.sort(lottoNumber);
        return lottoNumber;

    }

    public String getNumbers() {
        return Arrays.deepToString(lottoNumbers.toArray());
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }
    
    public WinningRank getResult() {
        return this.winningRank;
    }

    public void resultLotto(Lotto winningLotto) {
        this.winningRank = WinningRank.result(countMatchNumber(winningLotto));
    }

    private int countMatchNumber(Lotto winningLotto) {
        int count = 0;
        List<Integer> winningNumbers = winningLotto.getLottoNumbers();
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

}
