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
