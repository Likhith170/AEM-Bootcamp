package com.mysite.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import com.day.cq.dam.api.Asset;

import javax.inject.Inject;

@Model(
        adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ArticleModel {

    @Inject
    private String title;

    @Inject
    private String description;

    @Inject
    private String[] tags;

    @Inject
    private String authorDetails;

    @Inject
    private Asset image;

    @Inject
    private String[] articleTags;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String[] getTags() {
        return tags;
    }

    public String getAuthorDetails() {
        return authorDetails;
    }

    public String getImagePath() {
        if (image != null) {
            return image.getPath();
        }
        return null;
    }

    public String getImageAltText() {
        if (image != null) {
            return image.getMetadataValue("dc:title");
        }
        return null;
    }
    public String[] getArticleTags() {
        return articleTags;
    }

}
