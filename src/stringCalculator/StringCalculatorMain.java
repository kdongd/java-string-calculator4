package stringCalculator;

public class StringCalculatorMain {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        InputProcessor inputProcessor = new InputProcessor();
        OutputProcessor outputProcessor = new OutputProcessor();
        FormulaSplitter formulaSplitter = new FormulaSplitter();

        String formula = inputProcessor.input();
        String[] tokens = formulaSplitter.split(formula);

        int result = stringCalculator.calculate(tokens);
        outputProcessor.output(result);
    }
}
