/**
 * FileName: FitzSwagger2DocTests
 * Author:   jack.xue
 * Date:     2019/7/10 10:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * jack.xue           2019/7/10           1.0.0              描述
 */
package cn.bw.api;
import cn.bw.api.controller.IndexController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 〈TODO〉<br>
 *
 * @author jack.xue
 * @create 2019/7/10
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@WebMvcTest(IndexController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class FitzSwagger2DocTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")))
                .andDo(document("shouldReturnDefaultMessage"));
    }

    @Test
    public void shouldReturnDefaultMessage2() throws Exception {
        this.mockMvc.perform(get("/hello").param("msg","jack")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("hello")))
                .andDo(document("shouldReturnDefaultMessage2"));
    }

    @Test
    public void shouldReturnDefaultMessage3() throws Exception {
        this.mockMvc.perform(post("/helloP").param("msg","jack")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("hello")))
                .andDo(document("shouldReturnDefaultMessage3"));
    }
}