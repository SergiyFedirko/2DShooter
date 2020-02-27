package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.HashMap;



public class Main extends Application {
	
	private HashMap<KeyCode, Boolean> keys = new HashMap<>();
	public static ArrayList<Rectangle> bonuses = new ArrayList<>();
	
	int a = 0;
	
	Image image = new Image(getClass().getResourceAsStream("hero.png"));
	ImageView imageView = new ImageView(image);
	Character player = new Character(imageView);

	Label lbl = new Label();

	static Pane root = new Pane();

	public void bonus() {
		int random = (int) Math.floor(Math.random() * 100);
		int x = (int) Math.floor(Math.random() * 568);
		int y = (int) Math.floor(Math.random() * 568);
		if (random == 5) {
			Rectangle rect = new Rectangle(20, 20, Color.RED);
			rect.setX(x);
			rect.setY(y);
			bonuses.add(rect);
			root.getChildren().addAll(rect);
		}
	}

public void bullet(int one) {

		one = one%5;
		if(one==1) {
		double x = player.getX() + 15;
		double y = player.getY() + 15;
		Ellipse elipse = new Ellipse(5, 5);
		elipse.setCenterX(x);
		elipse.setCenterY(y);
		elipse.setFill(Color.RED);
		root.getChildren().addAll(elipse);
		
		if(player.animation.getOffsetY()==64)
			Bullet.bulletsR.add(elipse);
		if(player.animation.getOffsetY()==32)
			Bullet.bulletsL.add(elipse);
		if(player.animation.getOffsetY()==0)
			Bullet.bulletsU.add(elipse);
		if(player.animation.getOffsetY()==96)
			Bullet.bulletsD.add(elipse);

		}

	}

	public void update() {
		
		if (isPressed(KeyCode.UP)) {
			player.animation.play();
			player.animation.setOffsetY(96);
			player.moveY(-2);
		} else if (isPressed(KeyCode.DOWN)) {
			player.animation.play();
			player.animation.setOffsetY(0);
			player.moveY(2);
		} else if (isPressed(KeyCode.RIGHT)) {
			player.animation.play();
			player.animation.setOffsetY(64);
			player.moveX(2);
		} else if (isPressed(KeyCode.LEFT)) {
			player.animation.play();
			player.animation.setOffsetY(32);
			player.moveX(-2);
		} else if (isPressed(KeyCode.CONTROL)) {
			a++;
			bullet(a);
		}else {
			a=0;
			player.animation.stop();
		}
//		lbl.setText("Score: " + player.getScore());
		Bullet.BulletRemove();
		lbl.setText("Score: " + Bullet.getScore());
	}
	


	public boolean isPressed(KeyCode key) {
		return keys.getOrDefault(key, false);
	}
	
	public void Delete() {
	}
	
    private void initContent(){
    	
    	root.setPrefSize(600, 600);
		root.getChildren().addAll(player);
		
		Rectangle area = new Rectangle(0, 0, 601, 601);
		area.setFill(Color.TRANSPARENT);
		area.setStroke(Color.BLACK);
		root.getChildren().addAll(area);
    	
		lbl.setText("Score: " + Bullet.getScore());
		lbl.setLayoutX(450);
		lbl.setTextFill(Color.BLACK);
		lbl.setFont(new Font(20));
		root.getChildren().add(lbl);
    	

    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		initContent();
		
		Scene scene = new Scene(root);
		scene.setOnKeyPressed(event -> keys.put(event.getCode(), true));
		scene.setOnKeyReleased(event -> {
			keys.put(event.getCode(), false);
		});
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				update();
				bonus();
			}
		};
		timer.start();
		primaryStage.setTitle("Game");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
