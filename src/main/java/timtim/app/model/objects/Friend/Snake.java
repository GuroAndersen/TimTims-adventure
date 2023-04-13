package timtim.app.model.objects.Friend;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
	public Snake(GameScreen gameScreen, GameMap map) {
		super(map, ItemFactory.newItem("juicebox"));
		this.sprite = new Sprite(gameScreen.getAtlas().findRegion("snake"));
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
