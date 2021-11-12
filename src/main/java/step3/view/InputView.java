package step3.view;

import java.util.List;

public interface InputView {
	int insertMoney();
	int insertBonusBall();
	int insertManualCount();
	List<String> insertManualLottoNumbers(int manualCount);
	String insertLottoNumber();

}
