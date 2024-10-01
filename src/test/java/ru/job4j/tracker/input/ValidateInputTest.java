package ru.job4j.tracker.input;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {
    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[]{"one", "1"}
        );
        ValidateInput validateInput = new ValidateInput(output, input);
        int selected = validateInput.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[]{"6"}
        );
        ValidateInput validateInput = new ValidateInput(output, input);
        int selected = validateInput.askInt("Enter menu:");
        assertThat(selected).isEqualTo(6);
    }

    @Test
    void whenMultipleValidInput() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[]{"1", "2", "3"}
        );
        ValidateInput validateInput = new ValidateInput(output, input);
        int selectedOne = validateInput.askInt("Enter menu:");
        assertThat(selectedOne).isEqualTo(1);
        int selectedTwo = validateInput.askInt("Enter menu:");
        assertThat(selectedTwo).isEqualTo(2);
        int selectedThree = validateInput.askInt("Enter menu:");
        assertThat(selectedThree).isEqualTo(3);
    }

    @Test
    void whenNegativeValidInput() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[]{"-1"}
        );
        ValidateInput validateInput = new ValidateInput(output, input);
        int selected = validateInput.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}