# Spring-boot Best Practices
Simple project to show the best practices to coding using spring-boot

### HTTPS Requests

- Post 
1. Always returns with status 201 and the URI from the created resource.

1.1. This uri will be in the response headers at "Location".

- Get /{id}
1. When this resource doesn't find result it should return the HttpStatus 404.

1.1. It's possible to annotade your custum exception, for example:
  > @ResponseStatus(HttpStatus.NOT_FOUND)

- All Requests
1. Set up a pattern to response messages, we can use a ExceptionHadler to make it

1.1. It's recommended set three field:
> date - to show date operation

> message - friedly message for user

> detail -  datail from exception

- Validation
1. User the @Valid to validate your fields to request, and annotate your DTO with validate annotarion from JavaX validation API.

`public ResponseEntity<Object> createUser(@RequestBody @Valid UserDTO userDTO)

  @Size(min = 2, message = "Name sould have at least 2 caracters.")

  @Past `


2. To show the message when validation error is trigged , you need overwrite the handleMethodArgumentNotValid on your ExceptionHadler

```java
   @Override
       protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
           ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed.", ex.getBindingResult().toString());
           return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
       }
```
