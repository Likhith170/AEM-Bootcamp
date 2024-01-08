// src/main/java/com/yourproject/models/BreadcrumbModel.java
package com.mysite.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import javax.inject.Inject;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BreadcrumbModel {

    @Inject
    private String homepageUrl;

    @Inject
    private List<BreadcrumbItem> items;

    public String getHomepageUrl() {
        return homepageUrl;
    }

    public List<BreadcrumbItem> getItems() {
        return items;
    }

    @Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
    public static class BreadcrumbItem {

        @Inject
        private String title;

        @Inject
        private String url;

        @Inject
        private boolean hideInNav;

        public String getTitle() {
            return title;
        }

        public String getUrl() {
            return url;
        }

        public boolean isHideInNav() {
            return hideInNav;
        }
    }
}

