import greenfoot.*; 

public class Checkpoint extends Actor {
    
    public Checkpoint() {
    }
    
    public void act() {
        // Check if the boat intersects with the checkpoint
        if (getOneIntersectingObject(Boat.class) != null) {
            // Set a flag in the Boat class indicating that the boat has passed through this checkpoint
            ((Boat) getOneIntersectingObject(Boat.class)).setCheckpointPassed(true);
        }
    }
}
