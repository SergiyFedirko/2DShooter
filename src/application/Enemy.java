package application;


import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;

public class Enemy extends Pane{

    ImageView imageViewEnemy;
    int count = 3;
    int columns = 3;
    int offsetX = 0;
    int offsetY = 0;
    int width = 48;
    int height = 48;
    int score = 0;
    
    int k;
    
    Ellipse removeRect = null;
    SpriteAnimation animation;
    public Enemy(ImageView imageViewEnemy){
        this.imageViewEnemy = imageViewEnemy;
        this.imageViewEnemy.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        animation = new SpriteAnimation(imageViewEnemy,Duration.millis(200),count,columns,offsetX,offsetY,width,height);
        getChildren().addAll(imageViewEnemy);
    }
 
    public void moveX(int x){
    		switch (x) {
    		case 1:
				if ( this.getTranslateX()==0) {k=1; animation.setOffsetY(96);}
		    	 if ( this.getTranslateX()==552) {k=-1; animation.setOffsetY(48);}
		    	 this.setTranslateY(300);
		    	 this.setTranslateX(this.getTranslateX() + k);
				break;
				
			case 2:
				if ( this.getTranslateY()==0) {k=1; animation.setOffsetY(0);}
		    	 if ( this.getTranslateY()==552) {k=-1; animation.setOffsetY(144);}
		    	 this.setTranslateX(200);
		    	 this.setTranslateY(this.getTranslateY() + k);
				break;
				
			case 3:
				if ( this.getTranslateY()==0) {k=1; animation.setOffsetY(0);}
		    	 if ( this.getTranslateY()==552) {k=-1; animation.setOffsetY(144);}
		    	 this.setTranslateX(100);
		    	 this.setTranslateY(this.getTranslateY() + k);
				break;

			default:
				break;
			}
    	

//            isEnemyDestroy();
            }
    
public void isEnemyDestroy() {
    			
    		}
}
