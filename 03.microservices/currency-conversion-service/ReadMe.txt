1) From Spring Initializer include:
	WEb,Dev Tools(for deploy changes without restarting for dev mode),Actuator,config client
2) Add Feign as dependency
3) Add Ribbon
4) Add Eureka Client
5) Add Sleuth
6) Install RabbitMQ and start as windows service
7) Install Zipkin from Zipkin quickstart(https://zipkin.io/pages/quickstart)(download as executable jar)
	
	set RABBIT_URI=amqp://localhost
	java -jar zipkin-server-2.8.3-exec.jar
	
	open http://localhost:9411/zipkin/
8) Add Zipkin and AMQP(i.e rabbitMQ) dependency