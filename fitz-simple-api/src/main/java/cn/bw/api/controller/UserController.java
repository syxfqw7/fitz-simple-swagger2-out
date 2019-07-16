/**
 * FileName: UserController
 * Author:   jack.xue
 * Date:     2019/7/15 10:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * jack.xue           2019/7/15           1.0.0              描述
 */
package cn.bw.api.controller;

import cn.bw.api.model.UserModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 〈TODO〉<br>
 *
 * @author jack.xue
 * @create 2019/7/15
 * @since 1.0.0
 */
@RestController
@Api(value = "用户信息查询", description = "用户基本信息操作API", tags = "用户API"
    , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @ApiOperation(value = "/getUser", notes = "根据姓名查询用户信息")
    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    @ResponseBody
    public UserModel getUser(@RequestParam("name") String name){
        UserModel user = new UserModel();
        user.setIdNum(123456L);
        user.setName(name);
        user.setAge(25);
        user.setAddress("河南郑州");
        user.setSex("男");
        return user;
    }


    @ApiOperation(value = "/addUser", notes = "添加一个用户")
    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    @ResponseBody
    public UserModel addUser(@RequestBody UserModel user){
        return user;
    }

    @ApiOperation(value = "/delUser", notes = "删除一个用户")
    @ApiImplicitParam(name = "id", value = "身份编码",example = "1", required = true, dataType = "Long")
    @RequestMapping(value = "delUser", method = RequestMethod.POST)
    @ResponseBody
    public String delUser(@RequestParam("id") Long id){
        return id + ", has been deleted";
    }
}