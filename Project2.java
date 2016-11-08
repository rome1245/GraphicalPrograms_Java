/* Created by: Stephen A. Apolinar
   Date: 11/06/2016 */
// import the Abstract Window Toolkit package. */
import java.awt.*;
/* The beginning of every java program includes a class. */
public class Project2 {
	// Class Constant variables
	public static final int PATROL_Y = 250;
	public static final int PATROL_SIZE = 20;
	public static final int ENEMY_Y = 20;
	public static final int ENEMY_SIZE = 30;
	public static final int RIGHT_ARROW = 39;
	public static final int LEFT_ARROW = 37;
	public static final int UP_ARROW = 38;
	public static final int PATROL_MISSILE_LENGTH = 10;

	// non-Constant class variables
	public static int patrolX = 270;
	public static int enemyX = 0;
	public static int patrolMissileX;
	public static int patrolMissileY = 0;

	// boolean class variables
	public static boolean hit = false;
	
	// Main method
	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(300, 300);
		Graphics g = panel.getGraphics( );
		g.drawString("Project 2 by Stephen A. Apolinar", 10, 15);
		startGame(panel, g);
	}

	// submethod calls startGame, which makes calls to other
	// submethods within the program.
	public static void startGame(DrawingPanel panel, Graphics g) {
		drawPatrol(g, Color.GREEN);
		for (int time = 0; time <= 1000; time++) {
			moveEnemyShipAndDraw(g);
			handleKeys(panel, g);
			movePatrolMissileAndDraw(g);
			// changes boolean class variable value,
			// causing Enemy vehicle method to execute
			// else if code.
			if (detectHit() == true) {
				hit = true;
			}
			panel.sleep(50);	
		}
	}

	// submethod calls Patrol vehicle
	public static void drawPatrol(Graphics g, Color c) {
		// All variables for method are in Class Constant & 
		// (non Constant) class variables.
		// calls method to set color, and sends in parameter.
		g.setColor(c);
		// calls method to fill square, uses variables within
		//  the scope of submethod.
		g.fillRect(patrolX, PATROL_Y, PATROL_SIZE, PATROL_SIZE);
	}

	// submethod calls Enemy ship
	public static void moveEnemyShipAndDraw(Graphics g) {
		// variable for pixel shit of Enemy vehicle.	
		int deltaX = 1;
		// code sequence for moving Enemy vehicle must be 
		// performed within If statement, inorder to 
		// execute the stop sequence in Else If statement.
		if (hit == false) {
		g.setColor(Color.WHITE);
		g.fillRect(enemyX, ENEMY_Y, ENEMY_SIZE, ENEMY_SIZE);
		enemyX = enemyX + deltaX;
		g.setColor(Color.RED);
		g.fillRect(enemyX, ENEMY_Y, ENEMY_SIZE, ENEMY_SIZE);
		} else if (hit == true) {
			// else if statement executes vehicle stop,
			// changes vehicle to black, and prints.
			g.setColor(Color.BLACK);
			g.fillRect(enemyX, ENEMY_Y, ENEMY_SIZE, ENEMY_SIZE);
			g.setColor(Color.GREEN);
			g.drawString("Enemy ship hit!", 5, 295);
		}
		// prints statement if vehicle travels off screen.
		if (enemyX >= 300) {
			g.setColor(Color.RED);
			g.drawString("Enemy ship got away!", 5, 295);
		}
	}

	// submethod calls Arrow keys for control of Patrol vehicle
	public static void handleKeys(DrawingPanel panel, Graphics g) {
		// variable for pixel shift of Patrol vehicle
		int deltaX = 3;
		// declares a variable as an integer that is equal to 
		// the return value of panel.getKeyCode object.
		int arrowKeys = panel.getKeyCode();
		// If return KeyCode is 0 nothing happens.
		if (arrowKeys == 0) {
			return;
		}
		// If return KeyCode is Right_ARROW, vehicle moves right
		if (arrowKeys == RIGHT_ARROW) {
			g.setColor(Color.WHITE);
			g.fillRect(patrolX, PATROL_Y, PATROL_SIZE, PATROL_SIZE);
			patrolX = patrolX + deltaX;
			g.setColor(Color.GREEN);
			g.fillRect(patrolX, PATROL_Y, PATROL_SIZE, PATROL_SIZE);
			// Prevents vehicle from running off screen
			if (patrolX >= 280) {
				g.setColor(Color.WHITE);
				g.fillRect(patrolX, PATROL_Y, PATROL_SIZE, PATROL_SIZE);
				patrolX = 277;
				g.setColor(Color.GREEN);
				g.fillRect(patrolX, PATROL_Y, PATROL_SIZE, PATROL_SIZE);
			}
		}
		// If return KeyCode is Left_ARROW, vehicle moves left
		if (arrowKeys == LEFT_ARROW) {
			g.setColor(Color.WHITE);
			g.fillRect(patrolX, PATROL_Y, PATROL_SIZE, PATROL_SIZE);
			patrolX = patrolX - deltaX;
			g.setColor(Color.GREEN);
			g.fillRect(patrolX, PATROL_Y, PATROL_SIZE, PATROL_SIZE);
			// Prevents vehicle from running off screen
			if (patrolX <= 0) {
				g.setColor(Color.WHITE);
				g.fillRect(patrolX, PATROL_Y, PATROL_SIZE, PATROL_SIZE);
				patrolX = 3;
				g.setColor(Color.GREEN);
				g.fillRect(patrolX, PATROL_Y, PATROL_SIZE, PATROL_SIZE);
			}
		}
		// KeyCode must return UP_ARROW, and patrolMissileY == 0,
		// in order to set parameter to fire missile.  This double 
		// requirement test ensures one missile fires at a time.
		if (arrowKeys == UP_ARROW && patrolMissileY == 0) {
			// initializes missile fire position at center, and
			// in front of vehicle.
			patrolMissileX = patrolX + (PATROL_SIZE/2);
			patrolMissileY = 239;
		}
	}

	// submethod for missile movement rules, and movement sequence.
	public static void movePatrolMissileAndDraw(Graphics g) {
		// variable for pixel shift of missile up the screen
		int deltaY = 5;
		// If patrolMissileY is greater than 0, code sequence for
		// missile travel up the screen.
		if (patrolMissileY > 0) {
			g.setColor(Color.WHITE);
			g.drawLine(patrolMissileX, patrolMissileY, patrolMissileX, patrolMissileY
				       	- PATROL_MISSILE_LENGTH);
			patrolMissileY = patrolMissileY - deltaY;
			g.setColor(Color.BLACK);
			g.drawLine(patrolMissileX, patrolMissileY, patrolMissileX, patrolMissileY
				       	- PATROL_MISSILE_LENGTH);
		// else if patrolMissileY is 0, or negative, draw in 
		// white. Then reinitialize to 0.
		} else if (patrolMissileY <= 0) {
			g.setColor(Color.WHITE);
			g.drawLine(patrolMissileX, patrolMissileY, patrolMissileX, patrolMissileY
				       	- PATROL_MISSILE_LENGTH);
			patrolMissileY = 0;
		}
	}
	
	// submethod for Detecting a hit on Enemy ship.
	public static boolean detectHit() {
		// Must declare boolean variable within the method for return value, 
		// and initialze the variable to the opposite boolean value of 
		// the value desired from method.  To ensure the method is executing
		// correctly.
		boolean enemyHit = false;
		// You may link multiple test values within an If statement.
		if (patrolMissileY >= ENEMY_Y && patrolMissileY <= (ENEMY_Y + ENEMY_SIZE)
			       	&& patrolMissileX >= enemyX && patrolMissileX <= (enemyX +
				       	ENEMY_SIZE)) {
			// if all test values are true the variable changes boolean value.
			enemyHit = true;
		} return enemyHit;
	}
}
