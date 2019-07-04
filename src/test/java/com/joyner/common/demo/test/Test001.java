package com.joyner.common.demo.test;

import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.annotation.Resource;
import java.util.Arrays;

public class Test001 {

    public static void main(String[] args) {
        Object[] params = new Object[3];
        params[0] = "32";
        params[1] = "3fdfd";
        params[2] = 2;
        params = new Object[0];

        String s = Arrays.deepToString(params);
        System.out.println(s);


    }
}
