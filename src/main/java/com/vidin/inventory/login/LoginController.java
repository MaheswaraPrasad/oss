package com.vidin.inventory.login;

import com.vidin.inventory.card.Card;
import com.vidin.inventory.node.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

//    String logoutUrl = "https://auth.acc.onkpn.com/v2/logout?brand=6";
    String logoutUrl = "https://httpstat.us/200";

    @GetMapping("/Logout")
    Boolean logout() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        log.info(String.format("logoutUrl -> %s", logoutUrl));
        HttpRequest req = HttpRequest.newBuilder(URI.create(logoutUrl))
                .GET()
                .build();
        HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
        return resp.statusCode() == 200;
    }

    public static void main(String[] args) {
        List<Card> cards = new ArrayList<Card>();
        Node n = new Node("N1","CPU1","16GB");
        cards.add(new Card("C1","Com1",n));
        cards.add(new Card("C2","Com1",n));
        cards.add(new Card("C3","Com1",n));
        cards.add(new Card("C4","Com1",n));
        cards.add(new Card("C5","Com2",n));
        cards.add(new Card("C6","Com2",n));
        cards.add(new Card("C7","Com2",n));
        cards.add(new Card("C8","Com2",n));

        List<String> com1Cards = cards.stream()
                .filter(e ->  e.getCompany().equals("Com1"))
                .map(e -> e.getName())
                .collect(Collectors.toList());
        System.out.println(com1Cards);

    }

}