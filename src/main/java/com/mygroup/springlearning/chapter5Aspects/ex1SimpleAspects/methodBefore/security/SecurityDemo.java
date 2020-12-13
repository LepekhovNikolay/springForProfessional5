package com.mygroup.springlearning.chapter5Aspects.ex1SimpleAspects.methodBefore.security;

import com.mygroup.springlearning.chapter5Aspects.service.Helper;

public class SecurityDemo {
    public static void main(String[] args) {
        SecurityManager manager = new SecurityManager();

        SecureBean bean = Helper.getProxy(new SecureBean(), new SecurityAdvice());

        manager.login("John", "pwd");
        bean.writeSecureMessage();
        manager.logout();

        try {
            manager.login("invalid user", "pwsd");
            bean.writeSecureMessage();
        } catch (SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        } finally {
            manager.logout();
        }

        try {
            bean.writeSecureMessage();
        } catch (SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        }
    }
}
