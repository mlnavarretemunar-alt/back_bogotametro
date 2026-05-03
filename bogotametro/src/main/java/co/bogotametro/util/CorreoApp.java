package co.bogotametro.util;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.util.Properties;

public class CorreoApp {
    private String host, port, user, password;

    public CorreoApp() {
        host = "smtp.office365.com";
        port = "587";
        user ="bogotametroapp@outlook.com";
        password = "ltsqcgmjhmxijeuy";
    }
        public void enviarCorreo(String destinatario, String asunto, String mensaje){
            try{
            Properties propiedades = new Properties();
            propiedades.put("mail.smtp.host", host);
            propiedades.put("mail.smtp.port", port);
            propiedades.put("mail.smtp.auth", "true");
            propiedades.put("mail.smtp.starttls.enable", "true");

            Authenticator autenticador = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, password);
                }
            };
                Session sesionCorreo = Session.getInstance(propiedades, autenticador);

                MimeMessage correo = new MimeMessage(sesionCorreo);
                    
                    correo.setFrom(new InternetAddress(user));
                    correo.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
                    correo.setSubject(asunto);
                    correo.setText(mensaje);

                Transport.send(correo);
                }
            catch (Exception e) {
                System.out.println("Error al enviar el correo: " + e.getMessage());


            }

    }
    
}
