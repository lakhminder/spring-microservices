1) From Spring Initializer include:
	Zuul, Eureka client,Dev Tools(for deploy changes without restarting for dev mode),Actuator
2) Add Sleuth
3) Install RabbitMQ and start as windows service
4) Install Zipkin from Zipkin quickstart(https://zipkin.io/pages/quickstart)(download as executable jar)
	
	set RABBIT_URI=amqp://localhost
	java -jar zipkin-server-2.8.3-exec.jar
	
	open http://localhost:9411/zipkin/
5) Add Zipkin and AMQP(i.e rabbitMQ) dependency