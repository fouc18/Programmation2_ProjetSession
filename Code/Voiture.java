package Code;

public class Voiture {

        int year;

        double speed;

        public Voiture(int y,String m,double s){
            this.year = y;

            this.speed = s;
        }

        public double getSpeed(){
            return this.speed;
        }

        public int getYear(){
            return this.year;
        }

        public void accelerate(){
            this.speed+=1;
        }
    }
