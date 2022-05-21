package lotto;

import lotto.model.Lottos;
import lotto.model.UserMoney;
import util.NumberUtil;

public class User {
	private UserMoney userMoney;
	private Lottos manualLottos;
	private Lottos autoLottos;

	public User(UserMoney userMoney) {
		this.userMoney = userMoney;
	}

	public void buyManualLottos(LottoMachine lottoMachine, Lottos lottos) {
		validation(lottoMachine, String.valueOf(lottos.size()));
		this.manualLottos = lottoMachine.buyManualLottos(userMoney, lottos);
	}

	public void buyAutoLottos(LottoMachine lottoMachine) {
		this.autoLottos = lottoMachine.buyAutoLottos(userMoney);
	}

	public void isCanBuyLotto(LottoMachine lottoMachine, String pieceCount) {
		validation(lottoMachine, pieceCount);
	}

	private void validation(LottoMachine lottoMachine, String pieceCount) {
		validationNumber(pieceCount);
		validationPieceCount(lottoMachine, pieceCount);
	}

	private void validationNumber(String pieceCount) {
		if (!NumberUtil.isNumber(pieceCount)) {
			throw new IllegalArgumentException(String.format("nubmer: %d 숫자가 아닙니다.", pieceCount));
		}
	}

	private void validationPieceCount(LottoMachine lottoMachine, String pieceCount) {
		if (!lottoMachine.isCanBuyLotto(userMoney, Integer.parseInt(pieceCount))) {
			throw new IllegalArgumentException(
					"로또를 구매할 수 있는 수량을 초과했습니다. 구입가능 로또의 갯수 : " + userMoney.getMoney() / lottoMachine.lottoPrice());
		}
	}

	public UserMoney getUserMoney() {
		return this.userMoney;
	}

	public Lottos getAutoLottos() {
		return this.autoLottos;
	}

	public Lottos getManualLottos() {
		return this.manualLottos;
	}
}
