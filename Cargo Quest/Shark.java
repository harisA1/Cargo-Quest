import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shark here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shark extends Actor {
    private int speed = 1;
    private Actor boat;
    GreenfootSound sharkSound = new GreenfootSound("shark_sound.wav");

    public Shark(Actor boat) {
        this.boat = boat;
    }
    
    public void act() {
        double distance = distance(getX(), getY(), boat.getX(), boat.getY());
        if (distance > 100) {
            speed=1;
            turnTowards(boat.getX(), boat.getY());
            move(speed);
        }
        checkCollision();
        move(speed);
    }
    private double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
  public void checkCollision() {
    Boat boat = (Boat) getOneIntersectingObject(Boat.class);
    if (boat != null) {
        boat.loseHp();
        boat.move(30);
        turn(-boat.getDirection());
        sharkSound.play();
       
        if (boat.isDestroyed()) {
            GameOver();
            Greenfoot.stop();
        }
        move(50);
        speed=0;

    }
}

    public void GameOver(){
        GreenfootImage gameover = new GreenfootImage("GAME OVER", 48, Color.RED, new Color(0, 0, 0, 0));
        getWorld().getBackground().drawImage(gameover, 100, 200);
    }
}