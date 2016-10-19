import java.awt.*;

public class DrawCircles {
	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(300, 300);
		Graphics g = panel.getGraphics();

		g.setColor(Color.RED);
		for (int i = 0; i < 10; i++) {
			g.fillOval(0 + 30 * i, 270 - 30 * i, 30, 30);
		}
	}
}
