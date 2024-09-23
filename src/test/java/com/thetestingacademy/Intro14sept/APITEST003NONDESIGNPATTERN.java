package com.thetestingacademy.Intro14sept;

public class APITEST003NONDESIGNPATTERN {

    public void step1 () {
        System.out.println("step1");
        }
        public  void step2() {
            System.out.println("step2");
        }

    public void step3(String params) {
        System.out.println("step3");
    }

    public static void main(String[] args) {
        APITEST003NONDESIGNPATTERN np = new  APITEST003NONDESIGNPATTERN();
        np.step1();
        np.step2();
        np.step3("pramod");

    }
}
