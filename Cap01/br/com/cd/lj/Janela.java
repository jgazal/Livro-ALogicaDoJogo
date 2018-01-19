package br.com.cd.lj;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Janela extends JFrame{
	
	private JPanel tela;
	
	public Janela() {
		tela = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				//Pintura da tela
			}
		};
		super.getContentPane().add(tela);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 480);
		setVisible(true);	
	}
	
	public static void main(String[] args) {
		new Janela();
	}
}


