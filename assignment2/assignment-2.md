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


__Q2: According to Akka’s documentation, its message-delivery system guarantees two properties about the delivery of messages. In your own words, explain these properties and their relevance.__

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