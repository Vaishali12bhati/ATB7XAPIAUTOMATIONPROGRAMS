package com.thetestingacademy.ex_21092024.Assertions.AssertJ;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class Lab034Assertlistarrayex {
    @Test

    public void listarray(){
        List<String>names = Arrays.asList("john","priyanka","vaishali");
        assertThat(names).hasSize(3).isNotNull().containsExactlyInAnyOrder("vaishali","john","priyanka");

    }
}
