package lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LottoInputView {

    public String readUserInput(String userMessage){
        System.out.println(userMessage);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput = "";
        try {
            userInput = br.readLine();
        } catch (IOException e) {
        }
        return userInput;
    }
}
