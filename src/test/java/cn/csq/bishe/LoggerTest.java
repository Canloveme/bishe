package cn.csq.bishe;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName : LoggerTest
 * @Author : CSQ
 * @Date: 2020-03-10 18:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

//    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1() {
//        logger.debug("debug..");
//        logger.info("info..");
//        logger.error("error..");
//        logger.trace("trace..");
//        logger.warn("warn...");

        //如果不写上类名
        //不写    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
        //使用@Slf4j注解代替
        log.debug("debug..");
        log.info("info..");
        log.error("error..");
        log.trace("trace..");
        log.warn("warn...");

        String name = "csq";
        String password = "123456";
        log.info("name: " + name + ", password: " + password);
        log.info("name: {}, password: {}", name, password);



    }
}
