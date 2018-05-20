1) From Spring Initializer include:
	WEb,Dev Tools(for deploy changes without restarting for dev mode),jpa,h2(in memory DB)
2) Add spring boot starter hateoas
3) Add Jackson for xml support
4) Add Swagger for documentation
5) Add actuator and HAL browser
6) Add spring security
	For Basic authentication
	(if enabled default user is 'user' and passwd is in logs 
	which changes which each startup so not reliable)
	Or configure in application.properties