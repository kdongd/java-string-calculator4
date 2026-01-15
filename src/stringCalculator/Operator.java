package stringCalculator;

public enum Operator {
    PLUS("+") {
        @Override
        int operation(int a, int b) {
            return a + b;
        }
    },
    MINUS("-"){
        @Override
        int operation(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY("*"){
        @Override
        int operation(int a, int b) {
            return a * b;
        }
    },
    DIVIDE("/"){
        @Override
        int operation(int a, int b) {
            if (b == 0) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }
            return a / b;
        }
    };

    private final String message;

    Operator(String message) {
        this.message = message;
    }

    abstract int operation(int a, int b);

    public static Operator conversion(String message) { //입력받은 연산자로 enum 찾기
        for (Operator op : Operator.values()) {
            if (op.message.equals(message)) {
                return op;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산자: " + message);
    }
}
