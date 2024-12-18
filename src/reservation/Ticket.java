package reservation;

public class Ticket {


        private final String name;
        private final int age;
        private final String gender;
        private final String berthPrefer;
        private String confirmationStatus;

        public Ticket(String name,int age,String gender,String berthPrefer){
            this.name=name;
            this.age=age;
            this.gender=gender;
            this.berthPrefer=berthPrefer;
        }


        public String getName(){
            return name;
        }
        public int getAge(){
            return age;
        }
        public String getGender(){
            return gender;
        }

        public String getBerthPrefer(){
            return berthPrefer;
        }
        public String getConfirmationStatus(){
            return confirmationStatus;
        }
        public void setConfirmationStatus(String confirmationStatus){
            this.confirmationStatus=confirmationStatus;
        }

    }


