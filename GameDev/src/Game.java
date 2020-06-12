import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {
	// Canvas possui as propriedades que colocaremos no jogo, ex: tamanho da janela
	
	public static JFrame frame;
	private final int WIDTH = 160;
	private final int HEIGHT = 120;
	private final int SCALE = 3;
	// Final pois não haverá mudança no tamanho da janela
	private Thread thread;
	private boolean isRunning = false;
	private BufferedImage image;

	public Game() {
		this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		frame = new JFrame("GameDev");
		
		frame.add(this);									// Para pegar as propriedades adicionadas de altura e comprimento e escala
		
		frame.pack();										// Metodo para adicionar canvas e calcular certas dimensoes para mostrar
		
		frame.setResizable(false); 							// Para que usuário não possa redimensionar janela
		
		frame.setLocationRelativeTo(null);					// Janela para ficar no centro
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Clicar para fechar e fechar, pois pode clicar para fechar e deixar ainda rodando

		frame.setVisible(true);									// Inicializar e tornar visivel
		
		image = new BufferedImage(WIDTH, HEIGHT,BufferedImage.TYPE_INT_RGB);

	}
	
	
	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	};
	public synchronized void stop() {
		
	};
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		game.start();
	}
	
	public void realUpdate() {
		
	}
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = image.getGraphics();
		g.setColor(new Color(19,19,19));
		g.fillRect(WIDTH, HEIGHT, WIDTH, HEIGHT);
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);
		bs.show();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		long lastTime = System.nanoTime();
		double amountOfFrames = 60.0, delta = 0;
		double ns = 1000000000 / amountOfFrames;
		int frames = 0;
		double timer = System.currentTimeMillis();
		while(isRunning) {
	
			long now = System.nanoTime();
			delta += (now - lastTime)/ns; 
			lastTime = now;
			if(delta>=1) {
				realUpdate();
				render();
				frames++;
				delta--;
			}
			if(System.currentTimeMillis() - timer >=1000) {
				System.out.println("FPS:  "+ frames);
				frames = 0;
				timer+=1000;
			}
		}
	}

}
