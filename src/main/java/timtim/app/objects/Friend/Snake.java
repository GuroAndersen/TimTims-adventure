package timtim.app.objects.Friend;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import timtim.app.core.GameScreen;
import timtim.app.manager.GameMap;
import timtim.app.objects.Inventory.Item;
import timtim.app.objects.Inventory.ItemFactory;

public class Snake extends Friend {

	
	/**
	 * Creates a snake Friend who takes
	 * its sprite from the given gameScreen.
	 * @param gameScreen
	 */
	public Snake(GameScreen gameScreen, GameMap map) {
		super(map, ItemFactory.newItem("juicebox"));
//		this.sprite = new Sprite(gameScreen.getAtlas().findRegion("snake"));
//		setupAnimation();
	}

	/**
	 * Testing constructor. 
	 * Creates a snake who wants this item.
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
				frames.add(new TextureRegion(sprite.getTexture(), c * 32, r * 32, 32, 32));
			}
		}
		idleAnimation = new Animation<TextureRegion>(0.1f, frames);
		frames.clear();
	}
}