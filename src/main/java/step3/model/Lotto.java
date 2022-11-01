package step3.model;

import step3.service.LottoGenerator;
import step3.constant.StringConstant;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        validateLuckyNumbers(lotto);

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

    private void validateLuckyNumbers(List<Integer> luckyNumbers) {
        validateNull(luckyNumbers);
        validateSizeSixNumbers(luckyNumbers);
        validateDuplicatedNumbers(luckyNumbers);
        isExceedRange(luckyNumbers);
    }

    private void validateDuplicatedNumbers(List<Integer> luckyNumbers) {
        if (isDuplicated(luckyNumbers)) {
            throw new RuntimeException("증복된 숫자가 있습니다.");
        }
    }

    private void validateSizeSixNumbers(List<Integer> luckyNumbers) {
        if (luckyNumbers.size() != 6) {
            throw new RuntimeException("6자리 수만 입력받을수있습니다.");
        }
    }

    private void validateNull(List<Integer> luckyNumbers) {
        if (luckyNumbers == null) {
            throw new RuntimeException("행운의번호가 널입니다.");
        }
    }

    private void isExceedRange(List<Integer> luckyNumbers) {
        for (int number : luckyNumbers) {
            isNotBetween(number);
        }
    }

    private void isNotBetween(int number) {
        if (number < LottoGenerator.LOTTO_START_NUMBER || number > LottoGenerator.LOTTO_END_NUMBER) {
            throw new RuntimeException("로또범위의 숫자가 아닙니다.");
        }
    }

    private boolean isDuplicated(List<Integer> luckyNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(luckyNumbers);

        return uniqueNumbers.size() != luckyNumbers.size();
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

    public int getMatchedCount(Lotto winningLotto) {
        Iterator<Integer> winningNumbers = winningLotto.iterate();
        int count = 0;
        while (winningNumbers.hasNext()) {
            boolean isContain = contains(winningNumbers.next());
            count = getCount(count, isContain);
        }

        return count;
    }

    private int getCount(int count, boolean isContain) {
        if (isContain) {
            count++;
        }

        return count;
    }

    private Iterator<Integer> iterate() {
        return this.lotto.iterator();
    }
}
