package lotto;

import java.util.List;

public class ResultView {
    void resultPay(int purchaseCount) {
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    void resultPurchase(List<LottoNumber> lottoNumbers) {
        for (LottoNumber lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }

    void resultWinningStatistics(int payMoney, Prize prize) {
        int fourth = prize.getCountOfFourth();
        int third = prize.getCountOfThird();
        int second = prize.getCountOfSecond();
        int first = prize.getCountOfFirst();

        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + fourth + "개");
        System.out.println("4개 일치 (50000원)- " + third + "개");
        System.out.println("5개 일치 (1500000원)- " + second + "개");
        System.out.println("6개 일치 (2000000000원)- " + first + "개");
        System.out.println(
                "총 수익률은 " + (5000 * fourth + 50000 * third + 1500000 * second + 2000000000 * first) / payMoney
                        + "입니다.");
    }
}
