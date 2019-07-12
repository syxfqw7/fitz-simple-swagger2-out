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

/**
 * 〈TODO〉<br> 
 *
 * @author jack.xue
 * @create 2019/7/12
 * @since 1.0.0
 */
@Slf4j
public class SimpleTests {

    @Test
    public void s1(){
        String name = this.getClass().getPackage().getName();
        String basePackageName = name.substring(0, name.lastIndexOf("."));
        log.info("name: {}",name);
        log.info("basePackageName: {}",basePackageName);
    }

}