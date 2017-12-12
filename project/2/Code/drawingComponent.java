import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Rectangle;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class drawingComponent extends JComponent {
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		// g2.drawString("Hello", 20, 40);
		// setBackground(Color.WHITE);
		// setColor(Color.RED);
		// g2.drawOval(100, 150, 10, 12);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		Rectangle rect1 = new Rectangle(5, 5, 100, 200);
		
		g2.draw(rect1);
		g2.drawRect(50, 50, 29, 33);
	}
	

}
