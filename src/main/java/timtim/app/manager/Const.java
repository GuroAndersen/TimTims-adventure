package timtim.app.manager;

public class Const {

	
	/**
	 * Pixels per meter for Box2D World
	 */
	public static final float PPM = 32.0f;
	
	/**
	 * The refresh rate of this game
	 */
	public static final float FPS = 1/60f;
	
	/**
	 * The gravity of the Box2D world
	 */
	public static final float GRAVITY = -9.81f;

	/**
	 * Jump constant multiplied with mass to get jump force
	 */
	public static final float JUMPCONSTANT = 9f;
}
