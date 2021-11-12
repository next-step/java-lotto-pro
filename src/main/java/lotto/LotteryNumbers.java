package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LotteryNumbers {
    private final List<Integer> lottoNumbers;

    public LotteryNumbers(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LotteryNumbers createAutoLotteryNumber(List<Integer> autoPickedLottoNumber) {
        return new LotteryNumbers(autoPickedLottoNumber);
    }

    public int size() {
        return lottoNumbers.size();
    }

    public List<Integer> getLotteryNumber() {
        return lottoNumbers;
    }

    public boolean contains(int no) {
        return lottoNumbers.contains(no);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LotteryNumbers that = (LotteryNumbers) o;

        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return lottoNumbers != null ? lottoNumbers.hashCode() : 0;
    }
}
