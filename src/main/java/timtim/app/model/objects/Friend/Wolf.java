package timtim.app.model.objects.Friend;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import timtim.app.core.GameScreen;
import timtim.app.model.map.GameMap;
import timtim.app.model.objects.Inventory.Item;
import timtim.app.model.objects.Inventory.ItemFactory;

public class Wolf extends Friend {

	GameScreen game;

	/**
	 * Creates a wolf that wants the given item. It takes its sprite from the
	 * gamescreen.
	 * 
	 * @param game
	 * @param map
	 */
	public Wolf(GameScreen game, GameMap map) {
		super(map, ItemFactory.newItem("ball"));
		this.game = game;
		this.sprite = new Sprite(game.getAtlas().findRegion("wolf"));
		setupAnimation();
	}

	/**
	 * Testing constructor using the given item
	 * 
	 * @param item
	 */
	public Wolf(Item item) {
		super(item);
	}

	private void setupAnimation() {
		// setup run animation
		Array<TextureRegion> frames = new Array<TextureRegion>();
		for (int r = 0; r < 1; r++) {
			for (int c = 0; c < 4; c++) {
				frames.add(new TextureRegion(sprite.getTexture(), sprite.getRegionX() + c * 32 * 2,
						sprite.getRegionY() + r * 32, 32 * 2, 32));
			}
		}
		idleAnimation = new Animation<TextureRegion>(0.1f, frames);
		frames.clear();
	}

}
