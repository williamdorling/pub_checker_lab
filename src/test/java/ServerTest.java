import org.assertj.core.util.VisibleForTesting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ServerTest {

    Server server;
    Guest guest;

    @BeforeEach
    public void setUp(){
        server = new Server();
        server.learnDrink("lager");
        server.learnDrink("wine");
    }

    // TODO; test guest can be served if pass all tests
    @Test
    public void canBeServedTrue(){
        guest = new Guest("Frida", 27, 14.50, 89, '£', "lager");
        assertThat(server.canServeGuest(guest)).isEqualTo(true);
    }

    // TODO: test that guest can only get served if over 18
    @Test
    public void canBeServedOver18Fail(){
        guest = new Guest("Igor", 16, 15.50, 72, '£', "wine");
        assertThat(server.canServeGuest(guest)).isEqualTo(false);
    }

    // TODO: test that guest can only get served if has enough money to buy a drink (every drink is £5)
    @Test
    public void canBeServedEnoughMoneyFail(){
        guest = new Guest("Bert", 22, 0.00, 100, '£', "lager");
        assertThat(server.canServeGuest(guest)).isEqualTo(false);
    }

    // TODO: test that guest can only get served if sober enough (set sobriety level on guest)
    @Test
    public void canBeServedSoberEnoughFail(){
        guest = new Guest("Debbie", 52, 78.22, 12, '£', "wine");
        assertThat(server.canServeGuest(guest)).isEqualTo(false);
    }

    // TODO: test that guest can only get served if guest is not banned from the pub
    @Test
    public void canBanGuest(){
        guest = new Guest("Frida", 27, 14.50, 89, '£', "lager");
        server.banGuest(guest);
        assertThat(guest.isBanned()).isEqualTo(true);
    }
    @Test
    public void canBeServedNotBannedFail(){
        guest = new Guest("Jason", 35, 10.00, 51, '£', "lager");
        server.banGuest(guest);
        assertThat(server.canServeGuest(guest)).isEqualTo(false);
    }

    // TODO: test that guest can only get served if guest can pay in local currency (add £ char as currency)
    @Test
    public void canBeServedCorrectCurrencyFail(){
        guest = new Guest("Chet", 21, 50.00, 89, '$', "wine");
        assertThat(server.canServeGuest(guest)).isEqualTo(false);
    }



    // EXTENSIONS

    // TODO: test that guest can only get served if server can make favourite drink
    //  (give server a list of drinks (strings) it can make)

    @Test
    public void canBeServedFavouriteDrinkFail(){
        guest = new Guest("Mary", 43, 22.15, 90, '£', "bloodyMary");
        assertThat(server.canServeGuest(guest)).isEqualTo(false);
    }

}