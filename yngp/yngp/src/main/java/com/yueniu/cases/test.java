package com.yueniu.cases;


import com.yueniu.common.BaseCase;
import com.yueniu.common.GlobalVariable;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({com.yueniu.config.AssertListener.class})
public class test extends BaseCase {

    @Test()
    public  void mai() {


        String centralToken = GlobalVariable.CENTRAL_TOKEN;
        System.out.println(centralToken);
    }

}
