import javax.print.DocFlavor.INPUT_STREAM;
import javax.print.attribute.standard.NumberOfInterveningJobs;
import javax.security.auth.kerberos.KeyTab;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.w3c.dom.Text;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.function.DoubleUnaryOperator;

public class calculator extends JFrame implements ActionListener {

    JFrame frame;
    JButton[] numbers = new JButton[10]; // NUMBERS BUTTON ARRAY
    JButton[] functionbuttons = new JButton[8]; // FUNCTIONAL BUTTONS ARRAY
    JButton del, clr, dec, equ, add, sub, mul, div; 
    JTextField textfield;
    JPanel panel;
    
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Font font = new Font("MV Boli", Font.PLAIN, 25);

    calculator() {

        // FRAME
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0x3F3F3F));
        this.setSize(300, 500);
        this.setLayout(null);

        // ------------- TEXTFIELD ----------------------
        textfield = new JTextField();
        textfield.setBounds(10, 20, 265, 50);
        textfield.setFont(font);
        textfield.setEditable(false);
        textfield.setBorder(BorderFactory.createEtchedBorder());
        this.add(textfield);

        // ----------- FUNCTION BUTTONS ---------------
        

        // ADDED IN THE FRAME
        del = new JButton("Del");
        del.setBounds(10, 390, 130, 50);
        del.setFocusable(false);
        del.setMnemonic(KeyEvent.VK_BACK_SPACE);
        del.setFont(font);
        this.add(del);

        // ADDED IN THE FRAME
        clr = new JButton("Clear");
        clr.setBounds(143, 390, 130, 50);
        clr.setMnemonic(KeyEvent.VK_C);
        clr.setFocusable(false);
        clr.setFont(font);
        this.add(clr);

        // ADDED IN THE PANEL
        equ = new JButton("=");
        dec = new JButton(".");
        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("x");
        div = new JButton("%");

        // INSERTING ITEMS/BUTTONS INSIDE THE ARRAY
        functionbuttons[0] = add;
        functionbuttons[1] = sub;
        functionbuttons[2] = mul;
        functionbuttons[3] = div;
        functionbuttons[4] = del;
        functionbuttons[5] = clr;
        functionbuttons[6] = dec;
        functionbuttons[7] = equ;

        for(int i = 0; i < 8; i++) {
            functionbuttons[i].addActionListener(this);
            functionbuttons[i].setFocusable(false);
            functionbuttons[i].setFont(font);
        }

        // NUMBERS BUTTONS
        for(int i = 0; i < 10; i++) {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFocusable(false);
            numbers[i].setFont(font);
        }


        // ---------- PANEL -------------
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));
        panel.setBackground(new Color(0x3F3F3F));
        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(functionbuttons[0]);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(functionbuttons[1]);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(functionbuttons[2]);
        panel.add(functionbuttons[6]);
        panel.add(numbers[0]);
        panel.add(functionbuttons[7]);
        panel.add(functionbuttons[3]);

        panel.setBounds(10, 80, 265, 300);
        this.add(panel);

        // ------------------ FRAME -----------------
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
      for(int i = 0; i < numbers.length; i++) { // NUMBERS BUTTON BACKEND
          if(e.getSource() == numbers[i]) {
              textfield.setText(textfield.getText().concat(String.valueOf(i)));
          }
      }

      // -------------------------FUNCTION BUTTON BACKEND -------------------------

      if(e.getSource() == dec) {  // DECIMAL
          textfield.setText(textfield.getText().concat(String.valueOf(".")));
      }
      
      if(e.getSource() == add) { // ADDITION
          num1 = Double.parseDouble(textfield.getText());
          operator = '+';
          textfield.setText("");
      }

      if(e.getSource() == sub) { // SUBTRACTION
          num1 = Double.parseDouble(textfield.getText());
          operator = '-';
          textfield.setText("");
      }

      if(e.getSource() == mul) { // MULTPLICATION
          num1 = Double.parseDouble(textfield.getText());
          operator = '*';
          textfield.setText("");
      }

      if(e.getSource() == div) { // DIVISION
          num1 = Double.parseDouble(textfield.getText());
          operator = '/';
          textfield.setText("");
      }
      if(e.getSource() == equ) { // EQUALS
          num2 = Double.parseDouble(textfield.getText());

          switch(operator) {

            case '+':
                result=num1+num2;
                break;
            case '-':
                result=num1-num2;
                break;
            case '*':
                result=num1*num2;
                break;
            case '/':
                result=num1/num2;
                break;
          }
          textfield.setText(String.valueOf(result));
          num1=result;

      }

      if(e.getSource() == clr) {
            textfield.setText("");
        }
    
      if(e.getSource() == del) {
          String string = textfield.getText();
          textfield.setText("");
          for(int i = 0; i < string.length()-1;i++) {
              textfield.setText(textfield.getText()+string.charAt(i));
          }

      }

        
    }

}
