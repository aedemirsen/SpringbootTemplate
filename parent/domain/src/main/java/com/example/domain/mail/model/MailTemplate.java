package com.example.domain.mail.model;

public enum MailTemplate {
    WELCOME("mail.subject.welcome",
            "welcome.ftlh"),
    PASSWORD_CHANGE("mail.subject.password_change",
            "password-change.ftlh");

    private final String mailSubjectCode;
    private final String templateName;

    MailTemplate(String mailSubjectCode, String templateName) {
        this.mailSubjectCode = mailSubjectCode;
        this.templateName = templateName;
    }

    public String getMailSubjectCode() {
        return mailSubjectCode;
    }

    public String toString() {
        return templateName;
    }
}
