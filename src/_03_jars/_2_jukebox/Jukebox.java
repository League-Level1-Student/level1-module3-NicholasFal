package _03_jars._2_jukebox;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javazoom.jl.player.advanced.AdvancedPlayer;

/*   If you don't have javazoom.jar in your project, you can download it from here: http://bit.ly/javazoom
 *   Right click your project and add it as a JAR (Under Java Build Path > Libraries).*/

public class Jukebox implements Runnable, ActionListener {
	Song songPlaying;

    public void run() {

		// 1. Find an mp3 on your computer or on the Internet.
		// 2. Create a Song object for that mp3
    	Song thriller = new Song("Thriller");
    	Song imagine = new Song("Imagine");
    	Song bohemianRhapsody = new Song("Bohemian Rhapsody");
    	Song despacito = new Song("Despacito");
    	Song thinkingOutLoud = new Song("Thinking Out Loud");
    	Song hereComesTheSun = new Song("Here Comes The Sun");
    	Song whenDovesCry = new Song("When Doves Cry");
    	Song sorry = new Song("Sorry");
    	Song uptownFunk = new Song("Uptown Funk");
    	Song holiday = new Song("Holiday");
    	
		// 3. Play the Song

		/*
		 * 4. Create a user interface for your Jukebox so that the user can to
		 * choose which song to play. You can use can use a different button for
		 * each song, or a picture of the album cover. When the button or album
		 * cover is clicked, stop the currently playing song, and play the one
		 * that was selected.
		 */
    	JFrame frame = new JFrame();
    	JPanel panel = new JPanel();
    	frame.add(panel);
    	JButton thrillerButton = new JButton();
    	panel.add(thrillerButton);
    	thrillerButton.setText("Thriller");
    	thrillerButton.addActionListener(this);
    	JButton imagineButton = new JButton();
    	panel.add(imagineButton);
    	imagineButton.setText("Imagine");
    	imagineButton.addActionListener(this);
    	JButton bohemianRhapsodyButton = new JButton();
    	panel.add(bohemianRhapsodyButton);
    	bohemianRhapsodyButton.setText("Bohemian Rhapsody");
    	bohemianRhapsodyButton.addActionListener(this);
    	JButton despacitoButton = new JButton();
    	panel.add(despacitoButton);
    	despacitoButton.setText("Despacito");
    	despacitoButton.addActionListener(this);
    	JButton thinkingOutLoudButton = new JButton();
    	panel.add(thinkingOutLoudButton);
    	thinkingOutLoudButton.setText("Thinking Out Loud");
    	thinkingOutLoudButton.addActionListener(this);
    	JButton hereComesTheSunButton = new JButton();
    	panel.add(hereComesTheSunButton);
    	hereComesTheSunButton.setText("Here Comes The Sun");
    	hereComesTheSunButton.addActionListener(this);
    	JButton whenDovesCryButton = new JButton();
    	panel.add(whenDovesCryButton);
    	whenDovesCryButton.setText("When Doves Cry");
    	whenDovesCryButton.addActionListener(this);
    	JButton sorryButton = new JButton();
    	panel.add(sorryButton);
    	sorryButton.setText("Sorry");
    	sorryButton.addActionListener(this);
    	JButton uptownFunkButton = new JButton();
    	panel.add(uptownFunkButton);
    	uptownFunkButton.setText("Uptown Funk");
    	uptownFunkButton.addActionListener(this);
    	JButton holidayButton = new JButton();
    	panel.add(holidayButton);
    	holidayButton.setText("Holiday");
    	holidayButton.addActionListener(this);
    	frame.pack();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
    }
    
    
	/* Use this method to add album covers to your Panel. */
	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		JButton clicked = (JButton) event.getSource();
		if(songPlaying != null) {
			songPlaying.stop();
		}
		songPlaying = new Song(clicked.getText());
		
		songPlaying.play();
	}

}

class Song {

	private int duration;
	private String songAddress;
	private AdvancedPlayer mp3Player;
	private InputStream songStream;

	/**
	 * Songs can be constructed from files on your computer or Internet
	 * addresses.
	 * 
	 * Examples: <code> 
	 * 		new Song("everywhere.mp3"); 	//from default package 
	 * 		new Song("/Users/joonspoon/music/Vampire Weekend - Modern Vampires of the City/03 Step.mp3"); 
	 * 		new	Song("http://freedownloads.last.fm/download/569264057/Get%2BGot.mp3"); 
	 * </code>
	 */
	public Song(String songAddress) {
		this.songAddress = songAddress;
	}

	public void play() {
//		loadFile();
//		if (songStream != null) {
//			loadPlayer();
//			startSong();
//		} else
//			System.err.println("Unable to load file: " + songAddress);
		JOptionPane.showMessageDialog(null, songAddress);
	}

	public void setDuration(int seconds) {
		this.duration = seconds * 100;
	}

	public void stop() {
		if (mp3Player != null)
			mp3Player.close();
	}

	private void startSong() {
		Thread t = new Thread() {
			public void run() {
				try {
					if (duration > 0)
						mp3Player.play(duration);
					else
						mp3Player.play();
				} catch (Exception e) {
				}
			}
		};
		t.start();
	}

	private void loadPlayer() {
		try {
			this.mp3Player = new AdvancedPlayer(songStream);
		} catch (Exception e) {
		}
	}

	private void loadFile() {
		if (songAddress.contains("http"))
			this.songStream = loadStreamFromInternet();
		else
			this.songStream = loadStreamFromComputer();
	}

	private InputStream loadStreamFromInternet() {
		try {
			return new URL(songAddress).openStream();
		} catch (Exception e) {
			return null;
		}
	}

	private InputStream loadStreamFromComputer() {
		try {
			return new FileInputStream(songAddress);
		} catch (FileNotFoundException e) {
			return this.getClass().getResourceAsStream(songAddress);
		}
	}
}

