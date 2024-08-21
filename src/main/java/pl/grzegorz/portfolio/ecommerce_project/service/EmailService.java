package pl.grzegorz.portfolio.ecommerce_project.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.grzegorz.portfolio.ecommerce_project.api.model.VerificationToken;
import pl.grzegorz.portfolio.ecommerce_project.exception.EmailFailureException;

@Service
public class EmailService {

    @Value("${email.from}")
    private String fromAdderss;

    @Value("${app.frontend.url}")
    private String url;
    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }




    private SimpleMailMessage makeMailMessage(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromAdderss);
        return  simpleMailMessage;
    }


    public void sendVerificationEmail(VerificationToken verificationToken) throws EmailFailureException {
        SimpleMailMessage message = makeMailMessage();
        message.setTo(verificationToken.getLocalUser().getEmail());
        message.setSubject("Verify your email to activate you account");
        message.setText("Please follow the link below to verify your email to activate your account.\n" + url + "/auth/verify?token=" + verificationToken.getToken());


        try{
            javaMailSender.send(message);
        }
        catch(MailException ex){
            throw new EmailFailureException();
        }

    }
}
