package christmas;

import christmas.model.InputService;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class InputTest {

    @Test
    void testChangeStringToListMenu(){
        String input = "파스타-1";
        InputService inputService = new InputService();
        assertEquals(inputService.changeStringToListMenu(input), List.of(input));
    }

}
