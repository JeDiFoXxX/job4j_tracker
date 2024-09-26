package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {
    @Test
    void whenException() {
        Factorial factorial = new Factorial();
        IllegalArgumentException exception = assertThrows(
          IllegalArgumentException.class,
           () -> {
              factorial.calc(-100500);
           }
        );
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }
}