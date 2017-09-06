package util;

import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;


public class MailUtil {
	static final String SMTPHOST = "smtp.qq.com";
	static final String AUTH_PASSWORD="lwlsnhkfvgiiiigh";
	static final String FROM="1219832612@qq.com";//�����ʼ����˺ţ���˾�̶��˺ţ�
	
	public static void sendMail(String to, String subject, String content) {
		Properties props = new Properties();
		props.setProperty("mail.smtp.host", SMTPHOST);// �����ʼ�������
		props.setProperty("mail.transport.protocol", "smtp");// ���÷����ʼ���Э��
		props.setProperty("mail.smtp.auth", "true");// ������֤

		// ������֤��
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM, AUTH_PASSWORD);// �ͻ�����Ȩ����
			}
		};
		// qq���俪��ssl��֤
		MailSSLSocketFactory sf = null;
		try {
			sf = new MailSSLSocketFactory();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sf.setTrustAllHosts(true);
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.socketFactory", sf);
		
		// �����ʼ��������Ự��---Session
		Session session = Session.getDefaultInstance(props, auth);
		// 2������һ���ʼ���---MimeMessage
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(FROM));
			message.setSubject(subject);
			message.setSentDate(new Date());// ���÷������ڣ�
			message.setContent(content, "text/html;charset=utf-8");
			// �����ռ���
			message.setRecipient(MimeMessage.RecipientType.TO,
					new InternetAddress(to));// ����
			// 3�������ʼ� -- Transport
			Transport transport = session.getTransport();
			transport.connect(FROM, AUTH_PASSWORD);// ͨ����Ȩ���Է����˺��������
			transport.sendMessage(message, message.getAllRecipients());// �����ʼ�
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

