package engine;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.SystemManager;
import com.artemis.World;

import engine.components.Position;
import engine.systems.MovementSystem;
import engine.systems.PlayerControlSystem;
import engine.systems.RenderSystem;
// TEST
public class Game extends BasicGame implements KeyListener {

	private World world;
	private org.newdawn.fizzy.World physicsWorld;

	private EntitySystem renderSystem;
	private EntitySystem movementSystem;
	private EntitySystem playerControlSystem;

	private TiledMap map;

	private GameContainer container;


	public Game() {
		super("Deus Ex 2D");
	}

	public void init(GameContainer container) throws SlickException {
		this.container = container;
		
		world = new World();
		physicsWorld = new org.newdawn.fizzy.World();
		SystemManager systemManager = world.getSystemManager();
		playerControlSystem = systemManager.setSystem(new PlayerControlSystem(
				container));
		movementSystem = systemManager.setSystem(new MovementSystem(container));
		renderSystem = systemManager.setSystem(new RenderSystem(container));
		systemManager.initializeAll();

		container.setVSync(true); //Limit FPS
		
		map = new TiledMap("bin/map01.tmx"); //Load Level

		initPlayer();
	}

	public void initPlayer() {
		Entity player = EntityFactory.createPlayer(world);
		player.getComponent(Position.class).setPosition(32, 64);
		/*player.getComponent(Position.class).setPosition(
				container.getWidth() / 2, container.getHeight() / 2);*/
		player.refresh();
	}

	public void update(GameContainer container, int delta)
			throws SlickException {
		world.loopStart(); // signals loop start
		world.setDelta(delta); // sets delta for systems to use
		playerControlSystem.process();
		movementSystem.process();
	}

	public void render(GameContainer container, Graphics g)
			throws SlickException {
		map.render(0, 0);
		renderSystem.process();
	}

	public static void main(String[] argv) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Game());
		app.setDisplayMode(800, 600, false);
		app.start();
	}

}
