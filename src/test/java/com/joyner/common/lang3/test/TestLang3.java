package com.joyner.common.lang3.test;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;
import org.springframework.context.ApplicationListener;

import java.util.Date;

public class TestLang3 {

    @Test
    public void testLang3Demo1() {
        String s = DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss");
        System.out.println(s);
        ApplicationListener listener = null;
    }
}
