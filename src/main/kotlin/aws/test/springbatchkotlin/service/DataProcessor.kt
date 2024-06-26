package aws.test.springbatchkotlin.service

import aws.test.springbatchkotlin.component.DeliveredData
import aws.test.springbatchkotlin.component.mysql2.Mysql2Data
import aws.test.springbatchkotlin.component.mysql.MysqlData

interface DataProcessor {
    abstract fun combineData(mysql2DataList: List<Mysql2Data>, mysqlDataList: List<MysqlData>): List<DeliveredData>
}
