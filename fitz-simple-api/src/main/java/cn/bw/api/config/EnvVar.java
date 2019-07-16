/**
 * FileName: EnvVar
 * Author:   jack.xue
 * Date:     2019/7/15 14:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * jack.xue           2019/7/15           1.0.0              描述
 */
package cn.bw.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 〈TODO〉<br> 
 *
 * @author jack.xue
 * @create 2019/7/15
 * @since 1.0.0
 */
@Component
public class EnvVar{

    @Autowired
    private Environment environment;

    public String getString(String key){
        return environment.getProperty(key);
    }

    public String getString(String key, String defaultValue){
        return environment.getProperty(key, defaultValue);
    }

}