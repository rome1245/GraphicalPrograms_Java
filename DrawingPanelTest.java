import java.awt.*;

public class DrawingPanelTest {
  
  public static void main(String[] args) {
    DrawingPanel panel = new DrawingPanel(300, 200);
    Graphics g = panel.getGraphics();
    g.drawString("This is the drawing panel",10,20);
    for (int i=0;i<50;i++) {
       drawFace(g,30+i,30);
       panel.sleep(30);
       clearFace(g,30+i,30);
    }
    for (int i=50;i>0;i--) {
       drawFace(g,30+i,30);
       panel.sleep(30);
       clearFace(g,30+i,30);
    }
    drawFace(g,30,30);
    wink(panel,g,30,30);
    drawFace(g,30,30);
  }
  
  public static void drawFace(Graphics g, int x, int y) {
    g.setColor(Color.red);
    g.fillOval(x,y,100,100);
    g.setColor(Color.black);
    g.drawOval(x,y,100,100);
    g.setColor(Color.yellow);
    g.fillOval(x+30,y+30,10,10);
    g.fillOval(x+60,y+30,10,10);
    for (int i=0;i<5;i++)
    g.drawArc(x+30,y+40-i,40,40,0,-180);
  }
  
  public static void clearFace(Graphics g, int x, int y) {
    g.setColor(Color.white);
    g.fillRect(x,y,101,101);
  }
  
  public static void wink(DrawingPanel panel, Graphics g, int x, int y) {
    g.setColor(Color.red);
    for (int i=1;i<=10;i++) {
      g.fillRect(x+30,y+30,10,i);
      panel.sleep(20);
    }
  }
  
}
