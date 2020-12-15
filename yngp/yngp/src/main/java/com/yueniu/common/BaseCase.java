package com.yueniu.common;

import com.yueniu.YngpApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;


@SpringBootTest(classes = YngpApplication.class)
@WebAppConfiguration
public class BaseCase extends AbstractTestNGSpringContextTests {

    public BaseCase(){}

}
