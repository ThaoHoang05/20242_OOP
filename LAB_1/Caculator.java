import javax.swing.JOptionPane;

public class Caculator {
    public static void main(String[] args) {
        String strnum1, strnum2;
        strnum1 = JOptionPane.showInputDialog(null,"Enter num1:");
        strnum2 = JOptionPane.showInputDialog(null,"Enter num2:");
        double num1 = Double.parseDouble(strnum1);
        double num2 = Double.parseDouble(strnum2);
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient = 0.0;
        if(num2 == 0) {
            JOptionPane.showMessageDialog(null,"Can't divide by zero");
        } else {
            quotient = num1 / num2;
        }
        String notification = "Sum: " + sum + "\nDifference: " + difference + "\nProduct: " + product + "\nQuotient: " + quotient;
        JOptionPane.showMessageDialog(null, notification);
    }
}
