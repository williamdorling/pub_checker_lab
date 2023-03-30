import org.assertj.core.util.VisibleForTesting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ServerTest {

    Server server;
    Guest guest1;
    Guest tooYoung;
    Guest forgotWallet;
    Guest tooDrunk;
    Guest tooRowdy;
    Guest tooAmerican;
    Guest tooPicky;

    @BeforeEach
    public void setUp(){
        server = new Server();
        server.learnDrink("lager");
        server.learnDrink("wine");
        guest1 = new Guest("Frida", 27, 14.50, 89, '£', "lager");
        tooYoung = new Guest("Igor", 16, 15.50, 72, '£', "wine");
        forgotWallet = new Guest("Bert", 22, 0.00, 100, '£', "lager");
        tooDrunk = new Guest("Debbie", 52, 78.22, 12, '£', "wine");
        tooRowdy = new Guest("Jason", 35, 10.00, 51, '£', "lager");
        server.banGuest(tooRowdy);
        tooAmerican = new Guest("Chet", 21, 50.00, 89, '$', "wine");
        tooPicky = new Guest("Mary", 43, 22.15, 90, '£', "bloodyMary");

    }

    // TODO; test guest can be served if pass all tests
    @Test
    public void canBeServedTrue(){
        assertThat(server.canServeGuest(guest1)).isEqualTo(true);
    }

    // TODO: test that guest can only get served if over 18
    @Test
    public void canBeServedOver18Fail(){
        assertThat(server.canServeGuest(tooYoung)).isEqualTo(false);
    }

    // TODO: test that guest can only get served if has enough money to buy a drink (every drink is £5)
    @Test
    public void canBeServedEnoughMoneyFail(){
        assertThat(server.canServeGuest(forgotWallet)).isEqualTo(false);
    }

    // TODO: test that guest can only get served if sober enough (set sobriety level on guest)
    @Test
    public void canBeServedSoberEnoughFail(){
        assertThat(server.canServeGuest(tooDrunk)).isEqualTo(false);
    }

    // TODO: test that guest can only get served if guest is not banned from the pub
    @Test
    public void canBanGuest(){
        server.banGuest(guest1);
        assertThat(guest1.isBanned()).isEqualTo(true);
    }

    @Test
    public void canBeServedNotBannedFail(){
        assertThat(server.canServeGuest(tooRowdy)).isEqualTo(false);
    }

    // TODO: test that guest can only get served if guest can pay in local currency (add £ char as currency)
    @Test
    public void canBeServedCorrectCurrencyFail(){
        assertThat(server.canServeGuest(tooAmerican)).isEqualTo(false);
    }



    // EXTENSIONS

    // TODO: test that guest can only get served if server can make favourite drink
    //  (give server a list of drinks (strings) it can make)

    @Test
    public void canBeServedFavouriteDrinkFail(){
        assertThat(server.canServeGuest(tooPicky)).isEqualTo(false);
    }


}
