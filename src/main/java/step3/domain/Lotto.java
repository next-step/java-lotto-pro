package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        return new Lotto(numbers);
    }

    private static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6개의 숫자가 필수적으로 입력되어야 합니다.");
        }
    }

    public static Lotto generate() {
        List<Integer> generatedNumbers = getAllShuffleNumber();
        List<Integer> pickedNumbers = getPickedNumbers(generatedNumbers);
        return new Lotto(pickedNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public long getNumberCountContainsBy(Lotto winLotto) {
        return numbers.stream()
                .filter(winLotto.getNumbers()::contains)
                .count();
    }

    private static List<Integer> getPickedNumbers(List<Integer> generatedNumbers) {
        List<Integer> picked = generatedNumbers.subList(0, 6);
        Collections.sort(picked);
        return picked;
    }

    private static List<Integer> getAllShuffleNumber() {
        List<Integer> numbers = getAllLottoNumbers();
        Collections.shuffle(numbers);
        return numbers;
    }

    private static List<Integer> getAllLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
