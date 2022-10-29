package lotto;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    void resultPay(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    List<LottoNumber> resultPurchase(LottoNumberGenerator lottoNumberGenerator, int countPurchase) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < countPurchase; i++) {
            List<Integer> sixNumbers = lottoNumberGenerator.generateSixNumbers();
            System.out.println(sixNumbers);
            lottoNumbers.add(new LottoNumber(sixNumbers));
        }
        return lottoNumbers;
    }

    void resultWinningStatistics(int payMoney, LottoNumbers lottoNumbers) {
        int fourth = lottoNumbers.countFourth();
        int third = lottoNumbers.countThird();
        int second = lottoNumbers.countSecond();
        int first = lottoNumbers.countFirst();

        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + lottoNumbers.countFourth() + "개");
        System.out.println("4개 일치 (50000원)- " + lottoNumbers.countThird() + "개");
        System.out.println("5개 일치 (1500000원)- " + lottoNumbers.countSecond() + "개");
        System.out.println("6개 일치 (2000000000원)- " + lottoNumbers.countFirst() + "개");
        System.out.println(
                "총 수익률은 " + (5000 * fourth + 50000 * third + 1500000 * second + 2000000000 * first) / payMoney
                        + "입니다.");
    }
}
