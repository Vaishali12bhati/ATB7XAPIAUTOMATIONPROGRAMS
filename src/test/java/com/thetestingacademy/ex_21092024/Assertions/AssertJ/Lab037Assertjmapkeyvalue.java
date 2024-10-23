package com.thetestingacademy.ex_21092024.Assertions.AssertJ;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class Lab037Assertjmapkeyvalue {
    @Test
    public void keyvalueverfiy(){
        Map<String,Integer>ages = new HashMap<>();
        ages.put("john",32);
        ages.put("vaishali",31);
        ages.put("manav",30);

        assertThat(ages).hasSize(3).doesNotContainEntry("vishali",32);
    }

}
