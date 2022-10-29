package lotto;

import lotto.view.InputView;

import java.util.List;

public class LottoNumberBag {

    private List<Integer> lottoNumbers;

    public LottoNumberBag() {
        this.lottoNumbers = LottoNumberGenerator.generate();
        InputView.printNumbers(lottoNumbers);
    }

    public LottoNumberBag(List<Integer> numbers) {
        // Test를 위해 만든 생성자
        // validation 로직이 필요할까..?
        lottoNumbers = numbers;
    }

    public int correctCount(List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
