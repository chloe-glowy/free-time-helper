# Free Time Helper

I'm thinking of starting a new project called Free Time Helper. This article has two parts:

1. What is the project? What are the core use cases?
2. What are the APIs? What is the core of the architecture?

## Use Cases

### User-initiated Flow

1. I don't know what I want to do right now
1. I ask the system what to do. I tell it how much **free time\*** I have right now.
1. The system gives a Suggestion, which may either be a Question or an Activity.

\* **free time**: how much time is there between now and the next time I intend to do something else, such as get ready for bed, go to work, leave for an appointment, etc.?

### System-initiated Flow:

1. The system gives a Suggestion

### Question

1. The system asks me a question. For example:
   1. What's something that energizes you?
   1. What's your best friend's name?
1. I can either:
   1. Send an answer to the system
      1. The system gives a new Suggestion
   1. Tell the system "I don't want to answer this question right now"
      1. The system gives a new Suggestion
   1. Do nothing
      1. The system does not communicate with me until I initiate contact with it again

### Activity

1. The system suggests an activity. For example:
   1. text {best friend}
   1. do {thing that energizes you}
   1. spend 5 minutes outside
   1. listen to your favorite song
   1. Read a specific article
1. I can either:
   1. Tell the system I accept the suggestion
      1. I take some time to do the suggested activity
      1. I tell the system I am done with the suggested activity.
      1. The system gives a new Suggestion
   1. Tell the system I do not accept the suggestion
      1. The system gives a new Suggestion
   1. Do nothing
      1. The system does not communicate with me until I initiate contact with it again

## Software Architecture

As usual I will be using the [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html). As a starting exercise, I've made a diagram showing the interfaces of the innermost ring, the "Entities" or "Enterprise Business Rules" ring. Here, I'm referring to this ring as the "Core" component, since that's more intuitive to me.

![Architecture Diagram](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/vmoiu2heil2hzfl1x44r.png)

To start out with, I tried to imagine the system as having a lot of advanced features, most of which I will probably never get to, and make sure that the interfaces work with all of these. Some advanced features:

1. Machine learning to estimate how "helpful" (this is intentionally vague) each suggestion will be for each user
1. A system-initiated communication channel (i.e., notifications) where the system can proactively make suggestions to the user
1. Extensions, to allow the user to provide additional information about themself to the system automatically, via integrations with other software systems that already have information about them
1. End to end encryption

Additionally, I thought about different ways the system could be deployed, and tried to make sure the Core component does not depend on any specific one. For example:

1. The system could be deployed using any database or persistence framework
1. The system could be deployed using a traditional, separated client-server-database architecture, or it could run entirely on a single machine (e.g., a phone) with the option to have cloud backups. This would allow support for end-to-end encryption.
1. It could use any (or no) API framework or RPC framework
1. The user interface could use any communication medium, including a webpage, a mobile phone app, an Alexa skill, a chatbot, a doll that follows you around and talks to you, or a chip in your brain
1. It could be implemented in any programming language and run on any machine
1. In fact, it could be implemented as a protocol written in English and put in a binder for a person to follow. They could accept calls over the phone. The user facts storage implementation could be a filing cabinet, the suggestions catalogue could be a binder, the prediction model could be a person who gives an estimate based on their intuition, and notifications could be implemented by another person who calls the user on the phone.

I currently don't see limitations to this architecture, but I'm guessing some will arise as I flesh out the details of the interfaces. For example, what are all the fields in an "action a user took"? What is in a "catalogue entry"?

As a final part of this exercise (for now), I pared down the diagram to contain only interfaces I think are needed for a minimum viable product:

![Pared down architecture](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/5ihwu4nvlx8suxoo8tx4.png)

My next goal is to flesh out all the interfaces. What exactly are the fields in all the objects that are passed in and out of the methods and plugins?

As a next step towards this, I think it would be helpful to write out some examples of suggestions (activities and questions), actions a user took, and what the catalogue (set of information that helps us decide what activities a user might be interested in based on their history) might look like.
