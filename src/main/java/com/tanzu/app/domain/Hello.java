package com.tanzu.app.domain;

// Use records when available !
public class Hello {

    private Choice a;

    private Choice b;

    public Hello(Choice a, Choice b) {
        this.a = a;
        this.b = b;
    }

    public Choice getA() {
        return a;
    }

    public Choice getB() {
        return b;
    }
}
