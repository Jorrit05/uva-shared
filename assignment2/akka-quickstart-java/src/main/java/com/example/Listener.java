package com.example;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.*;

public class Listener extends AbstractBehavior<Listener.Request> {

    public static class Request {
        public final int times;
        public final ActorRef<Communicator.Hello> replyTo;
      
        public Request(int times, ActorRef<Communicator.Hello> replyTo) {
          this.times = times;
          this.replyTo = replyTo;
        }
      }

    public static Behavior<Request> create() {

        return Behaviors.setup(Listener::new);
    }


    private Listener(ActorContext<Request> context) {
        super(context);
    }

    @Override
    public Receive<Request> createReceive() {
        return newReceiveBuilder().onMessage(Request.class, this::onRequest).build();
    }

    private Behavior<Request> onRequest(Request request) {
        System.out.println("I am listening [" + request.times + "] times");
        request.replyTo.tell(new Communicator.Hello(request.times));
        return this;
    }
}
