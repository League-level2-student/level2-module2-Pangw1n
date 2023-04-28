package _08_LeagueSnake;

import java.util.ArrayList;

import processing.core.PApplet;

public class LeagueSnake extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    
    /*
     * Game variables
     * 
     * Put all the game variables here.
     */
    Segment head;
    int foodX;
    int foodY;
    int direction;
    int foodEaten;
    ArrayList<Segment> tail = new ArrayList<Segment>();

    
    /*
     * Setup methods
     * 
     * These methods are called at the start of the game.
     */
    @Override
    public void settings() {
        setSize(800, 800);
    }

    @Override
    public void setup() {
        head = new Segment(400, 400);
        frameRate(15);
        dropFood();
        direction = UP;
    }

    void dropFood() {
        // Set the food in a new random location
        foodX = (int)random(50) * 10;
        foodY = (int)random(50) * 10;
    }

    /*
     * Draw Methods
     * 
     * These methods are used to draw the snake and its food
     */

    @Override
    public void draw() {
    	eat();
    	move();
        background(0);
        drawFood();
        drawSnake();
    }

    void drawFood() {
        // Draw the food
        fill(255, 0, 0);
        rect(foodX - 5, foodY - 5, 10, 10);
        fill(0, 255, 0);
        rect(foodX - 2, foodY - 8, 4, 6);
    }

    void drawSnake() {
        // Draw the head of the snake followed by its tail
    	fill(0, 100, 255);
    	rect(head.x - 5, head.y - 5, 10, 10);
    	manageTail();
    }

    void drawTail() {
        // Draw each segment of the tail
        for (Segment s : tail)
        {
        	fill(0, 125, 255);
        	rect(s.x - 5, s.y - 5, 10, 10);
        }
    }

    /*
     * Tail Management methods
     * 
     * These methods make sure the tail is the correct length.
     */

    void manageTail() {
        // After drawing the tail, add a new segment at the "start" of the tail and
        // remove the one at the "end"
        // This produces the illusion of the snake tail moving.
    	checkTailCollision();
    	drawTail();
    	tail.add(new Segment(head.x, head.y));
    	tail.remove(0);
    }

    void checkTailCollision() {
        // If the snake crosses its own tail, shrink the tail back to one segment
        for (Segment s : tail)
        {
            if(Math.abs(head.x - s.x) < 10 && Math.abs(head.y - s.y) < 10)
            { 
            	foodEaten = 1;
            	tail = new ArrayList<Segment>();
            	tail.add(new Segment(head.x, head.y));
            }
        }
    }

    /*
     * Control methods
     * 
     * These methods are used to change what is happening to the snake
     */

    @Override
    public void keyPressed() {
        // Set the direction of the snake according to the arrow keys pressed
        int key = keyCode;
        if(key == UP && direction != DOWN)
        {
            direction = key;
        }
        if(key == DOWN && direction != UP)
        {
            direction = key;
        }
        if(key == RIGHT && direction != LEFT)
        {
            direction = key;
        }
        if(key == LEFT && direction != RIGHT)
        {
            direction = key;
        }
    }

    void move() {
        // Change the location of the Snake head based on the direction it is moving.

        if (direction == UP) {
            // Move head up
            head.y -= 10;
        } else if (direction == DOWN) {
            // Move head down
            head.y += 10;
        } else if (direction == LEFT) {
            head.x -= 10;
        } else if (direction == RIGHT) {
            head.x += 10;
        }
        checkBoundaries();
    }

    void checkBoundaries() {
        // If the snake leaves the frame, make it reappear on the other side
        if (head.y < 0)
        {
        	head.y = HEIGHT;
        }
        if (head.y > HEIGHT)
        {
        	head.y = 0;
        }
        if (head.x < 0)
        {
        	head.x = WIDTH;
        }
        if (head.x > WIDTH)
        {
        	head.x = 0;
        }
    }

    void eat() {
        // When the snake eats the food, its tail should grow and more
        // food appear
        if(Math.abs(head.x - foodX) < 10 && Math.abs(head.y - foodY) < 10)
        { 
        	foodEaten ++;
        	dropFood();
        	tail.add(new Segment(head.x, head.y));
        }
    }

    static public void main(String[] passedArgs) {
        PApplet.main(LeagueSnake.class.getName());
    }
}
