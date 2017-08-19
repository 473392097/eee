package com.lanou.test;

import com.lanou.action.FirstAction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Created by lanouhn on 17/8/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config.xml")
public class FinddepTest {
    @Autowired
    private FirstAction first;
    @Test
    public void test1(){
        try {
            first.findDepart();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
