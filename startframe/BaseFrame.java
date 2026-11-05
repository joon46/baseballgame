package startframe;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BaseFrame extends Frame {

	public BaseFrame(String title) {
		// TODO Auto-generated constructor stub
		this.setTitle(title);
		this.setBounds(700, 100, 500, 800);
		this.setBackground(Color.gray);
		this.setLayout(null);
		this.setResizable(false);
	}

}
