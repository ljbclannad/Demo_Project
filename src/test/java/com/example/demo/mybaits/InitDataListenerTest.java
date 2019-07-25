package com.example.demo.mybaits;

import com.example.demo.mybaits.initdata.InitDataListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author ：lejb
 * @date ：Created in 2019/6/5 10:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InitDataListenerTest {

    @Test
    public void coreMessageTest(){
        System.out.println(InitDataListener.messageMap);
    }

}
