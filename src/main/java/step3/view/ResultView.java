package step3.view;

import step3.domain.Grades;
import step3.domain.Lotto;
import step3.domain.LottoQuantity;
import step3.domain.Lottos;
import step3.domain.enums.Grade;

public class ResultView {

    public static void printLottoQuantityMessage(LottoQuantity lottoQuantity) {
        System.out.printf("%d개를 구매했습니다.\n", lottoQuantity.getQuantity());
    }

    public static void printLottosNumberMessage(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printTotalGrades(Grades grades) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Grade grade : Grade.values()) {
            printGradeIfNotDraw(grades, grade);
        }
    }

    private static void printGradeIfNotDraw(Grades grades, Grade grade) {
        if (grade != Grade.DRAW) {
            System.out.printf("%d개 일치 (%d원) - %d개\n", grade.getCount(), grade.getAmount(),
                    grades.getGradeCount(grade));
        }
    }
}
