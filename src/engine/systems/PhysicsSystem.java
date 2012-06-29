/**
 * 
 */
package engine.systems;

import org.newdawn.fizzy.CollisionEvent;
import org.newdawn.fizzy.World;
import org.newdawn.fizzy.WorldListener;
import org.newdawn.slick.GameContainer;

import com.artemis.Component;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.EntityProcessingSystem;

import engine.components.Physics;
import engine.components.Position;
import engine.components.Velocity;

/**
 * System to manage the movement and collision of entities.
 * 
 * @author jonathan
 *
 */
public class PhysicsSystem extends EntityProcessingSystem {

	private ComponentMapper<Physics> physicsMapper;
	private GameContainer container;
	private World physicsWorld;
	

	public PhysicsSystem(World physicsWorld) {
		super(Physics.class);
		this.physicsWorld = physicsWorld;
		
	}

	public void initialize() {
		physicsMapper = new ComponentMapper<>(Physics.class, world);
	}
	
	protected void begin() {
		physicsWorld.update(world.getDelta());
	}
	
	protected void process(Entity e) {

	}

}
