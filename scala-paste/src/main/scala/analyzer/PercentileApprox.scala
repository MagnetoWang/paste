package analyzer

import org.apache.spark.sql.functions._
import org.apache.spark.sql.Column
import org.apache.spark.sql.catalyst.expressions.aggregate.ApproximatePercentile


object PercentileApprox {
  def percentile_approxx(col: Column, percentage: Column, accuracy: Column): Column = {
    val expr = new ApproximatePercentile(
      col.expr,  percentage.expr, accuracy.expr
    ).toAggregateExpression
    new Column(expr)
  }
  def percentile_approxx(col: Column, percentage: Column): Column = percentile_approxx(
    col, percentage, lit(ApproximatePercentile.DEFAULT_PERCENTILE_ACCURACY)
  )

  /**
    *
    * @param col
    * @param percentage
    * @param accu 必须大于0，值越大，就越精确
    * @return
    */
  def percentile_approxx(col: Column, percentage: Column, accu: Int = ApproximatePercentile.DEFAULT_PERCENTILE_ACCURACY): Column = {
    if (accu > 0) {
       percentile_approxx(col, percentage, lit(accu))
    } else {
      percentile_approxx(col, percentage, lit(ApproximatePercentile.DEFAULT_PERCENTILE_ACCURACY))
    }
  }

//
//  def percentile_approx(col: String, percentage: String, accu: Int = ApproximatePercentile.DEFAULT_PERCENTILE_ACCURACY): Column = {
//    if (accu > 0) {
//      percentile_approx(col, percentage, lit(accu))
//    } else {
//      percentile_approx(col, percentage, lit(ApproximatePercentile.DEFAULT_PERCENTILE_ACCURACY))
//    }
//  }
//
//  def percentile_approxx(col: String, percentage: String, accuracy: String): Column = {
//    val expr = new ApproximatePercentile(
//      col.expr,  percentage.expr, accuracy.expr
//    ).toAggregateExpression
//    new Column(expr)
//  }
}
