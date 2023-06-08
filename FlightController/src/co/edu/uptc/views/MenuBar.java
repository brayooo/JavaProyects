package co.edu.uptc.views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar implements ActionListener {

	private JMenu menu;
	private JMenuItem stop;
	private JMenuItem resume;
	private JMenuItem end;
	private Board board;

	public MenuBar(Board board,int width) {
		this.board = board;
		this.setSize(width, this.getHeight());
		initComponents();
	}
	
	private void initComponents() {
		menu = new JMenu("MENU");
		stop = new JMenuItem("Pause");
		stop.addActionListener(e -> board.getPresenter().notifyPaused());
		resume = new JMenuItem("Resume");
		resume.addActionListener(e -> board.getPresenter().notifyResume());
		end = new JMenuItem("End");
		end.addActionListener(e ->{
			//board.endPaint();
			board.getPresenter().endGame();
		});
		menu.add(resume);
		menu.add(stop);
		menu.add(end);
		this.add(menu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
