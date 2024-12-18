package reservation;

import java.util.ArrayList;
import java.util.Objects;

public class Train {
        Berth berth=new Berth();

        ArrayList<Ticket> reserved=new ArrayList<>();
        ArrayList<Ticket>rac=new ArrayList<>();
        ArrayList<Ticket>waiting=new ArrayList<>();

        public void booking(Ticket ticket){
            if(reserved.size()<2){
                reserved.add(ticket);
                berth.add(ticket);
                System.out.println("you are booked your berth, see confirmation status");
            }
            else if (rac.isEmpty()){
                rac.add(ticket);
                System.out.println("you have booked rac ");
                ticket.setConfirmationStatus("in rac");
            }
            else if (waiting.isEmpty()){
                waiting.add(ticket);
                System.out.println("you have in waited list");
                ticket.setConfirmationStatus("in waiting");
            }
            else{
                System.out.println("Ticket is not available");
                ticket.setConfirmationStatus("not available");
            }
            ticketShow(ticket);
            allTicketsShow();

        }

        public void cancelTicket(Ticket ticket){
            if(removeTicketReserved(ticket)){
                if(!rac.isEmpty()){
                    reserved.add(rac.getFirst());
                    rac.getFirst().setConfirmationStatus("moved to berth");
                    rac.remove(rac.getFirst());
                    if(!waiting.isEmpty()){
                        rac.add(waiting.getFirst());
                        waiting.getFirst().setConfirmationStatus("moved to rac");
                        waiting.remove(waiting.getFirst());
                    }
                }
            } else if (removeTicketRac(ticket)) {

                if(!waiting.isEmpty()){
                    rac.add(waiting.getFirst());
                    waiting.remove(waiting.getFirst());
                }
            } else if (removeTicketWaiting(ticket))
            {
                return;
            }

            else{
                System.out.println("your info is not available");
            }
        }
        public Boolean removeTicketReserved(Ticket ticket){
            for(Ticket t : reserved){
                if (Objects.equals(t.getName(), ticket.getName())  && Objects.equals(t.getGender(), ticket.getGender())) {
                    reserved.remove(t);
                    return true;
                }
            }
            return false;
        }

        public Boolean removeTicketRac(Ticket ticket){
            for(Ticket t : rac){
                if (Objects.equals(t.getName(),ticket.getName()) && Objects.equals(t.getConfirmationStatus(), ticket.getConfirmationStatus()) && Objects.equals(t.getGender(), ticket.getGender())) {
                    rac.remove(t);
                    return true;
                }
            }
            return false;
        }
        public boolean removeTicketWaiting(Ticket ticket){
            for(Ticket t : waiting){
                if (Objects.equals(t.getName(), ticket.getName()) && Objects.equals(t.getConfirmationStatus(), ticket.getConfirmationStatus()) && Objects.equals(t.getGender(), ticket.getGender())) {
                    waiting.remove(t);
                    return true;
                }

            }
            return false;
        }


        public void ticketShow(Ticket ticket){
            System.out.println("current booking status:");
            System.out.println(ticket.getName() + " " + ticket.getAge() + " " + ticket.getGender() + " " + ticket.getBerthPrefer()+" "+ticket.getConfirmationStatus());

        }
        public void allTicketsShow() {
            System.out.println("this is the list of tickets booked");
            for (Ticket ticket : reserved) {
                System.out.println(ticket.getName() + " " + ticket.getAge() + " " + ticket.getGender() + " " + ticket.getBerthPrefer()+" "+ticket.getConfirmationStatus());
            }
            for (Ticket ticket : rac) {
                System.out.println(ticket.getName() + " " + ticket.getAge() + " " + ticket.getGender() + " " + ticket.getBerthPrefer()+" "+ticket.getConfirmationStatus());
            }
            for (Ticket ticket : waiting) {
                System.out.println(ticket.getName() + " " + ticket.getAge() + " " + ticket.getGender() + " " + ticket.getBerthPrefer()+" "+ticket.getConfirmationStatus());
            }
        }

}
