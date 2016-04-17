# Java-Network
A tech test to develop a console-based app that mirrors Twitter-functionality, written in Java.

## Requirements
**User creating**: a new user called *Spike* can be created  
**Posting**: *Spike* can publish messages to a personal timeline  
**Reading**: *Spike* can view *Nikesh’s* timeline  
**Following**: *Leo* can subscribe to *Spike* and *Nikesh's* timelines, and view an aggregated list of all subscriptions

Although the requirements state that it should be a console-based app, this is secondary objective: *we are more interested in your design, approach and progress with Java than whether you manage to create a fully working command line app*.

## Approach
Before I could begin to tackle the coding challenge, I needed to get the various tools set up (on Linux, which I was using for the first time), and get a basic understanding of Java. I used the Java docs to get a quick overview of structure and syntax (creating classes / methods etc), and a walkthrough for completing a bank kata in Java on Youtube to understand JUnit and Mockito.

To explore Java and the solution space further, I created a simple two-class solution, consisting of a User class and a Presenter class. Although it delivered on the functionality, it wasn't hard to see that the User class was having too much responsibility.

As making it console-based was a secondary objective, I decided to focus my time on exploring Java and the design of the logic, rather than developing a user interface. My second version, was a five-class solution consisting of: User, Timeline, Subscription, Feed and Presenter classes. The structure is more flexible and can more easily incorporate additional functionality. I considered adding a Post and a User repo class, but felt like this could be easily accomplished at a later stage if necessary.

## Obstacles
Getting everything set up and working was the main obstacle, as I was unfamiliar with both Linux and with the IDE and testing frameworks. Working in Java wasn't particular difficult (only required a lot of googling for syntax), although I'm sure I've employed a mixture of styles.

## What I learnt:
I was a bit hesistant in regards the effort required to having to "learn" a new language simply to complete a tech test. However, it went remarkably quick to pick up (the basics). In addition, I also enjoyed working with Intellij - in particular the integration of Junit and Mockito, felt quicker than Rspec. The ease of creating new classes, tests and mocks very much encouraged a TDD approach.

## Resources and tech
I used: Intellij, JUnit and Mockito

## Example of functionality
```
---- initialisation of subscription and timeline completed above ---

leo = new User(leoSubscriptions, leoTimeline);
nikesh = new User(nikeshSubscriptions, nikeshTimeline);
spike = new User(spikeSubscriptions, spikeTimeline);

leo.post("Leo first post");
leo.viewTimeline(leo);
//output: Leo first post

nikesh.post("Nikesh first post");
spike.post("Spike first post");
leo.follow(nikesh);
leo.follow(spike);
leo.viewFeed();
//output: Nikesh first post
          Spike first post
```
