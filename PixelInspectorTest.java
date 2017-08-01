package a7;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class PixelInspectorTest {
	
	public static void main(String[] args) throws IOException {
		Frame2D f = A7Helper.readFromURL("http://www.cs.unc.edu/~kmp/kmp.jpg");
		PixelInspectorWidget simple_widget = new PixelInspectorWidget(f, "K to the M to the P");
	
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Assignment 7 Pixel Inspector");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		JPanel top_panel = new JPanel();
		top_panel.setLayout(new BorderLayout());
		top_panel.add(simple_widget, BorderLayout.CENTER);
		main_frame.setContentPane(top_panel);		
		
		main_frame.pack();
		main_frame.setVisible(true);
	
	}
}
