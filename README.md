# kordle-svr

## Background
This is the server that keeps track of the wordle2 results via HTTP ReST calls.

The server can be run locally or in Google's Cloud Run.  There is some configuration related to Google's App Engine, but that approach did not work well with the H2 in memory database.

## How-to

To run locally:
```
./gradlew bootRun
```

To deploy/run in Cloud Run:
```
gcloud run deploy
```

To see the data, navigate to:
```
http(s)://{host}:{port}/h2-console
```

The data con be viewed in the console using:
```
URL: jdbc:h2:/tmp/resultdb
User: ""
Password: ""
```

If you want the DB to be retained, avoid Cloud Run "cold starts" by going to the Google Cloud Console and doing "Edit & Deploy New Version" setting the min instances to 1. Turn this off when you're not using it to save money.

## References
https://www.bezkoder.com/spring-boot-jpa-h2-example/
https://medium.com/google-cloud/3-solutions-to-mitigate-the-cold-starts-on-cloud-run-8c60f0ae7894

