package step3.model;

import step3.constant.StringConstant;
import step3.service.LottoGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        validateWinningNumbers(lotto);

        this.lotto = generateLotto(lotto);
    }

    private List<Integer> generateLotto(List<Integer> lottoNumbers) {
        List<Integer> lotto = new ArrayList<>();
        for (Integer number : lottoNumbers) {
            lotto.add(number);
        }

        Collections.sort(lotto);

        return lotto;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        validateNull(winningNumbers);
        validateSizeSixNumbers(winningNumbers);
        validateDuplicatedNumbers(winningNumbers);
        isExceedRange(winningNumbers);
    }

    private void validateDuplicatedNumbers(List<Integer> winningNumbers) {
        if (isDuplicated(winningNumbers)) {
            throw new RuntimeException("증복된 숫자가 있습니다.");
        }
    }

    private void validateSizeSixNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new RuntimeException("6자리 수만 입력받을수있습니다.");
        }
    }

    private void validateNull(List<Integer> winningNumbers) {
        if (winningNumbers == null) {
            throw new RuntimeException("행운의번호가 널입니다.");
        }
    }

    private void isExceedRange(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            isNotBetween(number);
        }
    }

    private void isNotBetween(int number) {
        if (number < LottoGenerator.LOTTO_START_NUMBER || number > LottoGenerator.LOTTO_END_NUMBER) {
            throw new RuntimeException("로또범위의 숫자가 아닙니다.");
        }
    }

    private boolean isDuplicated(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);

        return uniqueNumbers.size() != winningNumbers.size();
    }

    public boolean contains(int number) {
        return this.lotto.contains(number);
    }

    @Override
    public String toString() {
        return lotto.stream()
                .map(Object::toString)
                .collect(Collectors.joining(StringConstant.COMMA));
    }

    public int getMatchedCount(LottoWinningNumber lottoWinning) {
        int count = 0;
        for (int lottoNumber : this.lotto) {
            count = getCount(count, lottoWinning.containWinningNumber(lottoNumber));
        }

        return count;
    }

    private int getCount(int count, boolean isContain) {
        if (isContain) {
            count++;
        }

        return count;
    }

    public boolean isMatchedBonus(LottoWinningNumber winningLotto) {
        boolean isMatched = false;
        for (int lottoNumber : lotto) {
            isMatched = isMatched || winningLotto.isMatchedBonusNumber(lottoNumber);
        }
        return isMatched;
    }
}
