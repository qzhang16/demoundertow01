package com.asg.demoundertow01;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println("Hello World!");
        HttpHandler handler = new HttpHandler() {


                    @Override
                    public void handleRequest(HttpServerExchange exchange) throws Exception {
                        // TODO Auto-generated method stub
                exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                exchange.getResponseSender().send("welcome to undertow 2.1.0 final.");
                    }
                    
        };

        
        Undertow server = Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler(handler).build();
        server.start();
    }
}
