package org.accp.office.util;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * @author XingYu Yi
 * @create 2019-06-01 1:14
 */
public class EmailUtil {
    public static void sendEmail(String content,String email) throws GeneralSecurityException, MessagingException {
        Properties properties = new Properties();
        // 开启debug调试，以便在控制台查看
        properties.setProperty("mail.debug", "true");
        // 设置邮件服务器主机名
        properties.setProperty("mail.host", "smtp.qq.com");
        // 发送服务器需要身份验证
        properties.setProperty("mail.smtp.auth", "true");
        // 发送邮件协议名称
        properties.setProperty("mail.transport.protocol", "smtp");

        // 开启SSL加密，否则会失败
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        // 得到回话对象
        Session session = Session.getInstance(properties);
        // 通过session得到transport对象
        Transport ts = session.getTransport();
        // 连接邮件服务器：邮箱类型，帐号，授权码代替密码（更安全）
        ts.connect("smtp.qq.com","913584762", "llvfzqglwggpbchf");//后面的字符是授权码

        // 创建邮件对象
        MimeMessage message = new MimeMessage(session);
        // 指明邮件的发件人
        message.setFrom(new InternetAddress("913584762@qq.com"));
        // 指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
        // 邮件的标题
        message.setSubject("------投票网消息通知-----");
        // 邮件的文本内容
        message.setContent(content, "text/html;charset=UTF-8");
        //发邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }
}
