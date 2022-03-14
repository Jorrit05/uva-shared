package com.example;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.*;

public class Communicator extends AbstractBehavior<Communicator.Hello> {

    public static class Hello {
        public final int times;

        public Hello(int times) {
            this.times = times;
        }
    }


    public static Behavior<Hello> create() {
        return Behaviors.setup(Communicator::new);
    }

    private final ActorRef<Listener.Request> listener;

    private Communicator(ActorContext<Hello> context) {
        super(context);
        listener = context.spawn(Listener.create(), "listener");
    }

    @Override
    public Receive<Hello> createReceive() {
        return newReceiveBuilder().onMessage(Hello.class, this::onSayHello).build();
    }

    private Behavior<Hello> onSayHello(Hello command) {

        System.out.println("I have reveived [" + command.times + "] hello's" );
        if (command.times > 100){
            System.out.println("Ok ok, I will stop!" );
        } else {
            listener.tell(new Listener.Request(command.times + 1, getContext().getSelf()));
        }
        

        return this;
    }
}
