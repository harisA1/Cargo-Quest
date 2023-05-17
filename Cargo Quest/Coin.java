import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Actor
{
    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int pointValue = 10;
    public void act() {
        if (isTouching(Boat.class)) {
            Boat boat = (Boat) getOneIntersectingObject(Boat.class);
            boat.increaseScore(pointValue);
            playCoinSound(); // Play the coin sound effect
            getWorld().removeObject(this);
        }
    }
   private void playCoinSound() {
        GreenfootSound coinSound = new GreenfootSound("coin_sound.wav");
        coinSound.play();
    }
}
