package com.cdp.facade.email;

public abstract class Template {

    public abstract String format(Object obj);

    public enum TemplateType {EMAIL, NEWSLETTER}
}
