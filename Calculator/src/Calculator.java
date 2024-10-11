
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    // initializing operands ( num1, num2, result) to 0;
    double num1 = 0, num2 = 0, result = 0;
    char op;
    Font myFont = new Font("Arial",Font.BOLD,20);
    JFrame f;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton ba, bs, bm, bd, beq, bclr, bdec, bdel;
    JPanel p;
    
    Calculator() {

        f = new JFrame("Calculator");
        f.setSize(420, 550);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myFont); // Set custom font, size, and style
        textfield.setEditable(false);
        textfield.setFocusable(false);

        ba = new JButton("+");
        bs = new JButton("-");
        bm = new JButton("*");
        bd = new JButton("/");
        beq = new JButton("=");
        bclr = new JButton("clr");
        bdec = new JButton(".");
        bdel = new JButton("del");

        functionButtons[0] = ba;
        functionButtons[1] = bs;
        functionButtons[2] = bm;
        functionButtons[3] = bd;
        functionButtons[4] = beq;
        functionButtons[5] = bclr;
        functionButtons[6] = bdec;
        functionButtons[7] = bdel;


        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setFont(myFont); // Setting custom font for Functionalbuttons
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setFont(myFont); // Setting custom font for Numericalbuttons

        }

        bdel.setBounds(150,430,100,50);
        bclr.setBounds(250,430,100,50);


        p = new JPanel();
        p.setBounds(50, 100, 300, 300);
        p.setLayout(new GridLayout(4, 4, 10, 10));

        p.add(numberButtons[0]);
        p.add(numberButtons[1]);
        p.add(numberButtons[2]);
        p.add(numberButtons[3]);
        p.add(numberButtons[4]);
        p.add(numberButtons[5]);
        p.add(numberButtons[6]);
        p.add(numberButtons[7]);
        p.add(numberButtons[8]);
        p.add(numberButtons[9]);

        p.add(ba);
        p.add(bs);
        p.add(bm);
        p.add(bd);
        p.add(beq);
        p.add(bdec);
    

        f.add(p);
        f.add(bdel);
        f.add(bclr);
        f.add(textfield);
        f.setVisible(true);
    }

    public static void main(String[] args) {

        try {
            //system default look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // handling numbers
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        // handling decimal point
        if (e.getSource() == bdec) {
            textfield.setText(textfield.getText() + ".");
        }

        // handling arithemtic operations and 1st operand
        // add
        if (e.getSource() == ba) {
            num1 = Double.parseDouble(textfield.getText());
            op = '+';
            textfield.setText("");
        }
        // sub
        if (e.getSource() == bs) {
            num1 = Double.parseDouble(textfield.getText());
            op = '-';
            textfield.setText("");
        }
        // times
        if (e.getSource() == bm) {
            num1 = Double.parseDouble(textfield.getText());
            op = '*';
            textfield.setText("");
        } // divide
        if (e.getSource() == bd) {
            num1 = Double.parseDouble(textfield.getText());
            op = '/';
            textfield.setText("");
        }

        // handling equals and seocnd operand
        if (e.getSource() == beq) {
            num2 = Double.parseDouble(textfield.getText());

            // perfoming calcuation based on user input operands and operators;
            switch (op) {

                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        textfield.setText("Ma ERROR");
                        return;
                    }
                    break;
            }
            // set the double type result value into string type and
            // display on text field
            textfield.setText(String.valueOf(result)); 
           
            num1 = result;
        }

        // handling clear
        if (e.getSource() == bclr) {
            textfield.setText("");
        }

        // handling delete
        if(e.getSource()==bdel) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}

    }

}
