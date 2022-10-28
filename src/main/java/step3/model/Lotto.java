package step3.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int NUMBER_SIZE = 6;
    private static final String NUMBER_SIZE_MESSAGE = "번호는 6개만 허용합니다";
    private static final String DUPLICATE_NUMBER_MESSAGE = "중복없는 번호만 허용합니다";

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public int getPrice() {
        return PRICE;
    }

    public List<LottoNumber> getNumbers() {
        return numbers.stream().collect(Collectors.toList());
    }

    private void validateNumbers(List<LottoNumber> numbers) {
        Set<LottoNumber> distinctNumbers = new HashSet(numbers);
        if (distinctNumbers.size() != numbers.size()) throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        if (distinctNumbers.size() != NUMBER_SIZE) throw new IllegalArgumentException(NUMBER_SIZE_MESSAGE);
    }

    public Rank getRank(List<LottoNumber> winningNumbers) {
        int count = (int) numbers
                .stream()
                .filter(lottoNumber -> winningNumbers.contains(lottoNumber))
                .count();
        return Rank.valueOf(count);
    }

    public Rank getRank(List<LottoNumber> winningNumbers,LottoNumber bonusNumber) {
        int count = (int) numbers
                .stream()
                .filter(lottoNumber -> winningNumbers.contains(lottoNumber))
                .count();
        boolean isBonus = numbers.contains(bonusNumber);
        return Rank.valueOf(count,isBonus);
    }

}
