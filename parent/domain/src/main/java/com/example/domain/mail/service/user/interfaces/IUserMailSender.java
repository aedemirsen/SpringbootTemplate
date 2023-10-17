package com.example.domain.mail.service.user.interfaces;

import com.example.domain.entity.user.User;

public interface IUserMailSender {

    void sendWelcomeMail(User user, boolean sendPasswordMail);


    void sendPasswordChangeMail(User user);

}

