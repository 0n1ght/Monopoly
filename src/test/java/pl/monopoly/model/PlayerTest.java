package pl.monopoly.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class PlayerTest {
    private static final Player player = new Player(null);

    @DisplayName("player is moving as much fields as was passed to method")
    @ParameterizedTest
    @MethodSource("fieldProvider")
    void move(int number) {

        //when
        player.move(number);

        //then
        assertThat(player.getFieldNumber(), equalTo(number));
    }
    static Stream<Integer> fieldProvider() {
        return Stream.of(1, 15, 27);
    }

}
