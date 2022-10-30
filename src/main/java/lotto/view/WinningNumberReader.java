package lotto.view;


public class WinningNumberReader extends LottoReader{

    public int[] readWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] userInputs = readUserInput().split(",");
        int[] winningNumbers = new int[userInputs.length];
        for(int i=0; i< userInputs.length; i++) {
            winningNumbers[i] = Integer.parseInt(userInputs[i]);
        }
        return winningNumbers;
    }

}
