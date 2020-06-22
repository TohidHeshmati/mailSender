package com.task.mailSender;

import org.springframework.beans.factory.annotation.Value;

public class Systemconfig {

    @Value("${number.of.threads.sysconfig}")
    private static int numberOfThreads = 4;

    @Value("${default.message.body.sysconfig}")
    private static String defaultMsgText = "default.message.text";

    @Value("${default.message.subject.sysconfig}")
    private static String defaultMsgSubject = "default.message.subject";

    public static int getNumberOfThreads() {
        return numberOfThreads;
    }

    public static void setNumberOfThreads(int numberOfThreads) {
        Systemconfig.numberOfThreads = numberOfThreads;
    }

    public static String getDefaultMsgText() {
        return defaultMsgText;
    }

    public static void setDefaultMsgText(String defaultMsgText) {
        Systemconfig.defaultMsgText = defaultMsgText;
    }

    public static String getDefaultMsgSubject() {
        return defaultMsgSubject;
    }

    public static void setDefaultMsgSubject(String defaultMsgSubject) {
        Systemconfig.defaultMsgSubject = defaultMsgSubject;
    }
}
