package rop.miu.util.mail;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailSender {
	public final static String 
		USER_KEY = "mail.session.user",
		PASSWORD_KEY = "mail.session.pass",
		HOST_KEY = "mail.smtp.host",
		SOCKET_PORT_KEY = "mail.smtp.socketFactory.port",
		SOCKET_CLASS_KEY = "mail.smtp.socketFactory.class",
		AUTH_KEY = "mail.smtp.auth",
		PORT_KEY = "mail.smtp.port",
		STARTTLS_KEY = "mail.smtp.starttls.enable",
		
		SMTP_TRANSPORT = "smtp";
	
	public static Properties smtpBundleToProperties (SMTPBundle smtpBundle) {
		Properties props = new Properties();
		props.put(USER_KEY, smtpBundle.getUser());
		props.put(PASSWORD_KEY, smtpBundle.getPassword());
		props.put(HOST_KEY, smtpBundle.getHost());
		props.put(SOCKET_PORT_KEY, smtpBundle.getSocketPort());
		props.put(SOCKET_CLASS_KEY, smtpBundle.getSocketClass());
		props.put(AUTH_KEY, smtpBundle.getAuth());
		props.put(PORT_KEY, smtpBundle.getPort());
		props.put(STARTTLS_KEY, smtpBundle.getStarttls());
		return props;
	}

	public static void sendMail (Mail mail, Properties smtpBundle) throws AddressException, MessagingException {
		//Création du corps du paquet à envoyer
		MimeMultipart mimeMultipart = new MimeMultipart();
		
		//Ajout d'un bloc texte dans le paquet (contenu textuel du mail)
		MimeBodyPart contentMessage = new MimeBodyPart();
        contentMessage.setContent(mail.getContent(), mail.getContentType());
		mimeMultipart.addBodyPart(contentMessage);
		
		//Ajout des blocs multimédia dans le paquet (pièces jointes)
		File file;
		FileDataSource datasource;
		DataHandler handler;
		MimeBodyPart fileToSend;
		for(String attachment : mail.getAttachment()){
			file = new File(attachment);
			datasource = new FileDataSource(file);
			handler = new DataHandler(datasource);
			fileToSend = new MimeBodyPart();
			fileToSend.setDataHandler(handler);
	        fileToSend.setFileName(datasource.getName());
	        mimeMultipart.addBodyPart(fileToSend);
		}

		Session session = Session.getDefaultInstance(
			smtpBundle,
            new Authenticator(smtpBundle.get(USER_KEY).toString(), smtpBundle.get(PASSWORD_KEY).toString())
        );
		
		Message message = new MimeMessage(session);
		message.setContent(mimeMultipart);
        message.setSubject(mail.getSubject());
		
        for(String receiver : mail.getToReceiver()){
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));
		}
        for(String receiver : mail.getBccReceiver()){
			message.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(receiver));
		}
        for(String receiver : mail.getCcReceiver()){
			message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(receiver));
		}
		
		Transport transport = session.getTransport(SMTP_TRANSPORT);
        transport.connect(smtpBundle.get(HOST_KEY).toString(), smtpBundle.get(USER_KEY).toString(), smtpBundle.get(PASSWORD_KEY).toString());
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
	}
	
	public static class Authenticator extends javax.mail.Authenticator{
		private String user;
		private String password;
		
		public Authenticator(String user, String password) {
			super();
			this.user = user;
			this.password = password;
		}

		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(user, password);
		}
	}
}
