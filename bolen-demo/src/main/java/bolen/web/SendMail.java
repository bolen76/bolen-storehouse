package bolen.web;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.junit.Test;

public class SendMail {

	@Test
	public void fun1() throws Exception {
		/*
		 * 1. 得到session
		 */
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.smtp.auth", "true");

		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("zhangzhoujun76", "******");
			}
		};

		Session session = Session.getInstance(props, auth);

		/*
		 * 2. 创建MimeMessage
		 */
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("zhangzhoujun76@163.com"));// 设置发件人
		msg.setRecipients(RecipientType.TO, "1660868932@qq.com");// 设置收件人
		/*msg.setRecipients(RecipientType.CC, "itcast_cxf@sohu.com");// 设置抄送
		msg.setRecipients(RecipientType.BCC, "itcast_cxf@sina.com");// 设置暗送
*/
		msg.setSubject("这是来自ITCAST的测试邮件");
		msg.setContent("这就是一封垃圾邮件！", "text/html;charset=utf-8");

		/*
		 * 3. 发
		 */
		Transport.send(msg);
	}

	/**
	 * 带有附件的邮件！！！
	 */
	@Test
	public void fun2() throws Exception {
		/*
		 * 1. 得到session
		 */
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.smtp.auth", "true");

		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("zhangzhoujun76", "******");
			}
		};

		Session session = Session.getInstance(props, auth);

		/*
		 * 2. 创建MimeMessage
		 */
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("zhangzhoujun76@163.com"));// 设置发件人
		msg.setRecipients(RecipientType.TO, "1660868932@qq.com");// 设置收件人

		msg.setSubject("这是来自java mail的测试邮件有附件");

		// //////////////////////////////////////////////////////
		/*
		 * 当发送包含附件的邮件时，邮件体就为多部件形式！ 1. 创建一个多部件的部件内容！MimeMultipart
		 * MimeMultipart就是一个集合，用来装载多个主体部件！ 2. 我们需要创建两个主体部件，一个是文本内容的，另一个是附件的。
		 * 主体部件叫MimeBodyPart 3. 把MimeMultipart设置给MimeMessage的内容！
		 */
		MimeMultipart list = new MimeMultipart();// 创建多部分内容

		// 创建MimeBodyPart
		MimeBodyPart part1 = new MimeBodyPart();
		// 设置主体部件的内容
		part1.setContent("这是一封包含附件的垃圾邮件", "text/html;charset=utf-8");
		// 把主体部件添加到集合中
		list.addBodyPart(part1);

		// 创建MimeBodyPart
		MimeBodyPart part2 = new MimeBodyPart();
		part2.attachFile(new File("E:/deepin-DzVista.jpg"));// 设置附件的内容
		part2.setFileName(MimeUtility.encodeText("大美女.jpg"));// 设置显示的文件名称，其中encodeText用来处理中文乱码问题
		list.addBodyPart(part2);

		msg.setContent(list);// 把它设置给邮件作为邮件的内容。

		// //////////////////////////////////////////////////////

		/*
		 * 3. 发
		 */
		Transport.send(msg);
	}


}
