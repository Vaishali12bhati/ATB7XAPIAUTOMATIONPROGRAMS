package com.thetestingacademy.ex_14092024.Intro14sept;

public class APITEST004BUILDERPATTERN {
//CHANGE THE RETURN TYPE OF EACH CLASS AS A CLASS TYPE
    //"this" always point to current /calling object
    //have the same refrence

    public APITEST004BUILDERPATTERN Floor1(){
        System.out.println("stage 1 done");
        return this;

    }
    public  APITEST004BUILDERPATTERN Floor2(String params){
        System.out.println("stage2");
        return  this;

    }
    public  APITEST004BUILDERPATTERN Floor3(){
        System.out.println("stage3");
        return  this;
    }

    public static void main(String[] args) {
        APITEST004BUILDERPATTERN bp = new APITEST004BUILDERPATTERN();
        bp.Floor1().Floor2("vaishalli").Floor3();
        System.out.println(bp);
    }
}
