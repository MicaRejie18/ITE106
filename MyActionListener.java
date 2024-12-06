import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyActionListener implements ActionListener {
	public void actionPerformed (ActionEvent e) {
		Toolkit.getDefaultToolkit().beep();
	}
}
