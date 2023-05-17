import greenfoot.*;

public class Barrier extends Actor {
    
    private int width;
    private int height;
    public Barrier(int w,int h) {
        GreenfootImage image = new GreenfootImage(w, h);
        image.setColor(Color.YELLOW);
        image.fill();
        setImage(image);
        this.width=w;
        this.height=h;
        
    }
    public void act() {
        Actor actor = getOneIntersectingObject(Actor.class);
        if (actor != null) {
            int dx = actor.getX() - getX();
            int dy = actor.getY() - getY();
            if (Math.abs(dx) > Math.abs(dy)) {
                if (dx > 0) {
                    actor.setLocation(getX() + getImage().getWidth() / 2 + actor.getImage().getWidth() / 2, actor.getY());
                } else {
                    actor.setLocation(getX() - getImage().getWidth() / 2 - actor.getImage().getWidth() / 2, actor.getY());
                }
            } else {
                if (dy > 0) {
                    actor.setLocation(actor.getX(), getY() + getImage().getHeight() / 2 + actor.getImage().getHeight() / 2);
                } else {
                    actor.setLocation(actor.getX(), getY() - getImage().getHeight() / 2 - actor.getImage().getHeight() / 2);
                }
            }
        }
    }
    
}
