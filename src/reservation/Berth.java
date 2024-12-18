package reservation;

public class Berth {
    private  int lb=1;
    private  int ub=1;
    private int mb=1;
    public void add(Ticket ticket){
        if (lb!=0 && ticket.getBerthPrefer().equals("lb")){
            lb-=1;
            ticket.setConfirmationStatus("in lb");

        }
        else if(ub!=0 && ticket.getBerthPrefer().equals("ub")){
            ub-=1;
            ticket.setConfirmationStatus("in ub");
        }
        else if(mb!=0 && ticket.getBerthPrefer().equals("mb")){
            mb-=1;
            ticket.setConfirmationStatus("in mb");
        }
        else{
            if (lb!=0){
                ticket.setConfirmationStatus("in ub");

            } else if (mb!=0) {
                ticket.setConfirmationStatus("in ub");
            }
            else if (ub!=0) {
                ticket.setConfirmationStatus("in ub");

            }
            else{
                ticket.setConfirmationStatus("not available");
            }
        }
    }

}
