package lotto.ui;

import java.util.Scanner;
/**
 *  피드백 내용 : 1) 함수의 기능을 분리하자. readLine에서는 readLine역할만 하자
 * */
/**
 * packageName : lotto.ui
 * fileName : InputView
 * author : haedoang
 * date : 2021-11-05
 * description :
 */
public class InputView {
    private static Scanner scanner;
    static {
        scanner = new Scanner(System.in);
    }
    private InputView() {}

    public static String readLine() {
        return scanner.nextLine();
    }


}
