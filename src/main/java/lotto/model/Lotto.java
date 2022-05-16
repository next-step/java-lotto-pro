package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.constant.LottoRank;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        Collections.sort(numbers);
        this.numbers = convertLottoNumbers(numbers);
    }

    private List<LottoNumber> convertLottoNumbers(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>(numbers.size());
        for (int number : numbers){
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }

    public int[] convertNumbers() {
        return numbers.stream()
                .mapToInt(LottoNumber::getNumber)
                .toArray();
    }

    public LottoRank matchRank(List<Integer> winningNumberList, BonusNumber bonusNumber) {
        return LottoRank.of(matchNumberCount(winningNumberList), bonusNumber.matchBonusNumber(toList()));
    }

    private int matchNumberCount(List<Integer> winningNumberList) {
        return Math.toIntExact(winningNumberList.stream()
                .filter(toList()::contains)
                .count());
    }

    private List<Integer> toList(){
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
