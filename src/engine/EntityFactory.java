package engine;

import com.artemis.Entity;
import com.artemis.World;

import engine.components.Controllable;
import engine.components.Position;
import engine.components.SpatialForm;
import engine.components.Velocity;

public class EntityFactory {
	public static Entity createPlayer(World world) {
		Entity player = world.createEntity();
		player.setGroup("HUMANS");
		player.setTag("PLAYER");
		player.addComponent(new Position());
        player.addComponent(new Velocity());
        player.addComponent(new SpatialForm("Player"));
        player.addComponent(new Controllable());
        return player;
	}
	
	public static Entity createWall(World world) {
		Entity wall = world.createEntity();
		wall.setGroup("WALL");
		wall.addComponent(new Position());
		return wall;
	}
}
