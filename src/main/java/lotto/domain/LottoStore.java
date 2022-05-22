package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoNumbers.LOTTO_NUMBERS;
import static lotto.domain.LottoTicket.LOTTO_SIZE;

public class LottoStore {
    public static final int LOTTO_PRICE = 1000;

    public List<LottoTicket> buy(Money money) {
        List<LottoTicket> lottoAutoNumbers = new ArrayList<>();
        for (int i = 0; i < money.ticketCount(); i++) {
            lottoAutoNumbers.add(makeAuto());
        }
        return lottoAutoNumbers;
    }

    public static LottoTicket makeAuto() {
        List<LottoNumber> shuffledNumbers = shuffle();
        List<LottoNumber> autoNumbers = subList(shuffledNumbers);
        Collections.sort(autoNumbers);

        return new LottoTicket(autoNumbers);
    }

    private static List<LottoNumber> shuffle() {
        List<LottoNumber> copyNumbers = new ArrayList<>(LOTTO_NUMBERS);
        Collections.shuffle(copyNumbers);
        return copyNumbers;
    }

    private static List<LottoNumber> subList(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.subList(0, LOTTO_SIZE);
    }
}
