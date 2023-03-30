public class Guest {

    private String name;
    private int age;
    private double wallet;
    private int sobriety;
    private boolean banned;
    private char currency;
    private String favouriteDrink;

    public Guest(String name, int age, double wallet, int sobriety, char currency, String favouriteDrink){
        this.name = name;
        this.age = age;
        this.wallet = wallet;
        this.sobriety = sobriety; // under 50 = can't be served, 50 or above = can be served
        this.banned = false;
        this.currency = currency;
        this.favouriteDrink = favouriteDrink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public int getSobriety() {
        return sobriety;
    }

    public void setSobriety(int sobriety) {
        this.sobriety = sobriety;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public char getCurrency() {
        return currency;
    }

    public void setCurrency(char currency) {
        this.currency = currency;
    }

    public String getFavouriteDrink() {
        return favouriteDrink;
    }

    public void setFavouriteDrink(String favouriteDrink) {
        this.favouriteDrink = favouriteDrink;
    }
}
