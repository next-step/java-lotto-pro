package lotto.auto;

import lotto.domain.LotteryTicket;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

public class FirstStateView {
    public void printQuestion(PrintStream out) {
        out.println("구입금액을 입력해 주세요.");
    }

    public void printResult(PrintStream out, LotteryTicket lotteryTicket) {
        out.printf("%d개를 구매했습니다.%n", lotteryTicket.size());
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
