package timtim.app.model.objects.friend;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import timtim.app.core.GameScreen;
import timtim.app.manager.Const;
import timtim.app.model.map.GameMap;
import timtim.app.model.objects.inventory.Item;
import timtim.app.model.objects.inventory.ItemFactory;

public class Skeleton extends Friend {

	GameScreen game;

	/**
	 * Creates a skeleton that wants the given item. It takes its sprite from the
	 * gameScreen.
	 * 
	 * @param game
	 * @param map
	 */
	public Skeleton(GameScreen game, GameMap map) {
		super(map, ItemFactory.newItem("jumper"));
		this.game = game;
		this.sprite = new Sprite(game.getAtlas().findRegion("skeleton"));
		this.spriteYOffset = Const.PPM * 0.5f;
		setupAnimation();
	}

	private void setupAnimation() {
		stateTimer = 0;
		// setup run animation
		Array<TextureRegion> frames = new Array<TextureRegion>();
		for (int c = 0; c < 11; c++) {
			frames.add(new TextureRegion(sprite.getTexture(), sprite.getRegionX() + c * 32, sprite.getRegionY(), 32,
					32 * 2));
		}
		idleAnimation = new Animation<TextureRegion>(0.1f, frames);
		frames.clear();
	}

}
