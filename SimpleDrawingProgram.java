import java.awt.*;

public class SimpleDrawingProgram {
	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(300, 200);
		Graphics g = panel.getGraphics();
		g.drawRect(160, 30, 90, 65);
		g.fillOval(80,130, 90, 70);
	}
}
