package a7;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.text.DecimalFormat;

public class PixelInspectorWidget extends JPanel implements MouseListener {

	private FrameView frame_view;
	
	double x_val = 0;
	double y_val = 0;
	double red_val = 0;
	double green_val = 0;
	double blue_val = 0;
	double brightness_val = 0;
	
	JLabel labelX_value;
	JLabel labelY_value;
	JLabel labelRed_value;
	JLabel labelGreen_value;
	JLabel labelBlue_value;
	JLabel labelBrightness_value;
	
	public PixelInspectorWidget(Frame2D f, String title) {
		setLayout(new BorderLayout());
		
		frame_view = new FrameView(f.createObservable());
		frame_view.addMouseListener(this);
		add(frame_view, BorderLayout.CENTER);
		
//		JLabel title_label = new JLabel(title);
//		add(title_label, BorderLayout.SOUTH);
		
		JPanel sidePanel = new JPanel();
		sidePanel.setLayout(new GridLayout(6,2));
		
		//Has the beginning numbers being 0 for all labels
		labelX_value = new JLabel (Double.toString(x_val));
		labelY_value = new JLabel (Double.toString(y_val));
		labelRed_value = new JLabel (Double.toString(red_val));
		labelGreen_value = new JLabel (Double.toString(green_val));
		labelBlue_value = new JLabel (Double.toString(blue_val));
		labelBrightness_value = new JLabel (Double.toString(brightness_val));
		//
		
		//Makes the labels
		JLabel labelX = new JLabel("X: ");
		JLabel labelY = new JLabel("Y: ");
		JLabel labelRed = new JLabel("Red: ");
		JLabel labelGreen = new JLabel("Green: ");
		JLabel labelBlue = new JLabel("Blue: ");
		JLabel labelBrightness = new JLabel("Brightness: ");
		//
		
		//Adds the labels from left to right with 2 on each line
		sidePanel.add(labelX);
		sidePanel.add(labelX_value);
		
		sidePanel.add(labelY);
		sidePanel.add(labelY_value);
		
		sidePanel.add(labelRed);
		sidePanel.add(labelRed_value);
		
		sidePanel.add(labelGreen);
		sidePanel.add(labelGreen_value);		
		
		sidePanel.add(labelBlue);
		sidePanel.add(labelBlue_value);
		
		sidePanel.add(labelBrightness);
		sidePanel.add(labelBrightness_value);
		//
		
		//Sets the sidePanel to be on the left side of the main frame
		add(sidePanel, BorderLayout.WEST);
		//
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("You clicked on the frame at: " + e.getX() + "," + e.getY());
		DecimalFormat d = new DecimalFormat("###.##");

		//Sets values corresponding to where the user clicks on the picture
		x_val = e.getX();
		String x_valString = d.format(x_val);
		labelX_value.setText(x_valString);

		y_val = e.getX();
		String y_valString = d.format(y_val);
		labelY_value.setText(y_valString);

		blue_val = frame_view.getFrame().getPixel(e.getX(), e.getY()).getBlue();
		String blue_valString = d.format(blue_val);
		labelBlue_value.setText(blue_valString);

		red_val = frame_view.getFrame().getPixel(e.getX(), e.getY()).getRed();
		String red_valString = d.format(red_val);
		labelRed_value.setText(red_valString);

		green_val = frame_view.getFrame().getPixel(e.getX(), e.getY()).getGreen();
		String green_valString = d.format(green_val);
		labelGreen_value.setText(green_valString);

		brightness_val = frame_view.getFrame().getPixel(e.getX(), e.getY()).getIntensity();
		String brightness_valString = d.format(brightness_val);
		labelBrightness_value.setText(brightness_valString);
		//
		
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
