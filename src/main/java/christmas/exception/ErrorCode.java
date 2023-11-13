package christmas.exception;

public enum ErrorCode {
    INPUT_TYPE_ERROR("[ERROR] 숫자로 입력해 주세요."),
    DAY_INPUT_ERROR("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),

    MENU_INPUT_ERROR("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String message;

    private ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

