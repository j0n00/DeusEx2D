package engine.spatials;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.World;

import engine.components.Position;

public class PlayerCharacter extends Spatial {

	private Position transform;
	private Image playerSprite;

	public PlayerCharacter(World world, Entity owner) {
		super(world, owner);
	}

	public void initalize() {
		ComponentMapper<Position> transformMapper = new ComponentMapper<Position>(
				Position.class, world);
		transform = transformMapper.get(owner);
		try {
			playerSprite = new Image("bin/player.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void render(Graphics g) {
		g.drawImage(playerSprite, transform.getX() - playerSprite.getWidth() / 2,
				transform.getY() - playerSprite.getHeight() / 2);
	}
}
