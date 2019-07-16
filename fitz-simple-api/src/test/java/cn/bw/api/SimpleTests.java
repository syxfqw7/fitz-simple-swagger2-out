/**
 * FileName: SimpleTests
 * Author:   jack.xue
 * Date:     2019/7/12 16:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * jack.xue           2019/7/12           1.0.0              描述
 */
package cn.bw.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 〈TODO〉<br> 
 *
 * @author jack.xue
 * @create 2019/7/12
 * @since 1.0.0
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleTests {

    @Autowired
    private Environment environment;

    @Test
    public void s1(){
        String name = this.getClass().getPackage().getName();
        String basePackageName = name.substring(0, name.lastIndexOf("."));
        log.info("name: {}",name);
        log.info("basePackageName: {}",basePackageName);

        InetAddress localHost = null;
        try {
            localHost = Inet4Address.getLocalHost();
            log.info("address:{}",localHost.getHostAddress());
        } catch (UnknownHostException e) {
            log.error(e.getMessage(),e);
        }
        log.info("localHost: {}",localHost);
        String applicationName = environment.getProperty("spring.application.name");
        String contextPath = environment.getProperty("server.servlet.context-path");
        String port = environment.getProperty("server.port");
        String localPort = environment.getProperty("local.server.port");
        String active = environment.getProperty("spring.profiles.active");
        String xxx = environment.getProperty("spring.profiles.activexxxxxx");
        log.info("applicationName: {}",applicationName);
        log.info("contextPath: {}",contextPath);
        log.info("port: {}",port);
        log.info("localPort: {}",localPort);
        log.info("active: {}",active);
        log.info("xxx: {}",xxx);
    }

}