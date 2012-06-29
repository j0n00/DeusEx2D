package engine.systems;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.EntityProcessingSystem;
import com.artemis.utils.Bag;

import engine.components.Position;
import engine.components.SpatialForm;
import engine.spatials.PlayerCharacter;
import engine.spatials.Spatial;

public class RenderSystem extends EntityProcessingSystem {

	private GameContainer container;
	private Graphics graphics;
	private Bag<Spatial> spatials;
	private ComponentMapper<SpatialForm> spatialFormMapper;
	private ComponentMapper<Position> transformMapper;

	public RenderSystem(GameContainer container) {
		super(Position.class, SpatialForm.class);
		this.container = container;
		this.graphics = container.getGraphics();
		spatials = new Bag<Spatial>();
	}

	public void initialize() {
		spatialFormMapper = new ComponentMapper<SpatialForm>(SpatialForm.class,
				world);
		transformMapper = new ComponentMapper<Position>(Position.class, world);
	}

	protected void process(Entity e) {
		Spatial spatial = spatials.get(e.getId());
		Position transform = transformMapper.get(e);

		if (transform.getX() >= 0 && transform.getY() >= 0
				&& transform.getX() < container.getWidth()
				&& transform.getY() < container.getHeight() && spatial != null) {
			spatial.render(graphics);
		}
	}

	protected void added(Entity e) {
		Spatial spatial = createSpatial(e);
		if (spatial != null) {
			spatial.initalize();
			spatials.set(e.getId(), spatial);
		}
	}

	protected void removed(Entity e) {
		spatials.set(e.getId(), null);
	}

	private Spatial createSpatial(Entity e) {
		SpatialForm spatialForm = spatialFormMapper.get(e);
		String spatialFormFile = spatialForm.getSpatialFormFile();
		if ("Player".equalsIgnoreCase(spatialFormFile)) {
                return new PlayerCharacter(world, e);
        }
		return null;
	}

}
