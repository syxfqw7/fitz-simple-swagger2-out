/**
 * FileName: Swagger2Config
 * Author:   jack.xue
 * Date:     2019/7/10 14:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * jack.xue           2019/7/10           1.0.0              描述
 */
package cn.bw.api.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 〈TODO〉<br> 
 *
 * @author jack.xue
 * @create 2019/7/10
 * @since 1.0.0
 */
@Configuration
@EnableSwagger2
@Slf4j
public class Swagger2Config {

    @Autowired
    private EnvVar envVar;

    @Bean
    public Docket createRestApi() {
        String pName = this.getClass().getPackage().getName();
        String basePackageName = pName.substring(0, pName.lastIndexOf("."));
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackageName))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        InetAddress localHost = null;
        String ip = "";
        try {
            localHost = Inet4Address.getLocalHost();
            ip = localHost.getHostAddress();
        } catch (UnknownHostException e) {
            log.error(e.getMessage(),e);
        }
        String applicationName = envVar.getString("spring.application.name");
        String contextPath = envVar.getString("server.servlet.context-path");
        String port = envVar.getString("server.port");
        if("-1".equals(port)){
            port = "8888";
        }
        return new ApiInfoBuilder()
                .title(applicationName)
                .description("swagger2离线文档示例")
                .termsOfServiceUrl("http://"+ip+":" + port + contextPath+"/swagger-ui.html")
                .version(envVar.getString("maven.project.version"))
                .build();
    }

}