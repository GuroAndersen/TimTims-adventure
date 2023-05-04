package timtim.app.model.objects.enemy;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import timtim.app.core.GameScreen;
import timtim.app.manager.Const;
import timtim.app.model.objects.CombatEntity;
import timtim.app.model.objects.EnemyType;

public class Enemy extends CombatEntity {

	private EnemyType type;
	private Sprite sprite;
	private Animation<TextureRegion> runAnimation;
	
	private float stateTimer;
	private int switchChance;

	public Enemy(GameScreen game, EnemyType type) {
		super(50, 10);
		this.changeSpeed(2f);
		this.type = type;
		setSprite(game);
		setupAnimation();
	}

	private void setSprite(GameScreen game) {
		switch (type) {
		case BUNNY:
			this.sprite = new Sprite(game.getAtlas().findRegion("bunny"));
			break;
		default:
			throw new IllegalArgumentException("This EnemyType is not represented as sprite in Enemy class: " + type);
		}

	}

	private void setupAnimation() {
		stateTimer = 0;
		Random r = new Random();
		switchChance = (int) (r.nextInt(2,3) * 1/Const.FPS);
		Array<TextureRegion> frames = new Array<TextureRegion>();
		for (int c = 0; c < 4; c++) {
			frames.add(
					new TextureRegion(sprite.getTexture(), sprite.getRegionX() + c * 32, sprite.getRegionY(), 32, 32));
		}
		runAnimation = new Animation<TextureRegion>(0.1f, frames);
		frames.clear();
	}

	@Override
	public void update(float delta) {
		this.stateTimer += delta;
		Random r = new Random();
		if (r.nextInt(switchChance + 1) == switchChance) {
			doRandomXMovement();
		}
		updateSprite(delta);
	}

	private void updateSprite(float delta) {
		float spriteX = (body.getPosition().x * Const.PPM - sprite.getWidth() / 2);
		float spriteY = (body.getPosition().y * Const.PPM - sprite.getHeight() / 2);
		sprite.setBounds(spriteX, spriteY, sprite.getRegionWidth(), sprite.getRegionHeight());
		sprite.setRegion(getFrame(delta));
	}

	private TextureRegion getFrame(float delta) {
		TextureRegion frame = runAnimation.getKeyFrame(stateTimer, true);
		if (this.body.getLinearVelocity().x < 0 && !frame.isFlipX())
			frame.flip(true, false);
		if (this.body.getLinearVelocity().x > 0 && frame.isFlipX())
			frame.flip(true, false);

		return frame;
	}

	@Override
	public void render(SpriteBatch batch) {
		sprite.draw(batch);
	}

}
