package lotto_auto.view;

import lotto_auto.model.*;

import java.util.*;
import java.util.stream.Collectors;

public class UserInputView {
    private static final Scanner scan = new Scanner(System.in);
    public String getUserInput() {
        return scan.nextLine();
    }
    public void closeUserInput() {
        scan.close();
    }

    public String getUserInputMoney() {
        Output.showMoneyInputNotice();
        return getUserInput();
    }

    public String getManualLottoCountUserInput() {
        Output.showManualLottoCountNotice();
        return getUserInput();
    }
}
