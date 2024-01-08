package com.mysite.core.models;


import java.util.Objects;
import com.day.cq.wcm.api.Page;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;

import org.apache.poi.ss.usermodel.Footer;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

/**
 * Header Model.
 */
@Model(adaptables = Resource.class,
        resourceType = FooterModel.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class FooterModel {
    protected static final String RESOURCE_TYPE = "apps/mysite/components/structure/footer";

    @ValueMapValue(name = "fileReference")
    private String fileReference;

    @ValueMapValue(name = "altText")
    private String altText;

    @ValueMapValue(name = "logoLink")
    private String logoLink;

    @ValueMapValue(name = "footerText")
    private String footerText;


    @ValueMapValue(name = "separatorColor")
    private String separatorColor;

    @ValueMapValue(name = "separatorThickness")
    private int separatorThickness;

    @ValueMapValue(name = "separatorStyle")
    private String separatorStyle;


    @ChildResource(injectionStrategy = InjectionStrategy.DEFAULT)
    private Resource navigations;

    @SlingObject
    private ResourceResolver resourceResolver;

    List<Page> footerNavigationItemsList;

    @PostConstruct
    protected void init() {
        footerNavigationItemsList = new ArrayList<>();
        if (navigations != null) {
            Iterator<Resource> children = navigations.listChildren();
            while (children.hasNext()) {
                Resource childResource = children.next();
                ValueMap properties = childResource.adaptTo(ValueMap.class);
                if(properties != null){
                    String rootPath = properties.get("rootPath", String.class);
                    if (Objects.nonNull(rootPath)) {
                        Resource rootResource = resourceResolver.getResource(rootPath);
                        if (Objects.nonNull(rootResource)){
                            Page navPage = rootResource.adaptTo(Page.class);
                            if (navPage != null) {
                                if (!navPage.isHideInNav()) {
                                    footerNavigationItemsList.add(navPage);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public String getFileReference() {
        return fileReference;
    }

    public String getAltText() {
        return altText;
    }

    public String getLogoLink() {
        return logoLink;
    }

    public List<Page> getFooterNavigationItemsList() {
        return footerNavigationItemsList;
    }

    public String getFooterText() {
        return footerText;
    }

    public String getSeparatorColor() {
        return separatorColor;
    }

    public int getSeparatorThickness() {
        return separatorThickness;
    }

    public String getSeparatorStyle() {
        return separatorStyle;
    }


}
