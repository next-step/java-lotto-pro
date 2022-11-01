package lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LottoInputView {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public String readUserInput(String userMessage){
        System.out.println(userMessage);
        String userInput = "";
        try {
            userInput = br.readLine();
        } catch (IOException e) {
        }
        return userInput;
    }
}
