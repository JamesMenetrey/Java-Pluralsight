package com.boot;


import com.boot.controllers.HomeController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest
{
    @Test
    public void testApp() {
        HomeController hc = new HomeController();
        String result = hc.home();
        assertEquals(result, "Das boot, reporting for duty!");
    }
}
