package step3.domain;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class WinningNumber {
    
    private static final String DELIMITER_REGEX = ",";
    private static final String SPACE_REGEX = "\\s";
    private static final String EMPTY = "";
    private final ArrayList<Integer> winningNumbers;
    public WinningNumber(String numberInput) {
        this.winningNumbers = convertToIntList(splitByDelimiter(numberInput));
    }
    
    public ArrayList<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }
    
    private static String[] splitByDelimiter(String text) {
        return text.replaceAll(SPACE_REGEX, EMPTY).split(DELIMITER_REGEX);
    }
    
    private static ArrayList<Integer> convertToIntList(String[] stringArray){
        ArrayList<Integer> result = new ArrayList<>();
        for (String string: stringArray) {
            result.add(parseInt(string));
        }
        return result;
    }
}
