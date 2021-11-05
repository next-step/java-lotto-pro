package exception;

public class BusinessException extends RuntimeException{
	private ErrorMessages errorMessages;

	public BusinessException(ErrorMessages errorMessages) {
		super(errorMessages.getValues());
		this.errorMessages = errorMessages;
	}

	public BusinessException(Throwable cause, ErrorMessages errorMessages) {
		super(errorMessages.getValues(), cause);
		this.errorMessages = errorMessages;
	}

}
