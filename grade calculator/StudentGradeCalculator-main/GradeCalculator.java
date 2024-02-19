import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeCalculator {

    private JFrame frame;
    private JPanel panel;
    private JLabel label1, label2, label3, label4,label5, label6,resultLabelGrade,resultLabelTotal,resultLabelpercentage;
    private JTextField scoreField1, scoreField2, scoreField3, scoreField4, scoreField5, scoreField6;
    private JButton calculateButton;

    public GradeCalculator() {
        frame = new JFrame("Grade Calculator");
        panel = new JPanel();
        label1 = new JLabel("Score 1:");
        label2 = new JLabel("Score 2:");
        label3 = new JLabel("Score 3:");
        label4 = new JLabel("Score 4:");
        label5 = new JLabel("Score 5:");
        label6 = new JLabel("Score 6:");
        resultLabelTotal = new JLabel("");
        resultLabelpercentage = new JLabel("");
        resultLabelGrade = new JLabel("");

        scoreField1 = new JTextField(5);
        scoreField2 = new JTextField(5);
        scoreField3 = new JTextField(5);
        scoreField4 = new JTextField(5);
        scoreField5 = new JTextField(5);
        scoreField6 = new JTextField(5);

        calculateButton = new JButton("Calculate");

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateGrade();
            }
        });

        panel.add(label1);
        panel.add(scoreField1);
        panel.add(label2);
        panel.add(scoreField2);
        panel.add(label3);
        panel.add(scoreField3);
        panel.add(label4);
        panel.add(scoreField4);
        panel.add(label5);
        panel.add(scoreField5);
        panel.add(label6);
        panel.add(scoreField6);
        panel.add(calculateButton);
        panel.add(resultLabelTotal);
        panel.add(resultLabelpercentage);
        panel.add(resultLabelGrade);

        frame.add(panel);
        frame.setSize(175, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void calculateGrade() {
        try {
            double score1 = Double.parseDouble(scoreField1.getText());
            double score2 = Double.parseDouble(scoreField2.getText());
            double score3 = Double.parseDouble(scoreField3.getText());
            double score4 = Double.parseDouble(scoreField4.getText());
            double score5 = Double.parseDouble(scoreField3.getText());
            double score6 = Double.parseDouble(scoreField4.getText());
            double total=score1+score2+score3+score4+score5+score6;
            double average = ((total)/6);

            String grade = "";

            if (average >= 90) {
                grade = "A";
            } else if (average >= 80) {
                grade = "B";
            } else if (average >= 70) {
                grade = "C";
            } else if (average >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }

            resultLabelTotal.setText("Total Marks : " + total);
            resultLabelpercentage.setText("Average Percentage: " + average);
            resultLabelGrade.setText("Average Grade: " + grade);
        } catch (NumberFormatException e) {
            resultLabelGrade.setText("Invalid input. Please enter numeric values.");
        }
    }

    public static void main(String[] args) {
        new GradeCalculator();
    }
}
