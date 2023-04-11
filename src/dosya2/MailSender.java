import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
    
        void mail(String email){
        String from = "fatihaltuntas0@outlook.com"; // gönderen e-posta adresi
        String host = "smtp.outlook.com"; // e-posta sunucusu adresi
        String username = "fatihaltuntas0@outlook.com"; // gönderen e-posta adresi kullanıcı adı
        String password = "F@tih1103"; // gönderen e-posta adresi şifresi
        
        // e-posta ayarları
        Properties properties = System.getProperties();
        properties.put("mail.smtp.starttls.enable", "true"); // TLS bağlantı açılır
        properties.put("mail.smtp.host", host); // e-posta sunucusu ayarlanır
        properties.put("mail.smtp.user", username); // kullanıcı adı ayarlanır
        properties.put("mail.smtp.password", password); // şifre ayarlanır
        properties.put("mail.smtp.port", "587"); // TLS portu ayarlanır
        
        // e-posta oturumu oluşturulur
        Session session = Session.getDefaultInstance(properties);
        
        try {
            // e-posta oluşturulur
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Deneme 1"); //Başlık
            message.setText("Merhaba, Java programlama dili kullanarak e-posta gönderiyorum."); //Mesaj kısmı
            
            // e-posta gönderilir
            Transport transport = session.getTransport("smtp");
            transport.connect(host, username, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            
            System.out.println("E-posta başarıyla gönderildi.");
        } catch (Exception ex) {
            System.out.println("E-posta gönderilirken bir hata oluştu: " + ex.getMessage());
        }
    }
  }

