package Persons;

public class Agenda {
    static String name;
    public static String getname(){
        return name;
    }
    static String phone;
    public static String getphone(){
        return phone;
    }
    static String job;
    public static String getjob(){
        return job;
    }
    Agenda() {}
    Agenda(String name, String phone, String job) {
        this.name = name;
        this.job = job;
        this.phone = phone;
    }
}
