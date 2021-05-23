package com.haristallat2001.reminder_application_haris_tallat;

public class list_data {
    String itemsName;

    public list_data() {
    }

    public list_data(String itemsName) {
        this.itemsName = itemsName;
    }

    public String getItemsName() {
        return itemsName;
    }

    public void setItemsName(String itemsName) {
        this.itemsName = itemsName;
    }

    @Override
    public String toString() {
        return "list_data{" +
                "itemsName='" + itemsName + '\'' +
                '}';
    }
}
