package lotto.model.lotto.ticket;

import lotto.constant.numbers.LottoConstant;
import lotto.model.winning.numbers.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * 자동 생성한 6 개의 로또 번호 한 줄을 저장하고 관리하는 객체이다.
 */
public class LottoTicket {
    protected final List<Integer> numbers;

    public LottoTicket(LottoNumberGenerator lottoNumberGenerator) {
        numbers = new ArrayList<>(LottoConstant.COUNT_OF_NUMBERS_IN_SINGLE_LOTTO_TICKET);
        for (int i = 0; i < LottoConstant.COUNT_OF_NUMBERS_IN_SINGLE_LOTTO_TICKET; ++i) {
            final int generatedRandomNumber = lottoNumberGenerator.generate();
            numbers.add(generatedRandomNumber);
        }
    }

    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int sameNumbersCount(WinningNumbers winningNumbers) {
        List<Integer> intWinningNumbers = winningNumbers.primitiveNumbers();
        int count = 0;
        for (int current : numbers) {
            count = incrementCountIfWinningNumbersContainCurrentNumber(intWinningNumbers, current, count);
        }
        return count;
    }

    private int incrementCountIfWinningNumbersContainCurrentNumber(List<Integer> intWinningNumbers, int current,
                                                                   int count) {
        if (intWinningNumbers.contains(current)) {
            return count + 1;
        }
        return count;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
