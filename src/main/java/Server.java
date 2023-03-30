import java.util.ArrayList;

public class Server {

    private ArrayList<String> drinksCanServe;

    public Server(){
        this.drinksCanServe = new ArrayList<>();
    }

    public void banGuest(Guest guest){
        guest.setBanned(true);
    }

    public void learnDrink(String drink){
        this.drinksCanServe.add(drink);
    }

    public boolean canServeDrink(String drink){
        return drinksCanServe.contains(drink);
    }

    public boolean canServeGuest(Guest guest){
        if(guest.getAge() < 18){
            return false;
        }if(guest.getWallet() < 5){
            return false;
        }if(guest.getSobriety() < 50){
            return false;
        }if(guest.isBanned() == true){
            return false;
        }if(guest.getCurrency() != '£'){
            return false;
        }if(!canServeDrink(guest.getFavouriteDrink())){
            return false;
        }
        return true;
    }

    public ArrayList<String> getDrinksCanServe() {
        return drinksCanServe;
    }

    public void setDrinksCanServe(ArrayList<String> drinksCanServe) {
        this.drinksCanServe = drinksCanServe;
    }
}
