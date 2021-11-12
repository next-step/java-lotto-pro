package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LotteryNumbers {
    public static final String LOTTO_NUMBER_NEGATIVE_MESSAGE = "로또 번호가 음수일 수 없습니다.";
    public static final String LOTTO_NUMBER_DUPLICATE_MESSAGE = "로또 번호에 중복된 번호가 있으면 안됩니다.";

    private final List<Integer> lottoNumbers;

    public LotteryNumbers(List<Integer> lottoNumbers) {
        validateDuplicate(lottoNumbers);
        validatePositive(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validatePositive(List<Integer> lottoNumbers) {
        for (int lottoNo : lottoNumbers) {
            isNegative(lottoNo);
        }
    }

    private void isNegative(int lottoNo) {
        if (lottoNo < 0) {
            throw new IllegalArgumentException(LOTTO_NUMBER_NEGATIVE_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> lottoNumbers) {
        Set<Integer> set = new HashSet<>(lottoNumbers);
        if (set.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_MESSAGE);
        }
    }

    public static LotteryNumbers createAutoLotteryNumber(List<Integer> autoPickedLottoNumber) {
        return new LotteryNumbers(autoPickedLottoNumber);
    }

    public static LotteryNumbers createManualLotteryNumber(String[] enterManualLotteryNumbers) {
        return new LotteryNumbers(Arrays.stream(enterManualLotteryNumbers).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));
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
