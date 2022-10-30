package lotto;

import java.util.List;

public class ResultView {
    void resultPay(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    void resultPurchase(List<LottoNumber> lottoNumbers) {
        for (LottoNumber lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }

    void resultWinningStatistics(int payMoney, LottoNumbers lottoNumbers) {
        int fourth = lottoNumbers.getCountOfFourth();
        int third = lottoNumbers.getCountOfThird();
        int second = lottoNumbers.geetCountOfSecond();
        int first = lottoNumbers.getCountOfFirst();

        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + lottoNumbers.getCountOfFourth() + "개");
        System.out.println("4개 일치 (50000원)- " + lottoNumbers.getCountOfThird() + "개");
        System.out.println("5개 일치 (1500000원)- " + lottoNumbers.geetCountOfSecond() + "개");
        System.out.println("6개 일치 (2000000000원)- " + lottoNumbers.getCountOfFirst() + "개");
        System.out.println(
                "총 수익률은 " + (5000 * fourth + 50000 * third + 1500000 * second + 2000000000 * first) / payMoney
                        + "입니다.");
    }
}
