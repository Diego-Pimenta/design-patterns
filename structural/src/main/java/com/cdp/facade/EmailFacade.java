package com.cdp.facade;

import com.cdp.facade.email.Email;
import com.cdp.facade.email.Mailer;
import com.cdp.facade.email.Stationary;
import com.cdp.facade.email.StationaryFactory;
import com.cdp.facade.email.Template;
import com.cdp.facade.email.Template.TemplateType;
import com.cdp.facade.email.TemplateFactory;

public class EmailFacade {

    public boolean sendOrderEmail(Order order) {
        Template template = TemplateFactory.createTemplateFor(TemplateType.EMAIL);
        Stationary stationary = StationaryFactory.createStationary();
        Email email = Email.getBuilder()
                .withTemplate(template)
                .withStationary(stationary)
                .forObject(order)
                .build();
        Mailer mailer = Mailer.getMailer();
        return mailer.send(email);
    }
}
