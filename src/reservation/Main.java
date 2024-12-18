package reservation;

import java.util.Scanner;

public class Main {
        public  Ticket passengerDetails(){
            Scanner scanner = new Scanner(System.in);
            System.out.print("name");
            String name=scanner.next();
            System.out.print("age");
            int age=scanner.nextInt();
            System.out.print("gender");
            String gender=scanner.next();
            System.out.print("Birth Preference");
            String berth=scanner.next();
            return new Ticket(name,age,gender,berth);
        }

        public static void main(String [] args) {

            Scanner scanner = new Scanner(System.in);
            Train train = new Train();
            Main passenger = new Main();

            boolean end = false;
            while (!end) {

                System.out.println("1. book ticket");
                System.out.println("2.Show all  ticket");
                System.out.println("3.Cancel Ticket");
                System.out.println("4.Exit");

                int choice = scanner.nextInt();
                System.out.println(choice);
                switch (choice) {
                    case 1:
                        train.booking(passenger.passengerDetails());
                        break;
                    case 2:
                        train.allTicketsShow();
                        break;
                    case 3:
                        train.cancelTicket(passenger.passengerDetails());
                        break;
                    case 4:
                        end = true;
                    default:
                        end = true;

                }
            }
        }
}
