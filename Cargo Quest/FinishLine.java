import greenfoot.*; 

public class FinishLine extends Actor {
    public void act() {
        // Check if the boat intersects with the finish line
        if (getOneIntersectingObject(Boat.class) != null) {
            // Set a flag in the Boat class indicating that the boat has finished the race
            ((Boat) getOneIntersectingObject(Boat.class)).checkProgress();
        }
    }
    
  
}
