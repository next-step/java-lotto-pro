package step3.machine.create;

public enum LottoMachineType {

	AUTO(new AutoMachine()),
	MANUAL(new ManualMachine());

	private Machine machine;

	LottoMachineType(Machine machine) {
		this.machine = machine;
	}

	public static Machine lottoFactory(LottoMachineType lottoMachineType) {
		switch (lottoMachineType) {
			case AUTO :
				return AUTO.machine;
			case MANUAL :
				return MANUAL.machine;
			default :
				throw new IllegalArgumentException("입력한 타입이 존재하지 않습니다.");
		}
	}
}
