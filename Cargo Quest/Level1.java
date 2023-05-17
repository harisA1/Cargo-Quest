import greenfoot.*;

public class Level1 extends SWorld {

    public Level1() {    
        super(400, 400, 1, 1000);
        // Add objects and setup the level
        setupLevel();
        prepare();
    }

    private void setupLevel() {
        // Add objects, set up barriers, coins, power-ups, etc.
        // Example:
        Boat boat = new Boat();
        setMainActor(boat, 250, 300);
        mainActor.setLocation(100, 342);
        GreenfootImage bgImage = new GreenfootImage("waves.jpg");
        setScrollingBackground(bgImage);

        // Add barriers
        Barrier barrier1 = new Barrier(30, 30);
        Barrier barrier2 = new Barrier(30, 30);
        Barrier barrier3 = new Barrier(30, 30);

        Shark shark =new Shark(boat);
        //addObject(shark,50,50);
        addObject(new Coin(),180,91);
        addObject(new Coin(),102,90);
        addObject(new Coin(),32,89);
        // Add barrier1 and its coins
        addObject(barrier1, getWidth() + 100, getHeight() - 300);
        addObject(new Coin(), barrier1.getX() - 50, barrier1.getY());
        addObject(new Coin(), barrier1.getX() + 50, barrier1.getY());
        addObject(new Coin(), barrier1.getX(), barrier1.getY() - 50);
        addObject(new Coin(), barrier1.getX(), barrier1.getY() + 50);

        // Add barrier2 and its coins
        addObject(barrier2, getWidth() + 150, getHeight() - 100);
        addObject(new Coin(), barrier2.getX() - 50, barrier2.getY());
        addObject(new Coin(), barrier2.getX() + 50, barrier2.getY());
        addObject(new Coin(), barrier2.getX(), barrier2.getY() - 50);
        addObject(new Coin(), barrier2.getX(), barrier2.getY() + 50);

        // Add barrier3 and its coins
        addObject(barrier3, -150,300);
        addObject(new Coin(), barrier3.getX() - 50, barrier3.getY());
        addObject(new Coin(), barrier3.getX() + 50, barrier3.getY());
        addObject(new Coin(), barrier3.getX(), barrier3.getY() - 50);
        addObject(new Coin(), barrier3.getX(), barrier3.getY() + 50);
        // Add power-ups
        SpeedBoostPowerUp speedBoostPowerUp = new SpeedBoostPowerUp();
        addObject(speedBoostPowerUp, 322, 96);

        Whirlpool whirlpool=new Whirlpool();
        addObject(whirlpool,-170,140);

        Checkpoint checkpoint = new Checkpoint();
        addObject(checkpoint,getWidth() + 250, getHeight() - 350);

        FinishLine finishLine=new FinishLine();
        addObject(finishLine,-250,50);

    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Coin coin = new Coin();
        addObject(coin,180,91);
        Coin coin2 = new Coin();
        addObject(coin2,102,90);
        Coin coin3 = new Coin();
        addObject(coin3,32,89);
    }
}
