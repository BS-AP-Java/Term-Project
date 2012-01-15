package app;

import javax.swing.JOptionPane;
/**
 *
 * @author Nanyou
 */
public class GuiLearning {

    public static void main(String[] args) {

        //create the first input dialog for the person to enter information in
        String fn = JOptionPane.showInputDialog("Enter the first number");
        //create the second input dialog for the person to enter information in
        String sn = JOptionPane.showInputDialog("Enter the second number");
        //convert the string in fn into a number
        int num1 = Integer.parseInt(fn);
        //convert the string in sn into a number
        int num2 = Integer.parseInt(sn);
        //create an integer to hold the sum of the first and second numbers
        int sum = num1 + num2;
        //create a message dialog that displays specified message
        //it uses 4 parameters: position(null = center of screen), message to display, title of message, icon of message that pops up(ex:error, notice, warning)
        JOptionPane.showMessageDialog(null, "The answer is: " +sum, "Title", JOptionPane.PLAIN_MESSAGE);
    }

}
