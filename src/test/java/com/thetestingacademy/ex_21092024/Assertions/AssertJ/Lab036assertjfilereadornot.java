package com.thetestingacademy.ex_21092024.Assertions.AssertJ;
import static org.assertj.core.api.Assertions.*;
import org.testng.annotations.Test;

import java.io.File;

public class Lab036assertjfilereadornot {
    @Test
    public void Verify_file(){
        File file = new File("testdata,json");
        assertThat(file).exists().canRead().canWrite();
    }
}
