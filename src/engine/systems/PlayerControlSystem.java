package engine.systems;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.geom.Vector2f;

import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.EntityProcessingSystem;

import engine.components.Controllable;
import engine.components.Position;
import engine.components.Velocity;

public class PlayerControlSystem extends EntityProcessingSystem implements
		KeyListener {

	private GameContainer container;
	private ComponentMapper<Velocity> velocityMapper;

	private boolean moveRight;
	private boolean moveLeft;

	public PlayerControlSystem(GameContainer container) {
		super(Position.class, Velocity.class, Controllable.class);
		this.container = container;
	}

	public void initialize() {
		velocityMapper = new ComponentMapper<Velocity>(Velocity.class, world);
		container.getInput().addKeyListener(this);
	}

	protected void process(Entity e) {
		Velocity vel = velocityMapper.get(e);
		if (moveLeft) {
			vel.setVelocity(new Vector2f(-0.2f, 0));
		} else if (!moveLeft) {
			vel.setVelocity(new Vector2f(0, vel.getY()));
		}
		if (moveRight) {
			vel.setVelocity(new Vector2f(0.2f, 0));
		} else if (!moveRight) {
			vel.setVelocity(new Vector2f(vel.getX(), 0));
		}
	}

	@Override
	public void inputEnded() {

	}

	@Override
	public void inputStarted() {

	}

	@Override
	public boolean isAcceptingInput() {
		return true;
	}

	@Override
	public void setInput(Input input) {

	}

	@Override
	public void keyPressed(int key, char c) {
		if (key == Input.KEY_A) {
			moveLeft = true;
			moveRight = false;
		} else if (key == Input.KEY_D) {
			moveRight = true;
			moveLeft = false;
		}
	}

	@Override
	public void keyReleased(int key, char c) {
		if (key == Input.KEY_A) {
			moveLeft = false;
		} else if (key == Input.KEY_D) {
			moveRight = false;
		}
	}

}
