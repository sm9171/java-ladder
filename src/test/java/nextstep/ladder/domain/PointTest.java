package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {
	@DisplayName("왼쪽으로 이동")
	@Test
	void goLeft() {
		// given
		Point point = new Point(true, false);
		// when
		Direction direction = point.move();
		// then
		assertThat(direction).isEqualTo(Direction.LEFT);
	}

	@DisplayName("오른쪽으로 이동")
	@Test
	void goRight() {
		// given
		Point point = new Point(false, true);
		// when
		Direction direction = point.move();
		// then
		assertThat(direction).isEqualTo(Direction.RIGHT);
	}

	@DisplayName("밑으로 이동")
	@Test
	void goDown() {
		// given
		Point point = new Point(false, false);
		// when
		Direction direction = point.move();
		// then
		assertThat(direction).isEqualTo(Direction.DOWN);
	}

	@DisplayName("현재와 왼쪽이 true일 때 예외 발생")
	@Test
	void invalidPoint() {
		// given&when&then
		assertThatThrownBy(() -> {
			new Point(true, true);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("상태값이 유효하지 않습니다.");
	}

	@DisplayName("왼쪽끝에 있을때 오른쪽으로 이동")
	@Test
	void goRightWithFirstPoint() {
		// given
		Point point = Point.first(true);
		// when
		Direction direction = point.move();
		// then
		assertThat(direction).isEqualTo(Direction.RIGHT);
	}

	@DisplayName("왼쪽끝에 있을때 오른쪽으로 이동")
	@Test
	void goDownWithFirstPoint() {
		// given
		Point point = Point.first(false);
		// when
		Direction direction = point.move();
		// then
		assertThat(direction).isEqualTo(Direction.DOWN);
	}

	@DisplayName("오른쪽끝에 있을때 왼쪽으로 이동")
	@Test
	void goLeftWithLastPoint() {
		// given
		Point point = Point.last(true);
		// when
		Direction direction = point.move();
		// then
		assertThat(direction).isEqualTo(Direction.LEFT);
	}

	@DisplayName("오른쪽끝에 있을때 밑으로 이동")
	@Test
	void goDownWithLastPoint() {
		// given
		Point point = Point.last(false);
		// when
		Direction direction = point.move();
		// then
		assertThat(direction).isEqualTo(Direction.DOWN);
	}
}
