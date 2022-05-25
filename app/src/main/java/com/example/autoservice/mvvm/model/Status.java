package com.example.autoservice.mvvm.model;

public enum Status {
    PROCESSING("Обрабатывается"),
    WORKING("В работе"),
    DONE("Сделан"),
    CLOSED("Закрыт"),
    CANCELED("Отменён");

    private String title;

    Status(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
