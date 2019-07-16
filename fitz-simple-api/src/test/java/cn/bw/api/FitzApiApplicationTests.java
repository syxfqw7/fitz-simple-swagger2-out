/**
 * FileName: FitzApiApplicationTests
 * Author:   jack.xue
 * Date:     2019/7/12 15:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * jack.xue           2019/7/12           1.0.0              描述
 */
package cn.bw.api;

import cn.bw.api.config.Swagger2Config;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 〈TODO〉<br> 
 *
 * @author jack.xue
 * @create 2019/7/12
 * @since 1.0.0
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
@SpringBootTest(classes = {FitzApiApplication.class, Swagger2Config.class})
@Slf4j
public class FitzApiApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void doBefore(){
        String contextPath = wac.getServletContext().getContextPath();
        log.info("contextPath: {}",contextPath);
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void createSpringfoxSwaggerJson() throws Exception {
        String outputDir = System.getProperty("io.springfox.staticdocs.outputDir");
        MvcResult mvcResult = this.mockMvc.perform(get("/v2/api-docs")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String swaggerJson = response.getContentAsString();
        Files.createDirectories(Paths.get(outputDir));
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputDir, "swagger.json"), StandardCharsets.UTF_8)){
            writer.write(swaggerJson);
        }
        log.info("swaggerJson: {}",swaggerJson);
    }

    @Test
    public void createSpringfoxSwaggerJson2() throws Exception {
        String outputDir = System.getProperty("io.springfox.staticdocs.outputDir");
        MvcResult mvcResult = this.mockMvc.perform(get("/v2/api-docs")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        MvcResult mvcResult2 = this.mockMvc.perform(get("/hello").param("msg","jack")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("hello")))
                .andReturn();
        log.info("mvcResult2: {}",mvcResult2.getResponse().getContentAsString());
        MvcResult mvcResult3 = this.mockMvc.perform(get("http://127.0.0.1:8888/hello").param("msg","jack")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("hello")))
                .andReturn();
        log.info("mvcResult3: {}",mvcResult3.getResponse().getContentAsString());
        MockHttpServletResponse response = mvcResult.getResponse();
        String swaggerJson = response.getContentAsString();
        Files.createDirectories(Paths.get(outputDir));
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputDir, "swagger2.json"), StandardCharsets.UTF_8)){
            writer.write(swaggerJson);
        }
        log.info("swaggerJson: {}",swaggerJson);
    }

}