package com.eugeniomoreira.nossobancodigital.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration("swaggerConfigProperties")
@Profile("!test")
@ConfigurationProperties("application.swagger")
public class SwaggerConfigProperties {

    private String apiVersion;

    private String enabled = "true";

    private String title;

    private String description;

    private String basePackage;

    private String useDefaultResponseMessages;

    private String enableUrlTemplating;

    private String deepLinking;

    private String defaultModelsExpandDepth;

    private String defaultModelExpandDepth;

    private String displayOperationId;

    private String displayRequestDuration;

    private String filter;

    private String maxDisplayedTags;

    private String showExtensions;

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getUseDefaultResponseMessages() {
        return useDefaultResponseMessages;
    }

    public void setUseDefaultResponseMessages(String useDefaultResponseMessages) {
        this.useDefaultResponseMessages = useDefaultResponseMessages;
    }

    public String getEnableUrlTemplating() {
        return enableUrlTemplating;
    }

    public void setEnableUrlTemplating(String enableUrlTemplating) {
        this.enableUrlTemplating = enableUrlTemplating;
    }

    public String getDeepLinking() {
        return deepLinking;
    }

    public void setDeepLinking(String deepLinking) {
        this.deepLinking = deepLinking;
    }

    public String getDefaultModelsExpandDepth() {
        return defaultModelsExpandDepth;
    }

    public void setDefaultModelsExpandDepth(String defaultModelsExpandDepth) {
        this.defaultModelsExpandDepth = defaultModelsExpandDepth;
    }

    public String getDefaultModelExpandDepth() {
        return defaultModelExpandDepth;
    }

    public void setDefaultModelExpandDepth(String defaultModelExpandDepth) {
        this.defaultModelExpandDepth = defaultModelExpandDepth;
    }

    public String getDisplayOperationId() {
        return displayOperationId;
    }

    public void setDisplayOperationId(String displayOperationId) {
        this.displayOperationId = displayOperationId;
    }

    public String getDisplayRequestDuration() {
        return displayRequestDuration;
    }

    public void setDisplayRequestDuration(String displayRequestDuration) {
        this.displayRequestDuration = displayRequestDuration;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getMaxDisplayedTags() {
        return maxDisplayedTags;
    }

    public void setMaxDisplayedTags(String maxDisplayedTags) {
        this.maxDisplayedTags = maxDisplayedTags;
    }

    public String getShowExtensions() {
        return showExtensions;
    }

    public void setShowExtensions(String showExtensions) {
        this.showExtensions = showExtensions;
    }

}
