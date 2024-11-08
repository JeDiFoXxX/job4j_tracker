package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.passport())).isEqualTo(citizen);
    }

    @Test
    public void whenTestAddMethodIsFalse() {
        Citizen citizen = new Citizen("9uh22", "Donald Trump");
        Citizen citizen1 = new Citizen("9uh22", "Kamala Harris");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.add(citizen1)).isFalse();
    }
}