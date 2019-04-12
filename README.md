# Spring-boot Best Practices
Simple project to show the best practices to coding using spring-boot

### HTTPS Requests

- Post 
1. Always returns with status 201 and the URI from the created resource.
1.1. This uri will be in the response headers at "Location".
