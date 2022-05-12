package exception;

public enum ExceptionMessage {

   NOT_POSITIVE_NUMBER("구분자를 제외하고 숫자(양수)만 입력 가능합니다.");

   private final String message;

   ExceptionMessage(String message) {
      this.message = message;
   }

   public String message() {
      return message;
   }
}
