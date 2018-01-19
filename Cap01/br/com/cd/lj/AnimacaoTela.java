package br.com.cd.lj;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AnimacaoTela extends JFrame{
	private JPanel tela;
	private int fps = 1000/20;	//50
	private int cont;	//contador
	private boolean anima = true;
	
	public void iniciaAnimacao() {
		long prxAtualizacao = 0;
		
		while(anima) {
			//System.currentTimeMillis() obtêm o tempo corrente em milésimos de segundo
			if(System.currentTimeMillis() >= prxAtualizacao) {
				cont++;
				tela.repaint();
				
				prxAtualizacao = System.currentTimeMillis() + fps;
				if(cont==100) {
					anima = false;
				}
			}
		}
	}
	
	public AnimacaoTela() {
		tela = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				//Limpa os desenhos anteriores
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, tela.getWidth(), tela.getHeight());
				
				g.setColor(Color.BLUE);
				g.drawLine(0, 240 + cont, 640, 240 + cont);
				g.drawRect(10, 25 + cont, 20, 20);
				g.drawOval(30 + cont, 20, 40, 30);
				
				g.setColor(Color.YELLOW);
				g.drawLine(320 - cont, 0, 320 - cont, 480);
				g.fillRect(110, 125, 120 - cont, 120 - cont);
				g.fillOval(230, 220, 240 + cont, 230);
				
				g.setColor(Color.RED);
				g.drawString("Score" + cont, 5, 10);
			}
		};
		
		getContentPane().add(tela);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 480);
		setVisible(true);
		tela.repaint();
	}
	
	public static void main(String[] args) {
		AnimacaoTela anima = new AnimacaoTela();
		anima.iniciaAnimacao();
	}

}
