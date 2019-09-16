package com.example.demo.service;

public interface MailService {

    void sendSimpleMail(String to ,String subject,String content);

    void sendHtmlMail(String to,String subject,String content) throws Exception;

}
