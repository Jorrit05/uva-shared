package com.example;

import akka.actor.typed.ActorSystem;

public class Initiator {
  public static void main(String[] args) {

    final ActorSystem<Communicator.Hello> communicator = ActorSystem.create(Communicator.create(), "somestring");
    communicator.tell(new Communicator.Hello(0));
  }
}
