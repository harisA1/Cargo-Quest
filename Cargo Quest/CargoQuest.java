import greenfoot.*;

public class CargoQuest extends SWorld {
    public CargoQuest() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 400, 1, 1000);
        GreenfootImage bgImage = new GreenfootImage("waves.jpg");
        setBackground(bgImage);
        Instructions instructions = new Instructions();
        addObject(instructions,getWidth()/2,getHeight()/2);
    }
}
