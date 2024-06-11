import io.delta.sharing.client
import org.apache.spark.sql.SparkSession
import io.delta.sharing.spark

object ReadSharedData extends App {

  val spark = SparkSession.builder()
    .master("local[1]")
    .appName("Read Shared Data")
    .config("spark.jars.packages", "io.delta:delta-sharing-spark_2.12:0.6.4")
    .getOrCreate()

  val profilePath = "/home/knoldus/Desktop/Delta Open Sharing/resources/config.share"
  val sharedFiles = client.DeltaSharingRestClient(profilePath).listAllTables()
  sharedFiles.foreach(println)

  val popular_products_df = spark.read.format("delta_sharing").load("/home/knoldus/Desktop/Delta Open Sharing/resources/config.share#checkout_data_products.data_products.popular_products_data")

// val e_comm_shipment_df = spark.read.format("deltaSharing")
//   .load(s"${profilePath}#checkout_data_products.data_products.e-com_shipment_data")
//
//  val checkout_data_view_df = spark.read.format("deltaSharing")
//    .load(s"${profilePath}#checkout_data.checkout_schema.checkout_data_view")
//
//  val checkout_orders_df = spark.read.format("deltaSharing")
//    .load(s"${profilePath}#checkout_data.checkout_schema.checkout_orders_data")

  popular_products_df.show()
//  e_comm_shipment_df.show()
//  checkout_data_view_df.show()
//  checkout_orders_df.show()

}


