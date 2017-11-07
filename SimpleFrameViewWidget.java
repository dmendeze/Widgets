package a7;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SimpleFrameViewWidget extends JPanel implements MouseListener {

	private FrameView frame_view;
	
	public SimpleFrameViewWidget(Frame2D f, String title) {
		setLayout(new BorderLayout());
		
		frame_view = new FrameView(f.createObservable());
		frame_view.addMouseListener(this);
		add(frame_view, BorderLayout.CENTER);
		
		JLabel title_label = new JLabel(title);
		add(title_label, BorderLayout.SOUTH);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("You clicked on the frame at: " + e.getX() + "," + e.getY());
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
