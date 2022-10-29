package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoLotteryTickets {

    List<LottoNumbers> lottoLotteryTickets = new ArrayList<>();

    public LottoLotteryTickets(int lottoQuantity, LottoNumberGenerator lottoNumberGenerator) {
        for (int i = 0; i < lottoQuantity; i++) {
            LottoNumbers lottoNumber = new LottoNumbers(lottoNumberGenerator);

            lottoLotteryTickets.add(lottoNumber);
        }
    }

    public int size() {
        return this.lottoLotteryTickets.size();
    }

    @Override
    public String toString() {
        return lottoLotteryTickets.stream()
                .map(LottoNumbers::toString)
                .collect(Collectors.joining("\n"));
    }
}
