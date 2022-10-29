package model;

import java.util.ArrayList;
import java.util.Arrays;
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

    public Result match(WinningNumbers winningNumbers) {
        Result result = new Result();

        for (LottoNumbers lottoNumbers : lottoLotteryTickets) {
            result.addResultPerTicket(winningNumbers.match(lottoNumbers));
        }

        return result;
    }

    @Override
    public String toString() {
        return lottoLotteryTickets.stream()
                .map(LottoNumbers::toString)
                .collect(Collectors.joining("\n"));
    }
}
