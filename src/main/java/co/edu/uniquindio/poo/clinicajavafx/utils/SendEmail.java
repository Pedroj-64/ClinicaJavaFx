package co.edu.uniquindio.poo.clinicajavafx.utils;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

public class SendEmail {

    public static void enviarNotificacion(String receiver, String subject, String message) {

        Email email = EmailBuilder.startingBlank()
                .from("SU_EMAIL")
                .to(receiver)
                .withSubject(subject)
                .withPlainText(message)
                .buildEmail();

        try (Mailer mailer = MailerBuilder
                .withSMTPServer("smtp.gmail.com", 587, "tucarrouq@gmail.com", "fxcx rvac wwuj xtdo")
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .withDebugLogging(true)
                .buildMailer()) {

            mailer.sendMail(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
