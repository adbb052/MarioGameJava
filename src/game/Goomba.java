package game;

import city.cs.engine.*;

public class Goomba extends Walker implements StepListener {

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            -0.253f,0.975f, -0.995f,0.101f, -0.874f,-0.854f, -0.742f,-0.975f, 0.725f,-0.98f, 0.834f,-0.865f, 0.955f,0.136f, 0.242f,0.981f);

    private static final BodyImage image =
            new BodyImage("data/goomba.png", 2.25f);

    private int counter, speed;

    public Goomba(World world) {
        super(world, shape);
        addImage(image);
        world.addStepListener(this);
        counter = 0;
        speed = 5;
        startWalking(speed);
    }
    @Override
    public void preStep(StepEvent stepEvent) {
        counter++;
        if (counter % 120 == 0){
            this.stopWalking();
            this.startWalking(speed*=-1);
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}