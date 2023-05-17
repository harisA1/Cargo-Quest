import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Powerup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpeedBoostPowerUp extends Actor {
    // Define any necessary instance variables for the power-up object

    public SpeedBoostPowerUp() {
        // Set the appearance of the power-up object
        GreenfootImage image = new GreenfootImage("speed.png");
        image.scale(35, 35); // resize the image to 50x50 pixels
        setImage(image);
    }

    public void act() {
        // Define the behavior of the power-up object in each frame of the game
    }

    // Define any methods for the power-up object's behavior
}
