package timtim.app.objects.Friend;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import timtim.app.core.GameScreen;
import timtim.app.manager.Const;
import timtim.app.objects.Inventory.Item;
import timtim.app.objects.Inventory.ItemFactory;

public class Skeleton extends Friend {

	GameScreen game;
	Sprite sprite;
	
	Animation<TextureRegion> idleAnimation;
	private int stateTimer;

	/**
	 * Creates a skeleton that wants the given item.
	 * 
	 * @param item
	 */
	public Skeleton(GameScreen game) {
		this.item = ItemFactory.newItem("jumper");
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
		this.item = item;
	}
	
	private void setupAnimation() {
		stateTimer = 0;
		// setup run animation
		Array<TextureRegion> frames = new Array<TextureRegion>();
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 4; c++) {
				if (r == 2 && c == 4) break; // empty spot in tilesheet
				frames.add(new TextureRegion(sprite.getTexture(), c * 32, r * 32, 32, 32));
			}
		}
		idleAnimation = new Animation<TextureRegion>(0.1f, frames);
		frames.clear();
	}
	
	private void updateSprite(float delta) {
		float spriteX = (body.getPosition().x * Const.PPM - sprite.getWidth()/2);
		float spriteY = (body.getPosition().y * Const.PPM - sprite.getHeight()/2);
		sprite.setBounds(spriteX, spriteY, sprite.getRegionWidth(), sprite.getRegionHeight());
		sprite.setRegion(getFrame(delta));

	}

	private TextureRegion getFrame(float delta) {
		// jumping cases
		stateTimer += delta;
		
		TextureRegion frame = idleAnimation.getKeyFrame(stateTimer, true);
		if (this.body.getLinearVelocity().x < 0 && !frame.isFlipX()) frame.flip(true, false);
		if (this.body.getLinearVelocity().x > 0 && frame.isFlipX()) frame.flip(true, false);
		
		return frame;
	}

	@Override
	public void update(float delta) {
		updateSprite(delta);
	}

	@Override
	public void render(SpriteBatch batch) {
		sprite.draw(batch);
	}
}
