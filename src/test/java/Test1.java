import com.spring.activemq.controller.ProducerController;
import com.spring.activemq.controller.TestController;
import com.spring.activemq.service.ConsumerService;
import com.spring.activemq.service.ProducerService;
import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by liuhongbing on 2018/10/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class Test1 {
    private MockMvc mvc;
    private MockMvc mvc1;

    @Autowired
    ProducerService service;

    @Autowired
    ConsumerService consumer;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
        mvc1 = MockMvcBuilders.standaloneSetup(new ProducerController()).build();
    }

    @Test
    public void test() throws Exception {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       /* mvc.perform(MockMvcRequestBuilders.post("/test").contentType(MediaType.APPLICATION_JSON).content("19001001").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();*/
        /*
         * 单元测试队列模式
         * */
        /*ActiveMQDestination activeMQDestination = new ActiveMQQueue("myqueue");*/
        service.sendMessage(null, format.format(new Date()));

    }

    @Test
    public void testRec() throws Exception {
       /* mvc.perform(MockMvcRequestBuilders.post("/test").contentType(MediaType.APPLICATION_JSON).content("19001001").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();*/
        ActiveMQDestination activeMQDestination = new ActiveMQQueue("myqueue");
        String abc = consumer.receive(activeMQDestination);

    }

    @Test
    public void test1() throws Exception {
        mvc1.perform(MockMvcRequestBuilders.post("/sen").contentType(MediaType.APPLICATION_JSON).content("19001001").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void test2() throws Exception {
        mvc1.perform(MockMvcRequestBuilders.post("/rec").contentType(MediaType.APPLICATION_JSON).content("19001001").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
