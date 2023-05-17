import greenfoot.*;

public class Level2 extends SWorld {

    public Level2() {
        super(400, 400, 1, 1000);
        setupLevel();
        //prepare();
    }

    private void setupLevel() {
        // Add main actor
        Boat boat = new Boat();
        setMainActor(boat, 250, 300);

        // Add scrolling background
        GreenfootImage bgImage = new GreenfootImage("waves.jpg");
        setScrollingBackground(bgImage);

        
        Shark shark =new Shark(boat);
        addObject(shark,-170, 140);
        // Add barriers
        Barrier barrier1 = new Barrier(30, 30);
        Barrier barrier2 = new Barrier(30, 30);
        Barrier barrier3 = new Barrier(30, 30);
        Barrier barrier4 = new Barrier(30, 30);
        Barrier barrier5 = new Barrier(30, 30);

        // Add barrier1 and its coins
        addObject(barrier1,100, getHeight() - 200);
        addObject(new Coin(), barrier1.getX() - 50, barrier1.getY());
        addObject(new Coin(), barrier1.getX() + 50, barrier1.getY());
        addObject(new Coin(), barrier1.getX(), barrier1.getY() - 50);
        addObject(new Coin(), barrier1.getX(), barrier1.getY() + 50);

        // Add barrier2 and its coins
        addObject(barrier2, getWidth() + 10, getHeight() - 100);
        addObject(new Coin(), barrier2.getX() - 50, barrier2.getY());
        addObject(new Coin(), barrier2.getX() + 50, barrier2.getY());
        addObject(new Coin(), barrier2.getX(), barrier2.getY() - 50);
        addObject(new Coin(), barrier2.getX(), barrier2.getY() + 50);

        // Add barrier3 and its coins
        addObject(barrier3, -150, getHeight() - 100);
        addObject(new Coin(), barrier3.getX() - 50, barrier3.getY());
        addObject(new Coin(), barrier3.getX() + 50, barrier3.getY());
        addObject(new Coin(), barrier3.getX(), barrier3.getY() - 50);
        addObject(new Coin(), barrier3.getX(), barrier3.getY() + 50);

        // Add barrier4 and its coins
        addObject(barrier4, getWidth() + 200, getHeight() - 300);
        addObject(new Coin(), barrier4.getX() - 50, barrier4.getY());
        addObject(new Coin(), barrier4.getX() + 50, barrier4.getY());
        addObject(new Coin(), barrier4.getX(), barrier4.getY() - 50);
        addObject(new Coin(), barrier4.getX(), barrier4.getY() + 50);

      

        // Add power-ups
        SpeedBoostPowerUp speedBoostPowerUp = new SpeedBoostPowerUp();
        addObject(speedBoostPowerUp, 322, 96);

        Whirlpool whirlpool = new Whirlpool();
        addObject(whirlpool, -170, 140);
        addObject(new Whirlpool(),barrier2.getX()+200,barrier2.getY()+20);

        // Add checkpoint
        Checkpoint checkpoint = new Checkpoint();
        addObject(checkpoint, getWidth() + 250, getHeight() - 350);
        //Add finish line
        addObject(new FinishLine(),barrier3.getX()-100,barrier3.getY()+50);
        
    }
}
       
