package aws.test.springbatchkotlin.service

import aws.test.springbatchkotlin.component.DeliveredData
import aws.test.springbatchkotlin.component.mysql2.Mysql2Data
import aws.test.springbatchkotlin.component.mysql.MysqlData
import org.springframework.stereotype.Service

@Service
class DataProcessorImpl(): DataProcessor {
    override fun combineData(mysql2DataList: List<Mysql2Data>, mysqlDataList: List<MysqlData>): List<DeliveredData> {
        val deliverDataList = mutableListOf<DeliveredData>()
        for (mysql2Data in mysql2DataList) {
            val deliveredData : DeliveredData = DeliveredData(null,mysql2Data.name)
            deliverDataList.add(deliveredData)
        }
        return deliverDataList
    }
}