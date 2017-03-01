# sparkstream-kafka
Repository to show the integration between Apache Spark Streaming and Apache Kafka

Code is written in scala and it require sbt installation.

Project can be be tested in two ways:

1) Eclipse IDE - Run below sbt command to compile project and make it eclipse compatible
	--> sbt package
	--> sbt eclipse
	Then project can be imported in eclipse IDE to run the scala program.
	
2) Spark-submit - Run below sbt commands
	--> sbt package
	--> sbt assembly
	Then a jar will be created inside target/scala.xx.xx directory which can be run using spark-submit command.
