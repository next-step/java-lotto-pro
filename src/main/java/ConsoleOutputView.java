import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleOutputView {
    public void view(Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (LottoNumbers lottoNumbers : lottos) {
            System.out.println(lottoNumbers);
        }
        System.out.println();
    }

    public void view(Aggregator aggregator) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(Prize.values()).sorted(Collections.reverseOrder()).filter(Prize::win).forEach(prize -> {
            System.out.println(prize + " - " + aggregator.countGroupBy(prize) + "개");
        });
        BigDecimal bd = aggregator.yield().setScale(2, RoundingMode.DOWN);
        System.out.println("총 수익률은 " + bd.doubleValue() + "입니다.");
    }
}
