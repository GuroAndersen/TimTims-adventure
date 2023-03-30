package timtim.app.manager;

public class Const {

	
	/**
	 * Pixels per meter for Box2D World
	 * Value: 32.0f
	 */
	public static final float PPM = 32.0f;
	
	/**
	 * The refresh rate of this game
	 * Value: 1/60f 
	 */
	public static final float FPS = 1/60f;
	
	/**
	 * The gravity of the Box2D world
	 * Value: -9.81f
	 */
	public static final float GRAVITY = -9.81f;

	/**
	 * Jump constant multiplied with mass to get jump force
	 * Value: 9f
	 */
	public static final float JUMPCONSTANT = 9f;
}
