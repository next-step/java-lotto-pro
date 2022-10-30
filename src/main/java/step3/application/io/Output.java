package step3.application.io;

import static java.util.Collections.*;

import java.util.ArrayDeque;
import java.util.Arrays;
import step3.domain.Lotto;
import step3.domain.LottoNumber;
import step3.domain.Lottos;
import step3.domain.Rank;
import step3.domain.Statistics;

public class Output {

    public void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void lottos(Lottos lottos) {
        System.out.println(String.format("%s개를 구매했습니다.", lottos.size()));
        for (Lotto lotto : lottos.content()) {
            printLottoNumber(lotto);
        }
        System.out.println();
    }

    public void inputWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void result(Statistics statistics) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");


        Arrays.stream(Rank.values())
            .filter(Rank::isNotMiss)
            .sorted(reverseOrder())
            .forEach(rank -> printMatch(statistics, rank));

        System.out.println(String.format("총 수익률은 %s입니다.", statistics.totalReward()));
    }

    private void printLottoNumber(Lotto lotto) {
        ArrayDeque<LottoNumber> queue = new ArrayDeque<>(lotto.numbers());

        StringBuffer sb = new StringBuffer();

        LottoNumber lottoNumber = queue.removeFirst();
        sb.append(lottoNumber.get());

        while(!queue.isEmpty()) {
            lottoNumber = queue.removeFirst();
            sb.append(", ");
            sb.append(lottoNumber.get());
        }
        System.out.println(String.format("[%s]", sb));
    }

    private void printMatch(Statistics statistics, Rank rank) {
        System.out.println(String.format("%s개 일치 (%s) - %s개", rank.matchCount(), rank.reward(), statistics.count(rank)));
    }
}
