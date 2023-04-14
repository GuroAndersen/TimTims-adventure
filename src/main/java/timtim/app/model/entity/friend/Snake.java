package timtim.app.model.entity.friend;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Array;

import timtim.app.core.GameScreen;
import timtim.app.model.map.GameMap;
import timtim.app.model.objects.Inventory.Item;
import timtim.app.model.objects.Inventory.ItemFactory;

public class Snake extends Friend {

	/**
	 * Creates a snake Friend who takes its sprite from the given gameScreen.
	 * 
	 * @param gameScreen
	 */
	public Snake(GameMap map) {
		super(map, ItemFactory.newItem("juicebox"));
		setupAnimation();
	}

	/**
	 * Testing constructor. Creates a snake who wants this item.
	 * 
	 * @param newItem
	 */
	public Snake(Item newItem) {
		super(newItem);
	}

	private void setupAnimation() {
		stateTimer = 0;
		// setup run animation
		Array<TextureRegion> frames = new Array<TextureRegion>();
		for (int r = 0; r < 1; r++) {
			for (int c = 0; c < 2; c++) {
				frames.add(new TextureRegion(sprite.getTexture(), sprite.getRegionX() + c * 32,
						sprite.getRegionY() + r * 32, 32, 32));
			}
		}
		idleAnimation = new Animation<TextureRegion>(0.1f, frames);
		frames.clear();
	}
}
