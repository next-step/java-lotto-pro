package step3;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import step3.domain.LotteryTicket;
import step3.domain.Lotto;
import step3.domain.Payment;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_NUMBER_START = 1;
    private static final int LOTTO_NUMBER_END = 45;

    public LottoGenerator() {
    }

    public Lotto lottoGenerate() {
        List<Integer> lottoRange = convertList(getLottoRange());
        Collections.shuffle(lottoRange);

        List<Integer> lottoNumbers = lottoRange.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    private IntStream getLottoRange() {
        return IntStream.range(LOTTO_NUMBER_START, LOTTO_NUMBER_END);
    }

    private List<Integer> convertList(IntStream lottoRange) {
        return lottoRange.boxed().collect(Collectors.toList());
    }


    public void generateLotteryTicket(LotteryTicket lotteryTicket, Payment payment) {
        for (int i = 0; i < payment.getAutoLottoCount(); i++) {
            lotteryTicket.add(lottoGenerate());
        }
    }
}
