package automationApi.config;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class makeAnApiRequest {
    protected static Actor actor = new Actor("User");

    protected void sendRequests(String url){
        actor.can(CallAnApi.at(url));
    }

}
