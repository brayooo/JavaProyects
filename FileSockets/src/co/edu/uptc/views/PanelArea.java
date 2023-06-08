package co.edu.uptc.views;


import javax.swing.*;
import java.io.File;

public class PanelArea extends JPanel {

    private Board board;
    private JButton jButton;
    private JFileChooser fileChooser;
    private File file;

    public PanelArea(Board board) {
        super();
        this.board = board;
        setSize(700, 700);
        initComponents();
    }
    private void initComponents(){
        jButton = new JButton("Select file");
        fileChooser = new JFileChooser();
        jButton.addActionListener(e -> {
            fileChooser.showOpenDialog(this);
            file = fileChooser.getSelectedFile().getAbsoluteFile();
            board.getPresenter().setFile(file);
        });
        add(jButton);
    }

}
