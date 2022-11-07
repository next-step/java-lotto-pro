package view;

import domain.LottoMachine;
import domain.Lottos;
import domain.ManualLottoMachine;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static int inputReadPurchaseMoney() {
        System.out.println("구매 금액을 입력해 주세요.");
        return sc.nextInt();
    }

    public static String inputWinLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }

    public static int inputManualLottoCount(){
        sc.nextLine();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return sc.nextInt();
    }

    public static Lottos inputManualLottos(int manualLottoCount, Lottos lottos ){
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        sc.nextLine();
        LottoMachine lottoMachine = new ManualLottoMachine();
        for(int i=0; i<manualLottoCount; i++){
          lottos.add(lottoMachine.splitPurchaseLottoNumbers(sc.nextLine()));
        }

        return lottos;
    }

}
