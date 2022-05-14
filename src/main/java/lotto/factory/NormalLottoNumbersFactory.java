package lotto.factory;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;
import lotto.number.NormalLottoNumbers;

public class NormalLottoNumbersFactory implements LottoNumbersFactory {
    @Override
    public LottoNumbers createRandomLottoNumbers() {
        return this.createLottoNumbers(randomLottoNumberList());
    }

    private List<Integer> randomLottoNumberList() {
        List<Integer> numbers = IntStream
                .range(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER + 1)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.subList(0, NormalLottoNumbers.LOTTO_NUMBERS_SIZE);
    }

    @Override
    public LottoNumbers createLottoNumbers(List<Integer> numbers) {
        checkNumbers(numbers);
        List<LottoNumber> lottoNumberList = numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
        return new NormalLottoNumbers(lottoNumberList);
    }

    private void checkNumbers(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != NormalLottoNumbers.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("서로 다른 " + NormalLottoNumbers.LOTTO_NUMBERS_SIZE + "개의 숫자가 필요합니다.");
        }
    }
}
