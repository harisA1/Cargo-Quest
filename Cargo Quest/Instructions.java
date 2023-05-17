import greenfoot.*; 

public class Instructions extends Actor {
    private GreenfootImage image;
    
    public Instructions() {
        // Create a new image with the instructions
        image = new GreenfootImage("instructions.png");
        setImage(image);
    }
    
    public void act() {
        // Display the instructions in the center of the world
        
        // Remove the instructions after a certain time
        if (Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown("enter")) {
            getWorld().removeObject(this);
            Level1 level1 = new Level1();
            Greenfoot.setWorld(level1);
        }
    }
}
