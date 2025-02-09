package nextstep.ladder.domain;

public class Point {
	private final boolean left;
	private final boolean current;

	public Point(boolean left, boolean current) {
		if (left && current) {
			throw new IllegalArgumentException("상태값이 유효하지 않습니다.");
		}
		this.left = left;
		this.current = current;
	}

	public static Point first(final boolean current) {
		return new Point(false, current);
	}

	public static Point last(final boolean left) {
		return new Point(left, false);
	}

	public Direction move() {
		if (current) {
			return Direction.RIGHT;
		}

		if (left) {
			return Direction.LEFT;
		}

		return Direction.DOWN;
	}
}
