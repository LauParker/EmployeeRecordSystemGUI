package com.lau.employee.gui;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.lau.employee.sys.Controller;

public class PanelImageEmployee extends JPanel {
	private BufferedImage picture;
	private String imageLocation;
	public PanelImageEmployee(String fileLocation) {
		imageLocation = fileLocation;
		try {
			picture = ImageIO.read(new File(fileLocation));
		} catch (IOException e) {
			System.out.println("Unable to read picture");
		}
	}
	
	/**
	 * THIS IS FOR RESIZING AND SAVING A PIC TO A FILE, 
	 * TODO : MAKE IT SO THAT PIC ARE SAVED AS X300 Y300
	 * 
	 * BufferedImage tThumbImage = new BufferedImage( tThumbWidth, tThumbHeight, BufferedImage.TYPE_INT_RGB );
  Graphics2D tGraphics2D = tThumbImage.createGraphics(); //create a graphics object to paint to
  tGraphics2D.setBackground( Color.WHITE );
  tGraphics2D.setPaint( Color.WHITE );
  tGraphics2D.fillRect( 0, 0, tThumbWidth, tThumbHeight );
  tGraphics2D.setRenderingHint( RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR );
  tGraphics2D.drawImage( tOriginalImage, 0, 0, tThumbWidth, tThumbHeight, null ); //draw the image scaled

  ImageIO.write( tThumbImage, "JPG", tThumbnailTarget ); //write the image to a file
	 */
	public void paintComponent(Graphics pic) {
		Graphics2D pic2 = (Graphics2D)pic;
		pic2.drawImage(picture, null, 00, 00);
	}
	
	public String getEmployeeImage() {
		return imageLocation;
	}
}