
import kafka.serializer.DefaultDecoder
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.SparkContext
import kafka.serializer.StringDecoder

object SparkKakfkaIntegration {
  
  /** Main function where the action happens */
  def main(args: Array[String]) {
    
    val sc = new SparkContext("local[*]", "SparkKafkaDemo")
    sc.setLogLevel("ERROR")
    val ssc = new StreamingContext(sc, Seconds(1))
    
    //To read from local kafka
    val kafkaParams = Map("metadata.broker.list" -> "localhost:9092")
    val topics = List("testtopic").toSet
    
    val lines: DStream[String] = KafkaUtils.createDirectStream[
     Array[Byte], String, DefaultDecoder, StringDecoder](
     ssc, kafkaParams, topics).map(_._2)
     
    lines.print()
     
    ssc.start()
    ssc.awaitTermination()
  }
  
}