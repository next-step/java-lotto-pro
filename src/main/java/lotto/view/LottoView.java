package lotto.view;

import lotto.domain.LottoBundle;
import lotto.domain.LottoResult;

public class LottoView {
    private LottoView() {
        throw new UnsupportedOperationException();
    }

    public static void printLottoBundleStatus(LottoBundle lottoBundle) {
        System.out.printf("%d개를 구매했습니다.%n", lottoBundle.getLottoCount());
        System.out.println(lottoBundle.getStatus());
    }

    public static void printResult(LottoResult lottoResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n당첨 통계\n");
        sb.append("---------\n");

        sb.append(lottoResult.getRankStatus());
        sb.append(String.format("총 수익률은 %f입니다.", lottoResult.computeEarningRate()));

        if (lottoResult.computeEarningRate() < 1) {
            sb.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }

        System.out.println(sb);
    }
}
