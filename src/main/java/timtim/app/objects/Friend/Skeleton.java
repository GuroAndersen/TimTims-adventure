package timtim.app.objects.Friend;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import timtim.app.core.GameScreen;
import timtim.app.manager.Const;
import timtim.app.manager.GameMap;
import timtim.app.objects.Inventory.Item;
import timtim.app.objects.Inventory.ItemFactory;

public class Skeleton extends Friend {

	GameScreen game;

	/**
	 * Creates a skeleton that wants the given item.
	 * It takes its sprite from the gameScreen.
	 * @param game
	 * @param map
	 */
	public Skeleton(GameScreen game, GameMap map) {
		super(map, ItemFactory.newItem("jumper"));
		this.game = game;
		this.sprite = new Sprite(game.getAtlas().findRegion("skeleton"));
		setupAnimation();
	}

	/**
	 * Testing constructor using the given item
	 * 
	 * @param item
	 */
	public Skeleton(Item item) {
		super(item);
	}
	
	private void setupAnimation() {
		stateTimer = 0;
		// setup run animation
		Array<TextureRegion> frames = new Array<TextureRegion>();
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 4; c++) {
				if (r == 2 && c == 4) break; // empty spot in tilesheet
				frames.add(new TextureRegion(sprite.getTexture(), sprite.getRegionX() + c * 32, sprite.getRegionY() + r * 32, 32, 32));
			}
		}
		idleAnimation = new Animation<TextureRegion>(0.1f, frames);
		frames.clear();
	}
}
