package application;

//import java.awt.*;
import java.util.ArrayList;

//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
//import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class Bullet extends Pane {

//	private double x;
//	private double y;
//	private int r;
	
//	private int speed;
	
	
//	private Color color;
	
	public static ArrayList<Ellipse> bulletsR = new ArrayList<>();
	public static ArrayList<Ellipse> bulletsL = new ArrayList<>();
	public static ArrayList<Ellipse> bulletsU = new ArrayList<>();
	public static ArrayList<Ellipse> bulletsD = new ArrayList<>();
	
	private static Ellipse removeElipse = null;
	private static Rectangle removeRect = null;
	private static int ScoreMain;
	private static int speed = 10;
	
//	Image image = new Image(getClass().getResourceAsStream("1.png"));
//	ImageView imageView = new ImageView(image);
//	Character player = new Character(imageView);
	
	public Bullet() {
		
	}
	
	public static int getScore() {
		return ScoreMain;
	}
	
//	public void Bullet(Boolean one) {
////		x = 0;
////		y = 0;
////		r = 2;
////		
////		speed = 10;
////
////		color = Color.BLACK;
//		
//
////    	if(isPressed(KeyCode.CONTROL)) {
////    	System.out.println("2=" + player.getX());
//		if(one) {
//		double x = Character.getX() + 15;
//		double y = player.getY() + 15;
//		Ellipse elipse = new Ellipse(5, 5);
//		elipse.setCenterX(x);
//		elipse.setCenterY(y);
//		elipse.setFill(Color.RED);
//		Main.root.getChildren().addAll(elipse);
//		
//		if(player.animation.getOffsetY()==64)
//			bulletsR.add(elipse);
//		if(player.animation.getOffsetY()==32)
//			bulletsL.add(elipse);
//		if(player.animation.getOffsetY()==0)
//			bulletsU.add(elipse);
//		if(player.animation.getOffsetY()==96)
//			bulletsD.add(elipse);
//		
//
//		}
//	}
	
	public static void BulletRemove() {
		bulletsRemove(bulletsR, speed, 0);
		bulletsRemove(bulletsL, -speed, 0);
		bulletsRemove(bulletsU, 0, speed);
		bulletsRemove(bulletsD, 0, -speed);
	}
	
	public static void bulletsRemove (ArrayList<Ellipse> bullets, int speedX, int speedY) {
//		for (int i = 0; i < bullets.toArray().length; i++) {					
//			bullets.get(i).setCenterX(bullets.get(i).getCenterX() + speedX);
//			bullets.get(i).setCenterY(bullets.get(i).getCenterY() + speedY);
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
//		}
			Main.bonuses.remove(removeRect);
	        Main.root.getChildren().remove(removeRect);
			
		bullets.remove(removeElipse);
		Main.root.getChildren().remove(removeElipse);
	}

}
