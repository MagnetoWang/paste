package analyzer
//import org.apache.spark.internal.Logging
import java.io.File

import org.apache.spark.sql.Row

//import analyzer.PercentileApprox.percentile_approx
import com.esotericsoftware.kryo.util.IntMap.Keys
import log.Logging
import org.apache.commons.io.FileUtils
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Column, DataFrame, Encoders, SparkSession}
//import org.slf4j.LoggerFactory
import PercentileApprox._
/**
  * 数据集智能分析
  */
class DataSkewAnalyzer extends Serializable with Logging {
//  val logger = LoggerFactory.getLogger(this.getClass)

  def demo(): Unit = {
    //  val sparkConfig =
    val spark = SparkSession.builder().master("local").getOrCreate()
    // 默认是0，仅支持0-2
    val percentileFactor: Int = 2
    val skewFactor: Double = 0.5
//    val mainTablePath = ""
//    val otherTablePath = ""
//    val df1 = spark.read.parquet(mainTablePath)
//    val df2 = spark.read.parquet(otherTablePath)

    //  df1.union(df2)
    //  val ts = ""
    //  val keys = Seq("", "")
    //  val sortKeys = keys + ts
    //  df1.groupBy().agg(max("xx"))
    //  df1.groupBy().stat.approxQuantile()
    //  df1.groupBy()


    import spark.implicits._
    val simpleData = Seq(("James","Sales","NY",90000,34,10000),
      ("James","Sales","NY",86000,56,20000),
      ("James","Sales","CA",81000,30,30000),
      ("James","Finance","CA",90000,24,40000),
      ("James","Finance","CA",99000,40,50000),
      ("James","Finance","NY",83000,36,60000),
      ("James","Finance","NY",83000,36,70000),
      ("James","Finance","NY",83000,36,80000),
      ("James","Finance","NY",83000,36,90000),
      ("James","Finance","NY",83000,36,100000),
      ("Jen","Finance","NY",79000,53,15000),
      ("Jen","Marketing","CA",80000,25,18000),
      ("Jen","Marketing","NY",91000,50,21000)
    )
    val df1 = simpleData.toDF("employee_name","department","state","salary","age","bonus")

    val sqlContext = spark.sqlContext
//    sqlContext.udf.register("percentile_approx", percentile_approx(_: Column, _: Column, _: Int))


    df1.show()
    df1.createOrReplaceTempView("main_table")

    val ts = "bonus"
    var keys = Seq("employee_name", "department")
    val sortKeys = keys + ts
    println("df cnt:" + df1.count())
//    printRepartitionResult(df1, keys)
    import org.apache.spark.sql.functions._
//    df1.groupBy(keys.map(df1(_)): _*).agg()
//    var coordinate = df1.groupBy(keys.map(df1(_)): _*).agg(sum("bonus") as "total_sum",
//      $"employee_name",
//        approx_count_distinct("bonus") as "order_bonus",
//        mean("bonus"),
//        percentile_approx($"bonus", lit(0)) as "percentile_0",
//        percentile_approx($"bonus", lit(0.25)) as "percentile_1",
//        percentile_approx($"bonus", lit(0.5)) as "percentile_2",
//        percentile_approx($"bonus", lit(0.75)) as "percentile_3",
//        percentile_approx($"bonus", lit(1)) as "percentile_4",
//        max("bonus"),
//        min("bonus")
//    )
//    coordinate = coordinate..agg(count("employee_name"))


//    val coordinate = df1.groupBy(keys.map(df1(_)): _*)
//    coordinate.agg()
//    coordinate.explain()

    val per_path = "/Users/magnetowang/Documents/GitHub/paste/scala-paste/src/main/resources/spark/analyse_percent.sql"
    val per_code = FileUtils.readFileToString(new File(per_path))
    val coordinate  = sqlContext.sql(per_code)
    println(coordinate.schema.apply(2).name)
    coordinate.show()

    df1.agg(
      max("bonus"),
      min("bonus"),
//      count(),
    ).show()


    coordinate.createOrReplaceTempView("info_table")

    val sql_path = "/Users/magnetowang/Documents/GitHub/paste/scala-paste/src/main/resources/spark/add_column.sql"
    val sql_code = FileUtils.readFileToString(new File(sql_path))
    val res = sqlContext.sql(sql_code)
    res.show()
//    val colIndex = cols.map(input.columns.indexOf(_))
    val tag_index: Int = res.columns.indexOf("tag_wzx")
    val big_res = res.rdd.flatMap(row => {
      val arr = row.toSeq.toArray
      var arrays = Seq(row)
      val value = arr(tag_index)
//      System.out.println(String.format("value = %d, keys = %s, %s ts = %d", value.asInstanceOf[Int], arr(0).asInstanceOf[String], arr(1).asInstanceOf[String], arr(2).asInstanceOf[Int]))
      for (i <- 1 until value.asInstanceOf[Int]) {
//        System.out.println(value.asInstanceOf[Int] + " " + arr(0).asInstanceOf[String] + " " + arr(1).asInstanceOf[String] + " " + arr(2).asInstanceOf[Int])
        println("i = " + i)
        val temp_arr = row.toSeq.toArray
        temp_arr(tag_index) = i
        arrays = arrays :+ Row.fromSeq(temp_arr)
      }
      arrays
    })

    val window = sqlContext.createDataFrame(big_res, res.schema)
    window.show(100)
    val tags =  keys :+ "tag_wzx"
    val tsCols = tags :+ ts
    window.repartition(20, tags.map(window(_)): _*).sortWithinPartitions(tsCols.map(window(_)): _*).foreach(
      row => {
        println("rows_wzx" + row.toString())
      }
    )



//    val topDf = input.rdd.flatMap(row => {
//      val arr = row.toSeq.toArray
//      var arrays = Seq(row)
//      if (oldRow == null) {
//        flag = true
//      } else {
//        val oldArr = oldRow.toSeq.toArray
//        // 不同窗口分界线的条件，只需要考虑分界线的topN区别，不需要考虑topN之外的数据
//        for(index <- colIndex) {
//          if(!flag && oldArr(index) != arr(index)) {
//            flag = true
//          }
//        }
//      }
//      oldRow = row
//      if(flag && topN > 1) {
//        val valueCol = arr(valueIndex).asInstanceOf[Long]
//        val partId = (valueCol + offset - windowOp.bucketInfo.lowerBound) / windowOp.bucketInfo.bucketLen
//        if (partId != arr(partitionIndex)) {
//          arrays
//        } else {
//          log.debug(s"partId=$partId, value=$valueCol, offset=$offset")
//          arr(partitionIndex) = arr(partitionIndex).asInstanceOf[Integer] + partOffset
//          topN = topN - 1
//          if(topN == 1) {
//            flag = false
//            topN = windowOp.windowConfig.getAtLeast
//          }
//          arrays = arrays :+ Row.fromSeq(arr)
//          arrays
//        }
//      } else {
//        arrays
//      }
//    })

//    df1.join(coordinate).where("")
//    val res = df1.repartition(keys.map(df1(_)): _*).stat.approxQuantile(ts, Array[Double](0, 0.25, 0.5, 0.75, 1), 0.1)
//    res.foreach(println(_))
//    knifeData(df1, coordinate, keys, ts)
  }


//  def knifeData(data: DataFrame, coordinate: DataFrame, keys: Seq[String], ts: String): RDD[] = {
//    val df = data.repartition(keys.map(data(_)): _*)
//    df.rdd.mapPartitions(
//      rows => {
//        rows.flatMap(
//          row => {
//
//            Option(null)
//          }
//        )
//      }
//    )
//  }

  def increaseRows(data: DataFrame, tag: String): Unit = {
    import org.apache.spark.sql.functions._
    data.agg(avg("xx"))
  }


  def printRepartitionResult(data: DataFrame, keys: Seq[String]): Unit = {
//    import spark.implicits._
//    import org.apache.spark.sql.catalyst.encoders
    val df = data.repartition(keys.map(data(_)): _*)
//    df.show()
    data.rdd.flatMap(row => {

      println(row.toString())
      Option(null)
    })
//    df.rdd.mapPartitions(row => {
////      row.foreach()
//      val iter = row.flatMap(row => {
//        log.info("cool")
//        log.info(row.toString())
////        row.getLong(0)
//        Option(null)
////        row
//
//      })
//      iter
//    })
  }
}

object DataSkewAnalyzer extends Logging {
//  val logger = LoggerFactory.getLogger(this.getClass)
  def main(args: Array[String]): Unit = {
    log.info("开始数据集分析")
//    for( a <- 1 until 10){
//      println( "Value of a: " + a );
//    }

    val ds = new DataSkewAnalyzer()
    ds.demo()
  }
}
