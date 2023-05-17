import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boat here.
 * 
 * @Haris Ampas 
 * @v1 
 */
public class Boat extends Actor {
    private int speed;
    private int maxSpeed;
    private int acceleration;
    private int turningRadius;
    private int direction;
    private boolean hasStarted;
    private int speedBoostTimer = 0; // Initialize to 0
    private int speedBoostDuration = 60; // Set the duration of the speed boost effect in frames (e.g., 180 frames = 3 seconds at 60 frames per second)
    private GreenfootImage[] boatImages; // Array of boat images
    private int imageCounter = 0; // Counter to keep track of which image to display
    private int score = 0;
    private boolean checkpointPassed;
    private int hp=3;
    private int flag;
    private int timeElapsed = 0;
    private int frames;
    public Boat() {
        maxSpeed = 3;
        acceleration = 1;
        turningRadius = 4;
        hasStarted = false;
        flag=1;
        boatImages = new GreenfootImage[4]; // Create array for two boat images
        boatImages[0] = new GreenfootImage("boat1.png"); // Set image 1
        boatImages[1] = new GreenfootImage("boat2.png"); 
        boatImages[2] = new GreenfootImage("boat3.png"); 
        boatImages[3] = new GreenfootImage("boat4.png");
    }
   
    public void act() {
        if (!hasStarted) {
            speed = 1; // Set initial velocity
            hasStarted = true;
        }
        checkKeyPress();
        checkPowerUp();
        timeSpeedBoost();
        move();
        animate(); 
        displayInfo();
        frames++;
        timeElapsed=frames/50;
    }
    private void timeSpeedBoost(){
        if (speedBoostTimer > 0) {
        speedBoostTimer--; // Decrement the timer
        if (speedBoostTimer == 0) {
            maxSpeed = 3; // Reset the max speed after the duration has passed
            speed=3;
        }
    }
    }
    private void checkKeyPress() {
        if (Greenfoot.isKeyDown("up")) {
            accelerate();
        }
        if (Greenfoot.isKeyDown("down")) {
            brake();
        }
        if (Greenfoot.isKeyDown("left")) {
            turnLeft();
        }
        if (Greenfoot.isKeyDown("right")) {
            turnRight();
        }
    }
    
    private void accelerate() {
        if (speed < maxSpeed) {
            speed += acceleration;
        }
    }
    
    
    private void brake() {
        if (speed > 0) {
            speed -= acceleration;
        } 
    }
    
    private void turnLeft() {
        direction -= turningRadius;
        flag=0;
    }
    
    private void turnRight() {
        direction += turningRadius;
        flag=1;
    }
    
    private void move() {
        int dx = (int) (speed * Math.cos(Math.toRadians(direction)));
        int dy = (int) (speed * Math.sin(Math.toRadians(direction)));
        setLocation(getX() + dx, getY() + dy);
        
        if (speed > 0) {
            int dxNext = (int) ((speed + acceleration) * Math.cos(Math.toRadians(direction)));
            int dyNext = (int) ((speed + acceleration) * Math.sin(Math.toRadians(direction)));

        }
        
    }
    private void checkPowerUp() {
        SpeedBoostPowerUp speedBoostPowerUp = (SpeedBoostPowerUp) getOneIntersectingObject(SpeedBoostPowerUp.class);
        if (speedBoostPowerUp != null) {
            maxSpeed += 3; // Adjust as desired for the speed boost effect
            speedBoostTimer = speedBoostDuration; // Set the timer to the duration of the speed boost effect
            // Perform any other actions or effects for the speed boost power-up
            
            speedBoostPowerUp.getWorld().removeObject(speedBoostPowerUp);
        }
    }
    public void increaseScore(int amount) {
        score += amount;
    }


    private void animate() {
        
        // Check direction of the boat and set appropriate image
        if (flag==0) {
            // Facing left
            if (imageCounter <= 30) {
                setImage(boatImages[2]); // Set image 3
            } else {
                setImage(boatImages[3]); // Set image 4
            }
        } else {
            // Facing right
            if (imageCounter <= 30) {
                setImage(boatImages[0]); // Set image 1
            } else {
                setImage(boatImages[1]); // Set image 2
            }
    
        }
        imageCounter++; // Increment counter
        if (imageCounter == 50) { // Change image every 6 frames
            imageCounter = 0;
        }
    }
    
    public void displayInfo(){
        displayScore();
        displayHp();
        displayCargo();
        displayTime();
    }
    
    public void displayTime(){
    GreenfootImage timeDisplay = new GreenfootImage("Time: " + timeElapsed, 24, Color.BLACK, new Color(0, 0, 0, 0));
    getWorld().showText("", 15, 20);
    getWorld().getBackground().drawImage(timeDisplay, 15, 20);
}
    public void displayScore() {
        GreenfootImage scoreImage = new GreenfootImage("Score: " + score, 24, Color.BLUE, new Color(0, 0, 0, 0));
        getWorld().showText("", 100, 20);
        getWorld().getBackground().drawImage(scoreImage, 100, 20);
        
    }
    public void displayHp(){
        GreenfootImage hpImage = new GreenfootImage("Health: " + hp, 24, Color.PINK, new Color(0, 0, 0, 0));
        getWorld().getBackground().drawImage(hpImage, 0, 370);
    }
    public void displayCargo(){
        if(!checkpointPassed){
            Color textColor=Color.RED;
            String cargoStatus="Not picked";
            GreenfootImage cargoImage = new GreenfootImage("Cargo: " + cargoStatus, 20, textColor, new Color(0, 0, 0, 0));
            getWorld().showText("", 100, 20);
            getWorld().getBackground().drawImage(cargoImage, 260, 370);}
        else{
            Color textColor=Color.GREEN;
            String cargoStatus="Picked";
            GreenfootImage cargoImage = new GreenfootImage("Cargo: " + cargoStatus, 20, textColor, new Color(0, 0, 0, 0));
            getWorld().showText("", 100, 20);
            getWorld().getBackground().drawImage(cargoImage, 260, 370);
        }
        
    }
    
    public void setCheckpointPassed(boolean passed){
            checkpointPassed=true;
    }
   public void checkProgress() {
    if (checkpointPassed) {
        World currentWorld = getWorld();
        if (currentWorld instanceof Level2) {
            Greenfoot.stop(); // Stop the game
        } else {
            Level2 level2 = new Level2();
            Greenfoot.setWorld(level2);
        }
    }
}

    public boolean isDestroyed() {
    return hp <= 0;
}

    public void loseHp() {
        hp--; // assuming hp is an instance variable of the boat class
    }
    public int getDirection(){
    return direction;
    }




}
