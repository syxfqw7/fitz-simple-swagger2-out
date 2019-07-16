/**
 * FileName: UserModel
 * Author:   jack.xue
 * Date:     2019/7/15 10:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * jack.xue           2019/7/15           1.0.0              描述
 */
package cn.bw.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 〈TODO〉<br> 
 *
 * @author jack.xue
 * @create 2019/7/15
 * @since 1.0.0
 */
@Data
@ApiModel(value = "UserModel", description = "用户信息描述")
public class UserModel {

    @ApiModelProperty(name ="证件号码", example = "321323")
    private Long idNum;

    @ApiModelProperty(name = "姓名name", value = "姓名value", notes = "姓名notes")
    private String name;

    @ApiModelProperty(value = "年龄", example = "1")
    private int age;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("家庭住址")
    private String address;

}