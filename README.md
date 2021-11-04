# DORA software delivery metrics 

This code is the companion of the blog post [Implementing DORA key software delivery metrics](https://danlebrero.com/2021/11/10/implementing-dora-software-delivery-metrics-accelerate-performance/).

It collects and calculates the deployment frequency, deployment lead time and change fail rate.

This code is a cleaned up version of https://github.com/akvo/akvo-platform/tree/master/k8s/akvo-devops-stats.

## Run

1. Configure the projects to collect data from by editing [this file](backend/src/akvo_devops_stats/projects.clj).
2. Configure the required Github/Semaphore/TravisCI secrets at [docker-compose.yml](docker-compose.yml).
3. Run `docker-compose up --build`
4. Connect to the running REPL at port 47480.
5. Run `(dev) (go)`
6. Check the logs at `backend/logs/dev.log`