/**
 * FileName: IndexController
 * Author:   jack.xue
 * Date:     2019/7/10 10:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * jack.xue           2019/7/10           1.0.0              描述
 */
package cn.bw.api.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;
import java.util.Map;

/**
 * 〈TODO〉<br> 
 *
 * @author jack.xue
 * @create 2019/7/10
 * @since 1.0.0
 */
@RestController
@Api(value = "/", tags = "index", description = "Operations about index")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "查询成功"),
        @ApiResponse(code = 404, message = "查询失败")
})
public class IndexController {

    @Autowired
    private Environment environment;

    @Autowired
    private WebApplicationContext wac;

    @ApiOperation(value="根路径", notes="根路径notes")
    @GetMapping("/")
    public Map<String, String> greeting() {
        return Collections.singletonMap("message", "Hello World");
    }

    @ApiOperation(value="根据msg查询文章内容", notes="根据msg关键字查询文章内容,模糊查询")
    @ApiImplicitParam(name = "msg", value = "信息", required = true, dataType = "String")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "查询成功"),
            @ApiResponse(code = 404, message = "查询失败")
    })
    @GetMapping("/hello")
    public String hello(@RequestParam(required =true) String msg) {
        String port = environment.getProperty("server.port");
        String contextPath = wac.getServletContext().getContextPath();
        return "hello, " + msg + ",port: " +port + ",contextPath: "+contextPath;
    }

    @PostMapping("/helloP")
    public String helloP(String msg) {
        return "hello, " + msg;
    }
}