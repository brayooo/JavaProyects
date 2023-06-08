package presenter;

import view.frame.MyFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presenter implements ActionListener {
    private MyFrame myFrame;

    public Presenter(){
        myFrame = new MyFrame(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = e.getActionCommand();
        switch (message){
            case "screen1":
            myFrame.changeToScreen1();
            break;
            case "screen2":
            myFrame.changeToScreen2();
            break;
        }
    }

    public static void main(String[] args) {
        new Presenter();
    }
}
