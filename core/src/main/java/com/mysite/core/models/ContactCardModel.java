package com.mysite.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.inject.Inject;
import java.util.List;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ContactCardModel {

    @SlingObject
    private SlingHttpServletRequest slingRequest;

    @Inject
    @Via("resource")
    private ContactModel contact;

    public SlingHttpServletRequest getSlingRequest() {
        return slingRequest;
    }

    public ContactModel getContact() {
        return contact;
    }
}
