package engine.components;

import org.newdawn.slick.geom.Vector2f;

import com.artemis.Component;

public class Velocity extends Component {
	private Vector2f velocity;

	public Velocity() {
		this.velocity = new Vector2f();
	}

	public Velocity(Vector2f vector) {
		this.velocity = vector;
	}

	public Vector2f getVelocity() {
		return velocity;
	}
	
	public float getX() {
		return velocity.x;
	}
	
	public float getY() {
		return velocity.y;
	}
	
	public void setVelocity(Vector2f velocity) {
		this.velocity = velocity;
	}

	/**
	 * Returns true if the entity is stationary, or false if it is moving.
	 * @return
	 */
	public boolean isStationary() {
		if (velocity.x == 0 && velocity.y == 0) {
			return true;
		}
		return false;
	}
}
