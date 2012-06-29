package engine.components;

import org.newdawn.slick.geom.Vector2f;

import com.artemis.Component;

public class Position extends Component {
	private Vector2f position;

	public Position() {
		this.position = new Vector2f();
	}

	public Position(float x, float y) {
		this.position = new Vector2f(x, y);
	}

	public void addX(float x) {
		position.x += x;
	}

	public void addY(float y) {
		position.y += y;
	}

	public float getX() {
		return position.x;
	}

	public void setX(float x) {
		position.x = x;
	}

	public float getY() {
		return position.y;
	}

	public void setY(float y) {
		position.y = y;
	}

	public void setPosition(float x, float y) {
		position.set(x, y);
	}

}
