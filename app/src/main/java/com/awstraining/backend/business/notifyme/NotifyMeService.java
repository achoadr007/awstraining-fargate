package com.awstraining.backend.business.notifyme;

import com.amazonaws.services.translate.AmazonTranslate;
import com.amazonaws.services.translate.model.TranslateTextRequest;
import com.amazonaws.services.translate.model.TranslateTextResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotifyMeService {

    private MessageSender messageSender;

    private Translator amazonTranslate;

    private Sentiment sentiment;
    // TODO: lab1
    //  1. Inject MessageSender.
    // TODO lab2
    //  1. Inject Translator
    // TODO lab3
    //  1. Inject sentiment detector
    @Autowired
    public NotifyMeService(MessageSender messageSender, Translator amazonTranslate, Sentiment sentiment) {
        this.messageSender = messageSender;
        this.amazonTranslate = amazonTranslate;
        this.sentiment = sentiment;

    }
    
    public String notifyMe(NotifyMeDO notifyMe) {

        String text = notifyMe.text();
        messageSender.send(text);

        String resualt = amazonTranslate.translate(notifyMe);

        String resulatSent = sentiment.detectSentiment(notifyMe.targetLc(), resualt);


//        TranslateTextRequest translateTextRequest = new TranslateTextRequest();
//        translateTextRequest.setText(text);
//        TranslateTextResult result = amazonTranslate.translateText(translateTextRequest);
        // TODO: lab1
        //  1. Send text using sender.
        //  2. Return sent message.
        // TODO: lab2
        //  1. Translate text from using translator.
        //  2. Change sending of text to "translated text" and return it.
        // TODO: lab3
        //  1. Detect sentiment of translated message.
        //  2. Change sending of text to "setiment: translated text" and return it.
        return "translated text: " + resualt + " and setiment: " + resulatSent;
    }
    
}
