package com.thetestingacademy.ex_21092024.Assertions.AssertJ;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class Lab035AssertJdate {
    @Test
    public void validatedate(){
        LocalDate date = LocalDate.now();
        System.out.println(date);
        assertThat(date).isAfterOrEqualTo(LocalDate.of(2024,10,05))
                .isBeforeOrEqualTo(LocalDate.of(2024,10,05));

    }
}