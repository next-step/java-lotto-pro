package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoNumbers.LOTTO_NUMBERS;

public class LottoStore {
    private static List<LottoTicket> buyAuto(int size) {
        List<LottoTicket> lottoAutoNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottoAutoNumbers.add(makeAuto());
        }
        return lottoAutoNumbers;
    }

    private static LottoTicket makeAuto() {
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
        return lottoNumbers.subList(0, LottoTicket.SIZE);
    }

    public static LottoTickets buy(Money money, List<LottoTicket> manualTickets) {
        List<LottoTicket> autoTickets = buyAuto(money.autoCount(manualTickets.size()));
        return new LottoTickets(manualTickets, autoTickets);
    }
}
