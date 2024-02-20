package br.com.dbc.vemser.ecososapi.ecosos.service;

import br.com.dbc.vemser.ecososapi.ecosos.config.PropertieReader;
import br.com.dbc.vemser.ecososapi.ecosos.enums.TipoAssuntoEmail;
import br.com.dbc.vemser.ecososapi.ecosos.enums.TipoEmailTemplate;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor

public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;
    private final PropertieReader propertieReader;

//    @Value("${spring.mail.username}")
    private String from;

    private final JavaMailSender emailSender;


    public void enviarEmail(String nomeUsuario, String emailUsuario, TipoAssuntoEmail assunto, TipoEmailTemplate template, Integer... id) throws Exception {
        Integer idValue = (id != null && id.length > 0) ? id[0] : null;
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", nomeUsuario);
        dados.put("email", propertieReader.getSuporteEmail());
        dados.put("img", "cid:SOSLogo");
        if (idValue != null) {
            dados.put("id", idValue);
        }
        enviarEmailComTemplate(emailUsuario, assunto.getAssunto(), template.getTemplate(), dados, "assets/lines_cycle_leaf.jpg");
    }

    public void enviarEmailComTemplate(String emailUsuario, String assunto, String templateName, Map<String, Object> dados, String anexo) throws Exception {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(emailUsuario);
            mimeMessageHelper.setSubject(assunto);

            String content = conteudoTemplate(templateName, dados);
            mimeMessageHelper.setText(content, true);

            if (anexo != null && !anexo.isEmpty()) {
                mimeMessageHelper.addInline("assets/lines_cycle_leaf.jpg", new ClassPathResource(anexo));
            }

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    public String conteudoTemplate(String templateName, Map<String, Object> dados) throws IOException, TemplateException {
        Template template = fmConfiguration.getTemplate(templateName);
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
    }
}
