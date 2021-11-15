package lotto;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.LotteryTicketFactory.FIRST_NUMBER_IN_LOTTERY_TICKET;
import static lotto.LotteryTicketFactory.LAST_NUMBER_IN_LOTTERY_TICKET;

public class LotteryNumbers {
    public static final String LOTTO_NUMBER_POSITIVE_MESSAGE = "로또 번호는 1과 45 사이의 정수이어야합니다.";
    public static final String LOTTO_NUMBER_DUPLICATE_MESSAGE = "로또 번호에 중복된 번호가 있으면 안됩니다.";

    private final List<Integer> lottoNumbers;

    private LotteryNumbers(List<Integer> lottoNumbers) {
        validateDuplicate(lottoNumbers);
        validateLottoNumberRange(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoNumberRange(List<Integer> lottoNumbers) {
        for (int lottoNo : lottoNumbers) {
            validateRange(lottoNo);
        }
    }

    private void validateRange(int lottoNo) {
        if (lottoNo < FIRST_NUMBER_IN_LOTTERY_TICKET || lottoNo > LAST_NUMBER_IN_LOTTERY_TICKET) {
            throw new IllegalArgumentException(LOTTO_NUMBER_POSITIVE_MESSAGE);
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
        return new LotteryNumbers(Arrays.stream(enterManualLotteryNumbers)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList()));
    }

    public static LotteryNumbers createWinningLotteryNumber(String[] winningNumber) {
        return new LotteryNumbers(Arrays.stream(winningNumber)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList()));
    }

    public int countMatch(LotteryNumbers winningNumber) {
        int cnt = 0;
        for (int no : winningNumber.getLotteryNumber()) {
            if (lottoNumbers.contains(no)) {
                cnt++;
            }
        }
        return cnt;
    }

    public boolean isMatchBonus(int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public int size() {
        return lottoNumbers.size();
    }

    public List<Integer> getLotteryNumber() {
        return lottoNumbers;
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
