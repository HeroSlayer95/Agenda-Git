package Persons;

import java.util.Scanner;

public class Main {
    static Agenda[] agenda_array = new Agenda[10];
    public static void main(String[] args) {
        Scanner temp = new Scanner(System.in);
        int option;
        do {
            menu();
            Scanner test = new Scanner(System.in);
            option = temp.nextInt();
            switch (option){
                case 1:
                    printAgenda();
                    break;
                case 2:
                    System.out.println("Scrieti numele");
                    String nume = test.nextLine();
                    System.out.println("Scrieti numarul");
                    String phone = test.nextLine();
                    System.out.println("Scrieti slujba");
                    String job = test.nextLine();
                    Agenda agendaTemp =new Agenda(nume,phone,job);
                    addAgenda(agendaTemp);
                    break;
                case 3:
                    System.out.println("Scrieti numele ce trebuie inlocuit");
                    nume = test.nextLine();
                    System.out.println("Scrieti numele inlocuitor");
                    String numeInlocuitor = test.nextLine();
                    replaceAgenda(nume,numeInlocuitor);
                    break;
                case 4:
                    System.out.println("Scrieti numele ce doriti sa il stergeti din agenda");
                    nume = test.nextLine();
                    deleteAgenda(nume);
                    break;
                case 5:
                    option = 5;
                    break;
            }
        } while ((option > 0) && (option < 5));
    }

    public static int findAgenda (String persoana) {
        int foundit = 0,temp = 0;
        for (Agenda i: agenda_array) {
            if (i != null && i.name.equals(persoana)) {
                foundit = temp;
            }
            temp++;
        }
        return foundit;
    }
    public static void addAgenda(Agenda persoana) {
        boolean madeit = false;
        for (int i = 0; i < agenda_array.length; i++) {
            if ((agenda_array[i] == null) && (!madeit)) {
                agenda_array[i] = persoana;
                madeit = true;
            }
        }
    }

    public static void replaceAgenda (String numeDeInlocuit, String numeNou) {
        int replace = findAgenda(numeDeInlocuit);
        agenda_array[replace].name = numeNou;
    }

    public static void deleteAgenda (String persoana) {
        int delete = findAgenda(persoana);
        agenda_array[delete] = null;
    }
    
    public static void printAgenda () {
        for (int i = 0; i < agenda_array.length; i++) {
            if (agenda_array[i] != null) {
                System.out.println("Pozitia numarul " + (i + 1));
                System.out.println("Numele este " + agenda_array[i].name);
                System.out.println("Numarul de telefon este " + agenda_array[i].phone);
                System.out.println("Slujba este " + agenda_array[i].job);
                System.out.println();
            }
            else
                System.out.println("Pozitia numarul " + i + " este goala");
        }
    }

    public static void menu() {
        System.out.println("1. Afisare Agenda");
        System.out.println("2. Adaugare Agenda");
        System.out.println("3. Inlocuieste Agenda");
        System.out.println("4. Sterge Agenda");
        System.out.println("5. Iesi din program");
    }
}