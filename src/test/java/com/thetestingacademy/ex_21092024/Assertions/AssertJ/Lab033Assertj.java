package com.thetestingacademy.ex_21092024.Assertions.AssertJ;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;
public class Lab033Assertj {
    @Test
    public void Verfication2(){
        String name = "vaishali";
        assertThat(name).isEqualTo("vaishali").isAlphabetic().isNotNull().isNotEmpty();



    }
}
