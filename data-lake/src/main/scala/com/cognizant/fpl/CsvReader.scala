package com.cognizant.fpl

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.sql.SQLContext

object CsvReader {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("Spark Count")
    conf.setMaster("local[3]")
    val sc = new SparkContext(conf)
    
    val sqlContext = new SQLContext(sc)
    
    val df = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").load(args(0))
    
    df.printSchema()
    
    // This is just a comment

  }
}