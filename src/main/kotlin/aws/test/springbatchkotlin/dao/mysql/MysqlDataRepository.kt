package aws.test.springbatchkotlin.dao.mysql

import aws.test.springbatchkotlin.component.mysql.MysqlData
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MysqlDataRepository: CrudRepository<MysqlData, Long> {
    fun findFirstByName(name: String): MysqlData?
}