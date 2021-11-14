package step3.machine.create;

import java.util.List;

import step3.lotto.LottoPapers;

public interface Machine {

	default LottoPapers createLotto(Integer buyCount) {
		throw new UnsupportedOperationException("생성된 객체는 자동입니다. 자동은 정수 값을 입력해야합니다.");
	}

	default LottoPapers createLotto(List<String> buyCount) {
		throw new UnsupportedOperationException("생성된 객체는 수동입니다. 수동은 입력값은 문자열 리스트를 입력해야합니다.");
	}

}
