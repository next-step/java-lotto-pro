package lotto.auto;

import java.io.PrintStream;
import java.util.List;

public class FirstStateView {
    public void printQuestion(PrintStream out) {
        out.println("구입금액을 입력해 주세요.");
    }

    public void printResult(PrintStream out, List<String> result) {
        out.printf("%d개를 구매했습니다.%n", result.size());
        for (String lottoNumbers : result) {
            out.println(lottoNumbers);
        }
        out.println();
    }
}
