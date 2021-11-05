package lotto.controller;

import lotto.util.Console;
import lotto.view.Message;
import lotto.view.View;

public class LottoController {


    public void start(){
        View.print(Message.PURCHASE_AMOUNT);
        try {
            inputPurchase();
        }catch (Exception e){
            View.print(e.getMessage());
        }


    }

    //로또 구입
    private void inputPurchase() {
        String input = Console.readLine();

    }
    /*
    *
    *
    * 로또 갯수 표출
    *
    * 로또 표출
    *
    * 당첨 번호 입력
    * */
}
