import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;

public class ConsoleOutputView {
    public void view(String string) {
        System.out.println(string);
    }
    public void view(Lotto lotto) {
        for (LottoNumbers lottoNumbers : lotto) {
            System.out.println(lottoNumbers);
        }
        System.out.println();
    }

    public void view(Ranks ranks, BigDecimal yield) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(Rank.values()).sorted(Collections.reverseOrder()).filter(Rank::win).forEach(rank -> {
            System.out.println(rank + " - " + ranks.count(rank) + "개");
        });

        BigDecimal scaledYield = yield.setScale(2, RoundingMode.DOWN);
        System.out.println("총 수익률은 " + scaledYield.doubleValue() + "입니다.");
    }
}
