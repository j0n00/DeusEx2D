package engine.systems;

import org.newdawn.slick.GameContainer;

import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.EntityProcessingSystem;

import engine.components.Position;
import engine.components.Velocity;

public class MovementSystem extends EntityProcessingSystem {

	private GameContainer container;
	private ComponentMapper<Velocity> velocityMapper;
	private ComponentMapper<Position> positionMapper;

	public MovementSystem(GameContainer container) {
		super(Position.class, Velocity.class);
		this.container = container;
	}

	@Override
	public void initialize() {
		velocityMapper = new ComponentMapper<Velocity>(Velocity.class, world);
		positionMapper = new ComponentMapper<Position>(Position.class, world);
	}

	@Override
	protected void process(Entity e) {
		// Get the components from entity.
        Position position = positionMapper.get(e);
        Velocity velocity = velocityMapper.get(e);

        // Calculate new position.
        float newX = position.getX() + (world.getDelta() * velocity.getX());
        float newY = position.getY() + (world.getDelta() * velocity.getY());

        // Set the new position.
        position.setPosition(newX, newY);
	}

}
