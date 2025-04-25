# springboot-retry #

This project contains examples how to perform method retry and recover in Spring Boot.

## Configurations ##

Retry requires that the `@EnableRetry` annotation is included either into `@SpringApplication` class or into a configuration class.

## Retry ##

The `DuckService` has a method that has been configured to retry 5 times with 1000 millisecond delay if the method returns `ResponseStatusException` (custom exception created for this example).

```java
@Retryable(
retryFor = {RetryException.class},
maxAttemptsExpression = "5",
backoff = @Backoff(delayExpression = "1000"))
```

## Retry and Recover ##

The `GooseService` has a method that has been configured to retry 5 times with 1000 millisecond delay if the method returns `ResponseStatusException`; just like in `DuckService`.

In addition the `GooseService` has a `@Recover` method that will be called if the method fails after 5 attempts.

The `@Recover` method has the same signature as the original method, but with an additional `RetryContext` parameter.

## Testing ##

GET call to `DuckController` returns the original `NOT_FOUND` error.

```
GET http://localhost:8080/api/ducks/1

{
    "timestamp": "2025-04-25T07:03:31.332+00:00",
    "status": 404,
    "error": "Not Found",
    "path": "/api/ducks/1"
}
```

GET call to `GooseController` returns the `BAD_REQUEST` error from recovery method.

```
GET http://localhost:8080/api/gooses/1

{
    "timestamp": "2025-04-25T07:04:42.934+00:00",
    "status": 400,
    "error": "Bad Request",
    "path": "/api/gooses/1"
}
```

## Observations ##

The `retryFor` attribute does not seem to work for exceptions that are directly extending the `RuntimeException`.

The exceptions that directly extending the `RuntimeException` work with `include` or `value` attributes, but both of them are deprecated.
