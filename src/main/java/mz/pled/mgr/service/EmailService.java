package mz.pled.mgr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SpringTemplateEngine template;

    public void enviarEmail(String descricao, String nome,String destino, String assunto) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, "UTF-8");

        Context context = new Context();
        context.setVariable("titulo", "Bem vindo a PLED");
        context.setVariable("texto", descricao);
        context.setVariable("nome",nome);

        String html = template.process("email/noteemail", context);
        helper.setTo(destino);
        helper.setText(html, true);
        helper.setSubject(assunto);
        helper.setFrom("pled.mgr@gmail.com");

        helper.addInline("logo", new ClassPathResource("/static/img/Emblem_of_Mozambique.svg.png"));

        mailSender.send(message);
    }

}
