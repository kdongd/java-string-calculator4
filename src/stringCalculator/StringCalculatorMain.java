package stringCalculator;

public class StringCalculatorMain {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        InputProcessor inputProcessor = new InputProcessor();
        OutputProcessor outputProcessor = new OutputProcessor();
        FormulaSplitter formulaSplitter = new FormulaSplitter();

        String value = inputProcessor.input();
        String[] values = formulaSplitter.split(value);

        int result = stringCalculator.calculate(values);
        outputProcessor.output(result);
    }
}
