# bouceka Individual Development Project


## Motivation

For my independent project, I have chosen to create a Microservices app. I have never developed an entire app in microservices architecture so that it will be challenging. If you don't know what a microservices architecture is, [here](https://github.com/nic-dgl-204-fall-2022/aboucek-kotlin-research) is a link to my mini research that sums up the most important parts.

The app will be part of my personal project of fictional NIC Athletics. I have created a [database data schema](https://github.com/nic-dgl-204-fall-2022/aboucek-kotlin-research/blob/main/ERD-model.md) that might help you picture the app's scope. However, I intend this to be more of a [POC](https://en.wikipedia.org/wiki/Proof_of_concept) than a project I would put into my resume.
### Technology used: [Kotlin](https://kotlinlang.org/), [Micronaut](https://micronaut.io/), [JavaScript](https://www.javascript.com/), [NATS](https://nats.io/), [PostreSQL](https://www.postgresql.org/) and more

## Study plan
I plan to create these three services.

![Services](/assets/services.jpg)

| Goals            | Week |
| --------------------- | ---- |
| Set up environment    | 0    |
| Create first services | 1    |
| Integrate database    | 2    |
| Refactor Code         | 3    |

## Week 0
This week I focus on setting up an environment and creating three initial services, including technologies such as [Skaffold](https://skaffold.dev/), [Docker](https://www.docker.com/), and [Ingress](https://kubernetes.io/docs/concepts/services-networking/ingress/).
### Spent time: ~12 hours

## Challenges
- Creating Micronaut services and integrating them with Skaffold and Docker
- Designing the structure of the services
- I tried to implement Ktor as well. It took too much time to fix bugs.
## Progress
Micronaut has a pretty well-documented process of how to implement Skaffold. On the other side, implementing Docker went remarkably worse. I use Grandle, and in the documentation was shown Maven solution. It took me a couple of hours to find the right solution. After implementing both, I could implement Ingress that works like a load balancer (It is not!). Anytime, a client requests the server Ingress points to the appropriate service based on URL. I also implemented auto deployment to Google Cloud by Skaffold. You can see that in `skaffold-gcr.yml`. However, the project will be developed locally because Google Cloud is too expensive to maintain.

If you have the same local environment set up as I do, meaning haveing installed globally Ingress, Skaffold, and Docker. You can easily run all services at once just by running this command.
```bash
skaffold dev
```
## Potential Improvements

## What did I learn?
I have learned
## Week 4
This week I focus on improving the Micronaut services and creating first classes and packages that are going to shape the services. Also, I will prepare the environment for implementing databases. One service is going to
### Spent time: ~8 hours

## Challenges

## Progress

## Potential Improvements

## What did I learn?
