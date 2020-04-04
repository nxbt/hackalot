package hackalot.game.ref;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class Ref {
	public static class Player {
		public static final int MAX_HEALTH = 3;
		
		public static final int MOVE_SPEED = 6;
		
		public static final float REACH_DISTANCE = 1.5f;
	}

	public static class Key {
		public static final int UP = Input.Keys.W;
		public static final int LEFT = Input.Keys.A;
		public static final int DOWN = Input.Keys.S;
		public static final int RIGHT = Input.Keys.D;

		public static final int INTERACT = Input.Keys.SPACE;
		public static final int CHANGE_ITEM = Input.Keys.E;
	}
	
	public enum Direction {
		CENTER(new Vector2(0, 0)),
		LEFT(new Vector2(-1, 0)),
		RIGHT(new Vector2(1, 0)),
		UP(new Vector2(0, 1)),
		DOWN(new Vector2(0, -1)),
		LEFT_UP(new Vector2(0, -1)),
		LEFT_DOWN(new Vector2(0, 1)),
		RIGHT_UP(new Vector2(1, 0)),
		RIGHT_DOWN(new Vector2(1, 0));
		
		private Vector2 dir;
		
		private Direction(Vector2 dir) {
			this.dir = dir;
		}
		
		public Vector2 getVector2() {
			return dir;
		}
	}
}
