package view.screen1;

import javax.swing.*;
import java.awt.*;

public class BoundButton extends JButton {

    public BoundButton(String txt, Color color){
        super(txt);
        setForeground(Color.white);
        setBorderPainted(false);
        setBackground(new Color(29,39,50));
        setUI(new ShapedButtonUI(color));
    }
}
