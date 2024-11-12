package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenComparatorAscByName() {
        int rsl = new JobAscByName().compare(
                new Job("Up", 1),
                new Job("Down", 0));
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorDescByName() {
        int rsl = new JobDescByName().compare(
                new Job("Up", 1),
                new Job("Down", 0));
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorAscByPriority() {
        int rsl = new JobAscByPriority().compare(
                new Job("Up", 1),
                new Job("Down", 0));
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorDescByPriority() {
        int rsl = new JobDescByPriority().compare(
                new Job("Up", 1),
                new Job("Down", 0));
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorAscByNameAndPriority() {
        Comparator<Job> cmpAscNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpAscNamePriority.compare(
                new Job("Up", 1),
                new Job("Up", 0)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorDescByNameAndPriority() {
        Comparator<Job> cmpDescNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpDescNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }
}