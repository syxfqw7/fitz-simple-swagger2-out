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

/**
 * 〈TODO〉<br> 
 *
 * @author jack.xue
 * @create 2019/7/10
 * @since 1.0.0
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Autowired
    private Environment environment;

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
        String applicationName = environment.getProperty("spring.application.name");
        return new ApiInfoBuilder()
                .title(applicationName)
                .description("fitz swagger2 for demo")
                .termsOfServiceUrl("http://localhost:8080/swagger-ui.html")
                .version(environment.getProperty("maven.project.version"))
                .build();
    }

}