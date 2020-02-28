package application;


import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class Bullet extends Pane {
	
	public static ArrayList<Ellipse> bulletsR = new ArrayList<>();
	public static ArrayList<Ellipse> bulletsL = new ArrayList<>();
	public static ArrayList<Ellipse> bulletsU = new ArrayList<>();
	public static ArrayList<Ellipse> bulletsD = new ArrayList<>();
	
	private static Ellipse removeElipse = null;
	private static Rectangle removeRect = null;
	private static int ScoreMain;
	private static int speed = 10;
	
	
	public Bullet() {
		
	}
	
	public static int getScore() {
		return ScoreMain;
	}
	

	
	public static void BulletRemove() {
		bulletsRemove(bulletsR, speed, 0);
		bulletsRemove(bulletsL, -speed, 0);
		bulletsRemove(bulletsU, 0, speed);
		bulletsRemove(bulletsD, 0, -speed);
	}
	
	public static void bulletsRemove (ArrayList<Ellipse> bullets, int speedX, int speedY) {

			bullets.forEach(elipse ->{
				elipse.setCenterX(elipse.getCenterX() + speedX);
				elipse.setCenterY(elipse.getCenterY() + speedY);
			Main.bonuses.forEach((rect) ->{
				
					if(elipse.getBoundsInParent().intersects(rect.getBoundsInParent())) {
						removeRect = rect;
						ScoreMain++;
						System.out.println(ScoreMain);
					}
				});
			if(elipse.getCenterX()>595 || elipse.getCenterY()>595) 
			removeElipse = elipse;
		
						});
			Main.bonuses.remove(removeRect);
	        Main.root.getChildren().remove(removeRect);
			
		bullets.remove(removeElipse);
		Main.root.getChildren().remove(removeElipse);
	}

}
