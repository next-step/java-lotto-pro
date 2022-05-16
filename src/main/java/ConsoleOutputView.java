import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;

public class ConsoleOutputView {
    public void view(Lotto lotto) {
        System.out.println(lotto.size() + "개를 구매했습니다.");
        for (LottoNumbers lottoNumbers : lotto) {
            System.out.println(lottoNumbers);
        }
        System.out.println();
    }

    public void view(Aggregator aggregator) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(Rank.values()).sorted(Collections.reverseOrder()).filter(Rank::win).forEach(prize -> {
            System.out.println(prize + " - " + aggregator.countGroupBy(prize) + "개");
        });
        BigDecimal bd = aggregator.yield().setScale(2, RoundingMode.DOWN);
        System.out.println("총 수익률은 " + bd.doubleValue() + "입니다.");
    }
}
