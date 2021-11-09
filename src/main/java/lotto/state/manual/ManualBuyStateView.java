package lotto.state.manual;

import lotto.domain.LotteryTicket;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

public class ManualBuyStateView {
    public void printQuestion(PrintStream out) {
        out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public void printResult(PrintStream out, LotteryTicket lotteryTicket) {
        out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", lotteryTicket.getManualLottoSize(), lotteryTicket.getAutoLottoSize());
        for (LottoNumbers lottoNumbers : lotteryTicket.getLottoNumbersList()) {
            printLottoNumbers(out, lottoNumbers);
        }
        out.println();
    }

    private void printLottoNumbers(PrintStream out, LottoNumbers lottoNumbers) {
        List<LottoNumber> numbers = lottoNumbers.getNumbers();
        String text = numbers.stream()
                .map(LottoNumber::value)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
        out.println(text);
    }
}
