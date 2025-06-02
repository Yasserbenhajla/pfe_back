package com.pfe.projet.Service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    static void sendSimpleMessage(String email, String s, String s1) {
    }

    void sendEmail(SimpleMailMessage email) ;
}