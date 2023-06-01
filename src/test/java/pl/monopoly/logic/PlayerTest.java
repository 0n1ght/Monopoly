package pl.monopoly.logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.mockito.configuration.IMockitoConfiguration;
import pl.monopoly.view.Gameplay;
import pl.monopoly.view.ViewFactory;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;

class PlayerTest {

    @DisplayName("player is moving as much fields as was passed to method")
    @ParameterizedTest
    @MethodSource("fieldProvider")
    void move(int number) {

        //given
        Player player = new Player(null);

        //when
        player.move(number);

        //then
        assertThat(player.getFieldNumber(), equalTo(number));
    }
    public static Stream<Integer> fieldProvider() {
        return Stream.of(1, 15, 27);
    }

}
