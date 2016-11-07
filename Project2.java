import java.awt.*;

public class Project2 {
	// Class Constant variable
	public static final int PATROL_Y = 250;
	public static final int PATROL_SIZE = 20;
	public static final int ENEMY_Y = 20;
	public static final int ENEMY_SIZE = 30;
	public static final int RIGHT_ARROW = 39;
	public static final int LEFT_ARROW = 37;
	public static final int UP_ARROW = 38;
	public static final int PATROL_MISSILE_LENGTH = 10;

	// non-Constant class variable
	public static int patrolX = 270;
	public static int enemyX = 0;
	public static int patrolMissileX;
	public static int patrolMissileY = 0;

	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(300, 300);
		Graphics g = panel.getGraphics( );
		g.drawString("Project 2 by Stephen A. Apolinar", 10, 15);
		startGame(panel, g);
	}
    
	public static void startGame(DrawingPanel panel, Graphics g) {
		//int x = 0;
		//int y = 270;
		//int deltaX = 1;
		//int deltaY = -3;
		// calls drawPatrol submethod, sends in variables for color 
		// via parameter.
		drawPatrol(g, Color.GREEN);
		for (int time = 0; time <= 1000; time++) {
			moveEnemyShipAndDraw(g);
			handleKeys(panel, g);
			movePatrolMissileAndDraw(panel, g);
			panel.sleep(50);
		//g.setColor(Color.WHITE); 
		//g.fillOval(x, y, 30, 30);
		//g.setColor(Color.RED); 
		//x = x + deltaX;
		//y = y + deltaY;
		//g.fillOval(x, y, 30, 30);
		}
	}
	
	// submethod calls Patrol vehicle
	public static void drawPatrol(Graphics g, Color c) {
		// In order to call variables within a submethod, even with parameters,
		//  they must be initialized within the submethod.
		//  Because they are executed within the scope of that submethod.
		//  And they exist only within this submethod.
		//int x = patrolX;
		int y = PATROL_Y;
		int side = PATROL_SIZE;
		// calls method to set color, and sends in parameter.
		g.setColor(c);
		// calls method to fill square, uses variables within
		//  the scope of submethod.
		g.fillRect(patrolX, y, side, side);
	}

	// submethod calls Enemy ship
	public static void moveEnemyShipAndDraw(Graphics g) {
		//int x = enemyX;
		int y = ENEMY_Y;
		int side = ENEMY_SIZE;
		int deltaX = 1;
		
		g.setColor(Color.WHITE);
		g.fillRect(enemyX, y, side, side);
		enemyX = enemyX + deltaX;
		g.setColor(Color.RED);
		g.fillRect(enemyX, y, side, side);
	}


	public static void handleKeys(DrawingPanel panel, Graphics g) {
		int deltaX = 3;
		if (panel.getKeyCode() == RIGHT_ARROW) {
			g.setColor(Color.WHITE);
			g.fillRect(patrolX, PATROL_Y, PATROL_SIZE, PATROL_SIZE);
			patrolX = patrolX + deltaX;
			g.setColor(Color.GREEN);
			g.fillRect(patrolX, PATROL_Y, PATROL_SIZE, PATROL_SIZE);
			if (patrolX >= 280) {
				g.setColor(Color.WHITE);
				g.fillRect(patrolX, PATROL_Y, PATROL_SIZE, PATROL_SIZE);
				patrolX = 277;
				g.setColor(Color.GREEN);
				g.fillRect(patrolX, PATROL_Y, PATROL_SIZE, PATROL_SIZE);
			}
		} 
		if (panel.getKeyCode() == LEFT_ARROW) {
			g.setColor(Color.WHITE);
			g.fillRect(patrolX, PATROL_Y, PATROL_SIZE, PATROL_SIZE);
			patrolX = patrolX - deltaX;
			g.setColor(Color.GREEN);
			g.fillRect(patrolX, PATROL_Y, PATROL_SIZE, PATROL_SIZE);
			if (patrolX <= 0) {
				g.setColor(Color.WHITE);
				g.fillRect(patrolX, PATROL_Y, PATROL_SIZE, PATROL_SIZE);
				patrolX = 3;
				g.setColor(Color.GREEN);
				g.fillRect(patrolX, PATROL_Y, PATROL_SIZE, PATROL_SIZE);
			}
		//movePatrolMissileAndDraw(panel, g);
		}
	}


	public static void movePatrolMissileAndDraw(DrawingPanel panel, Graphics g) {
		//int deltaY = 5;
		//patrolMissileX = patrolX;
		if (panel.getKeyCode() == UP_ARROW) {
			patrolMissileX = patrolX;
			patrolMissileY = 239;
			g.setColor(Color.WHITE);
			g.fillRect(patrolMissileX, patrolMissileY, 5, PATROL_MISSILE_LENGTH);
			patrolMissileY = patrolMissileY - 5;
			g.setColor(Color.BLACK);
			g.drawRect(patrolMissileX, patrolMissileY, 5, PATROL_MISSILE_LENGTH);
		}
	}	
}
