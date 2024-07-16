package aws.test.springbatchkotlin.component

import aws.test.springbatchkotlin.component.mysql.MysqlData
import aws.test.springbatchkotlin.component.mysql2.Mysql2Data
import aws.test.springbatchkotlin.dao.mysql.MysqlDataRepository
import aws.test.springbatchkotlin.dao.mysql2.Mysql2DataRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DataGetter(@Autowired val mysqlDataRepository: MysqlDataRepository,
    @Autowired  val mysql2DataRepository: Mysql2DataRepository) {
    fun getDataFromMysql2DB(): Mysql2Data? {
        var mysql2Data: Mysql2Data? = null
        mysql2DataRepository.findFirstByName(name = "Mysql2").let { org -> // Type of 'org': Organization
            mysql2Data = org
        }
        return mysql2Data
    }

    fun getDataFromMysqlDB(): MysqlData? {
        var mysqlData: MysqlData? = null
        mysqlDataRepository.findFirstByName(name = "Mysql").let { org -> // Type of 'org': Organization
            mysqlData = org
        }
        return mysqlData
    }
}