package com.example.demo;

import com.example.demo.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Value("${spring.mail.username}")
    private String username;


    @Autowired
    private MailService mailService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void mailSenderTest() throws Exception{
        mailService.sendSimpleMail(username,"test simple11111 mail","hello this is simpl1111e mail,你好");
    }

    @Test
    public void htmlSenderTest() throws Exception{
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail(username,"test simple mail",content);
    }

    @Test
    public void StringCaseTest(){
        String s = "ASDF";
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());
    }


}
