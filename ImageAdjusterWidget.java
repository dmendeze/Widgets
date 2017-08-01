package a7;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTable;

public class ImageAdjusterWidget extends JPanel implements MouseListener {

	private FrameView frame_view;
	private int brightnessSlider_value;
	private int saturationSlider_value;
	
	JSlider saturationSlider;
	JSlider brightnessSlider;
	
	public ImageAdjusterWidget(Frame2D f, String title) throws IOException {
		setLayout(new BorderLayout());
		
		f = A7Helper.readFromURL("http://www.cs.unc.edu/~kmp/kmp.jpg");
		
		frame_view = new FrameView(f.createObservable());
		frame_view.addMouseListener(this);
		add(frame_view, BorderLayout.CENTER);
		
//		JLabel title_label = new JLabel(title);
//		add(title_label, BorderLayout.SOUTH);
		
		//Sets the panel layout, here it is a grid
		JPanel lowerPanel = new JPanel();
		lowerPanel.setLayout(new GridLayout(2,2));
		//
		
		//Makes labels
		JLabel brightnessLabel = new JLabel("Brightness:");
		JLabel saturationLabel = new JLabel("Saturation:");
		//
		
		//Makes sliders
		brightnessSlider = new JSlider(-100,100,0);
		saturationSlider = new JSlider(-100,100,0);
		//
		
		//Sets the spaces between tick marks and sets them true
		brightnessSlider.setMajorTickSpacing(25);
		brightnessSlider.setPaintTicks(true);
		brightnessSlider.setPaintLabels(true);

		saturationSlider.setMajorTickSpacing(25);
		saturationSlider.setPaintTicks(true);
		saturationSlider.setPaintLabels(true);
		//
		
		//Adds the label and the slider
		lowerPanel.add(brightnessLabel);
		lowerPanel.add(brightnessSlider);
		
		lowerPanel.add(saturationLabel);
		lowerPanel.add(saturationSlider);
		//
		
		//Supposed to determine how much to brighten/saturate the image
		double brightnessSlider_value = brightnessSlider.getValue()/100.0;
		double saturationSlider_value = brightnessSlider.getValue()/100.0;
		//
		
		//Sets the lowerPanel below the main frame
		add(lowerPanel, BorderLayout.SOUTH);
		//
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		double red, blue, green, changedRed, changedBlue, changedGreen;
		
		ObservableFrame2D is2D = new ObservableFrame2DImpl(frame_view.getWidth(), frame_view.getHeight());
		
		//Goes through the image pixel by pixel
		if(brightnessSlider_value < 0) {
			for (int x=0; x < getWidth(); x++) {
				for (int y=0; y<frame_view.getHeight(); y++) {
					Pixel pixels = e.getPixel(x,y);
					//
					
					//Setting these colors into variables to be used next
					red = pixels.getRed();
					blue = pixels.getRed();
					green = pixels.getRed();
					//
					
					//Determines what the colors "level" will now be when the slider is moved
					changedRed = red + (1-red) * brightnessSlider_value;
					changedBlue = blue + (1-blue) * brightnessSlider_value;
					changedGreen = green + (1-green) * brightnessSlider_value;
					//
					
					//Sets what the boundaries will look like when the slider is moved
					//to the lowest, highest, and center (zero) values
					if(brightnessSlider_value == 0) {
						is2D.setPixel(x,y,new ColorPixel(red,green,blue));
					}
					else if(brightnessSlider_value == -100) {
						is2D.setPixel(x,y,new ColorPixel(0,0,0));
					}
					else if(brightnessSlider_value == 100) {
						is2D.setPixel(x,y,new ColorPixel(1,1,1));
					}
					else {
						is2D.setPixel(x, y,new ColorPixel(changedRed,changedBlue,changedGreen));
					}
					//
					
				}
			}
		}
	
		//Goes through the image pixel by pixel
		if(brightnessSlider_value > 0) {
			for (int x=0; x < getWidth(); x++) {
				for (int y=0; y<frame_view.getHeight(); y++) {
					Pixel pixels = e.getPixel(x,y);
					//
					
					//Setting these colors into variables to be used next
					red = pixels.getRed();
					blue = pixels.getRed();
					green = pixels.getRed();
					//
					
					//Determines what the colors "level" will now be when the slider is moved
					changedRed = red + (1-red) * brightnessSlider_value;
					changedBlue = blue + (1-blue) * brightnessSlider_value;
					changedGreen = green + (1-green) * brightnessSlider_value;
					//
					
					//Sets what the boundaries will look like when the slider is moved
					//to the lowest, highest, and center (zero) values
					if(brightnessSlider_value == 0) {
						is2D.setPixel(x,y,new ColorPixel(red,green,blue));
					}
					else if(brightnessSlider_value == -100) {
						is2D.setPixel(x,y,new ColorPixel(0,0,0));
					}
					else if(brightnessSlider_value == 100) {
						is2D.setPixel(x,y,new ColorPixel(1,1,1));
					}
					else {
						is2D.setPixel(x, y,new ColorPixel(changedRed,changedBlue,changedGreen));
					}
					//
					
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

