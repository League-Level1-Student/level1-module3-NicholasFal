package _03_jars._3_magic_box;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MagicBox extends JPanel implements Runnable, MouseListener {

	/*
	 * We are going to hide secrets within the magic box. 
	 * When the user clicks on a secret place, stuff will happen.
	 * 
	 * 1. Make the frame respond to mouse clicks.
	 * 
	 * 2. When the mouse is clicked, use the Media Palace (read the code in the magic_box package) to play sounds, 
	 *    show images or speak.
	 * 
	 * 3. Choose 3 different locations on the background image.You can either use the mouse position, 
	 *    or the color of the image, then decide what action the Media Palace should take in each case. 
	 *     backgroundImage.getRGB(e.getX(), e.getY()) will give you the color of the current pixel.
	 *     
	 *   
	 *     
	 */
	MediaPalace picture = new MediaPalace();
	BufferedImage backgroundImage;
	JFrame frame = new JFrame();
	JFrame frameTwo = new JFrame();
	JFrame frameThree = new JFrame();
	JLabel label;
	JLabel hoodie;
	JLabel behindTheDoors;
	JPanel panel = new JPanel();
	JPanel panelTwo = new JPanel();
	JPanel panelThree = new JPanel();
	int added = 0;
	int addedTwo = 0;

	@Override
	public void run() {
		try {
			loadBackgroundImage();
			createUI();
		} catch (Exception w) {
			System.err.println(w.getMessage());
		}
	}

	private void createUI() {
		JFrame frame = new JFrame("The Magic Box contains many secrets...");
		frame.add(this);
		setPreferredSize(new Dimension(backgroundImage.getWidth(), backgroundImage.getHeight()));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addMouseListener(this);
	}

	private void loadBackgroundImage() throws Exception {
		String imageFile = "src/_03_jars/_3_magic_box/magic-box.jpg";
		try {
			backgroundImage = ImageIO.read(new File(imageFile));
		} catch (IOException e) {
			throw new Exception("Could not load image: " + imageFile);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(backgroundImage, 0, 0, null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getX());
		System.out.println(e.getY());
		int mouseX = e.getX();
		int mouseY = e.getY();
		if(mouseX < 304 && mouseX > 273 && mouseY > 289 && mouseY < 411) {
			try {
				label = picture.loadImageFromTheInternet("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Salto_del_Angel-Canaima-Venezuela08.JPG/1200px-Salto_del_Angel-Canaima-Venezuela08.JPG");
			frame.add(panel);
			panel.add(label);
			frame.setVisible(true);
			frame.pack();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Worked");
		} else {
		if(mouseX < 210 && mouseX > 187 && mouseY > 540 && mouseY < 580) {
			System.out.println("worked again");
			try {
				hoodie = picture.loadImageFromTheInternet("https://i.pinimg.com/736x/2d/1c/c2/2d1cc2c80acb545d5b7995ae7ba4443f.jpg");
				frameTwo.add(panelTwo);
				if(added == 0) {
				panelTwo.add(hoodie);
				}
				frameTwo.setVisible(true);
				frameTwo.pack();
				added++;
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			if(mouseX > 307 && mouseX < 363 && mouseY > 617 && mouseY < 680) {
				System.out.println("yay");
				try {
					behindTheDoors = picture.loadImageFromTheInternet("https://www.pngitem.com/pimgs/m/65-653190_treasure-chest-png-transparent-treasure-chest-clipart-png.png");
				frameThree.add(panelThree);
				if(addedTwo == 0) {
					panelThree.add(behindTheDoors);
				}
				frameThree.setVisible(true);
				frameThree.pack();
				addedTwo++;
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}


