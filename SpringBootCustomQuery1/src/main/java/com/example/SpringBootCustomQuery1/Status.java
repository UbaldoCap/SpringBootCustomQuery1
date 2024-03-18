package com.example.SpringBootCustomQuery1;

public enum Status {
    ONTIME("on time"),
    DELAYED("delayed"),
    CANCELLED("cancelled");

    private final String string;

    Status(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
