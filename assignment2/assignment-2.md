# Writiing assignment 2, AKKA

|   |   |
|---|---|
| Authors:| Rein Spanjer,Bob,  Jorrit Stutterheim |
| Group number:| 10 |
| Student ID Jorrit Stutterheim |  13957899 |
| Student ID Rein Spanjer | 13558307 |
| Student ID Bob: | 14076357 |
| Study: | Premaster software engineering |
| Course: | Programmeertalen |


## Table of Contents

[1. Akka’s actor model](#akkas-actor-model) </br>
[2. Embedded nature of Akka](#embedded-nature-of-akka) </br>
[3 Additional bonus questions](#additional-bonus-questions) </br>

## Akka’s actor model

__Q1: In your own words, explain how message-passing in Akka avoids the problem of corrupted state, without having to rely on the programmer for avoiding the problem (e.g. by introducing locks to the code). In your answer, make explicit what is meant by the state of an actor and how messages are processed by an actor.__

As stated by the Akka documentation, sending messages has the following two guarantees:

- The actor send rule: the send of the message to an actor happens before the receive of that message by the same actor.
- The actor subsequent processing rule: processing of one message happens before processing of the next message by the same actor.

An 'actor' in Akka is a newly created separate process (Akka lightweight process, not a full system thread), which defines it's own state and behavior. The only way to communicate with an actor is to send it messages on its message queue, in general messages are handled FIFO (First In First Out). Thus, since each actor has its own state (no shared memory), and messages are handled one by one, state can not be corrupted by concurrent writes to the same memory block. Developers can change the order of message handling, by for example implementing a priority queue mailbox, still messages are handled one-by-one, which prevents memory corruption.

It is a rule of thumb in Akka to only send immutable messages, which prevents Actors writing in the same memory. A developer *could* send mutable objects though and through this create race conditions or memory issues, as demonstrated by the below Scala code taken from the Akka [documentation](https://doc.akka.io/docs/akka/current/general/jmm.html):

```Scala
  var state = ""
  val mySet = mutable.Set[String]()

  def onMessage(cmd: MyActor.Command) = cmd match {
    case Message(text, otherActor) =>
      // Very bad: shared mutable object allows
      // the other actor to mutate your own state,
      // or worse, you might get weird race conditions
      otherActor ! mySet

```

__Q2: According to Akka’s documentation, its message-delivery system guarantees two properties about the delivery of messages. In your own words, explain these properties and their relevance.__

According to Akka's documentation these two properties are:

- at-most-once delivery, i.e. no guaranteed delivery
- message ordering per sender–receiver pair

*at-most-once delivery* means that an actor will send a message only once and in a 'fire and forget' manner, this means a message might not be delivered. An advantage of this method is that it is the least overhead, which makes for the greatest possible performance in this model. In short, applications that do not need 100% message delivery are not bothered by complicated implementations that try to do this, applications that do need more guarantees need to be build keeping this in mind. (Proper failure propagation, business logic that can handle failures etc.)

*message ordering per sender–receiver pair* means that Akka guarantees message order between a single sender and receiver, however if multiple actors send to one actor messages can arrive in a 'mixed' order. An exception to this rule is failure communication between a parent a child, which goes through a separate system mailbox, as shown in the following example taken from the Akka [documentation](https://doc.akka.io/docs/akka/current/general/message-delivery-reliability.html):

```bash
Child actor C sends message M to its parent P

Child actor fails with failure F

Parent actor P might receive the two events either in order M, F or F, M
```

__Q3: In your own words, why does Akka not guarantee the delivery of messages? What are the arguments made to this design decision by the documentation? Mention at least three reasons.__


__Q4: In your own words, what mechanism(s) does Akka provide to handle failures? In your answer, mention the hierarchy formed by Akka actors and different possible responses to an observed failure. Be specific.__

__Q5: A significant difference between a message being processed and a method/function/procedure being called, is that processing a message does not return a value. What does the Akka documentation suggest a programmer do instead? In your answer, refer to at least one of the ‘interaction patterns’ described in the documentation.__

__Q6 Explain an additional interaction pattern and motivate it through an example of your own choosing.__


## Embedded nature of Akka


__Q7:In either Java or Scala, is Akka a compiled or interpreted language? Explain how you concluded this. If interpreted, in what programming language is the interpreter written? If compiled, what is the target language instruction set of the compiler?__

__Q8: In either Java or Scala, is Akka statically or dynamically typed? How did you conclude this?__

__Q9: Describe an application for which you think Akka’s actor-oriented programming is particularly suitable. Argue whether for this application you would prefer to use the Java’s Akka, Scala’s Akka, or Erlang.__

__Q10: How can Akka programs be debugged? Is this simpler or more difficult than in other languages you are familiar with? How so?__

## Additional bonus questions

__Q11: The following page contains links to several additional Akka modules that extend the functionality of Akka even further. For one of these modules: explain what it is for by mentioning the kinds of applications that can benefit from using this module. Pick an example application of your own choosing. https://doc.akka.io/docs/akka/current/common/other-modules.html__

__Q12: Based on your observations, what are the main similarities and differences between Akka and Erlang? You can refer to syntactic, semantic, or pragmatic aspects of the languages. Do the languages differ in terms of the concepts associated with the programming paradigms discussed in this course?__

__Q13: Write a concurrency abstraction using Akka actors that implements remote procedure calls. The goal of this abstraction is to make it possible to just execute a function/method that does the communication for us and waits for a response which it returns as the result of the call. You can use either Scala or Java or pseudo-code resembling Scala or Java.__