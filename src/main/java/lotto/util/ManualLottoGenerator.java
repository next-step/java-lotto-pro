package lotto.util;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoGenerator implements LottoGenerator {
    private final List<Integer> numbers;

    public ManualLottoGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public LottoTicket create() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : numbers) {
            lottoNumbers.add(LottoNumber.get(number));
        }

        return LottoTicket.create(lottoNumbers);
    }
}
