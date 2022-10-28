package lotto.util;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
