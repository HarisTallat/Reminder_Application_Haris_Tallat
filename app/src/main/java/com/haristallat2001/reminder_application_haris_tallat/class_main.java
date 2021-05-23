package com.haristallat2001.reminder_application_haris_tallat;

public class class_main {
    String list_nam, time,data;

    public class_main() {
    }

    public class_main(String list_nam, String time, String data) {
        this.list_nam = list_nam;
        this.time = time;
        this.data = data;
    }

    public String getList_nam() {
        return list_nam;
    }

    public void setList_nam(String list_nam) {
        this.list_nam = list_nam;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "class_main{" +
                "list_nam='" + list_nam + '\'' +
                ", time='" + time + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
