import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Whirpool here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Whirlpool extends Actor
{
    /**
     * Act - do whatever the Whirpool wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int pullStrength=2; // strength of the whirlpool's current
    
    public Whirlpool() {
        //this.pullStrength = pullStrength;
    }
   public void act() {
    // Get a list of all objects within the whirlpool's range
    List<Actor> nearbyObjects = getObjectsInRange(100, Actor.class);
    
    // For each nearby object, calculate the vector from the object to the whirlpool
    for (Actor obj : nearbyObjects) {
        int dx = getX() - obj.getX();
        int dy = getY() - obj.getY();
        double distance = Math.sqrt(dx*dx + dy*dy);
        
        if(!(obj instanceof Barrier)){
            // Apply a force to the object proportional to the whirlpool's pull strength and the object's distance from the center of the whirlpool
            double force = pullStrength / distance;
            obj.setLocation(obj.getX() + (int)(dx * force), obj.getY() + (int)(dy * force));
        }
    }
}

}
