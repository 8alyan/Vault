package labreport;

import java.awt.*;
import java.awt.event.*;

class AEvent extends Frame implements ActionListener {
TextField textField;
     AEvent()
    {
        textField = new TextField();

        textField.setBounds(60, 50, 180, 25);
        Button button = new Button("click Here");
        button.setBounds(100, 120, 80, 30);

        button.addActionListener(this);

        add(textField);
        add(button);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
    {
        textField.setText("Button is Pressed ");
    }

    public static void main(String[] args)
    {
        AEvent s = new AEvent();
    }
}