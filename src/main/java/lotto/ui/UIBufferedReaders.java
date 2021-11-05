package lotto.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UIBufferedReaders {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static String readLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("reading 중 오류가 발생하였습니다.");
        }
        return "";
    }
}
