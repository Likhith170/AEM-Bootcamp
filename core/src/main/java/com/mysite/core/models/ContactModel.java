package com.mysite.core.models;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ContactModel {

    @Inject
    private String contactName;

    @Inject
    private String contactEmail;

    public String getContactName() {
        return contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }
}
