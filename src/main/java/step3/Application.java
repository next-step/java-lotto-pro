package step3;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        
        int payment = inputView.inputPayment();
        
        Calculator calculator = new Calculator(payment);
        resultView.resultPayment(calculator.getLottoCount());
    
        String input = inputView.inputWinningNumber();
        ArrayList<Integer> winningNumbers = convertToIntList(splitByDelimiter(input));
        LotteryTicket lotteryTicket = new LotteryTicket(winningNumbers);
        
        for (int i = 0; i < calculator.getLottoCount(); i++){
            LottoGenerator lottoGenerator = new LottoGenerator();
            List<Integer> lottoNumbers = lottoGenerator.getLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lotteryTicket.add(lotto);
        }
        
        resultView.resultLotteryTicket(lotteryTicket);
        resultView.resultStatistics(lotteryTicket, payment);
        

    }
    private static final String DELIMITER_REGEX = ",";
    private static final String SPACE_REGEX = "\\s";
    private static final String EMPTY = "";
    
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
