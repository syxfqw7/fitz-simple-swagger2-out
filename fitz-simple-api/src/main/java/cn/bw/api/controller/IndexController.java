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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
public class IndexController {

    @ApiOperation(value="根路径", notes="根路径notes")
    @GetMapping("/")
    public Map<String, String> greeting() {
        return Collections.singletonMap("message", "Hello World");
    }

    @ApiOperation(value="hello中文", notes="hellonotes中文")
    @ApiImplicitParam(name = "msg", value = "信息", required = true, dataType = "String")
    @GetMapping("/hello")
    public String hello(@RequestParam(required =true) String msg) {
        return "hello, " + msg;
    }

    @PostMapping("/helloP")
    public String helloP(String msg) {
        return "hello, " + msg;
    }
}