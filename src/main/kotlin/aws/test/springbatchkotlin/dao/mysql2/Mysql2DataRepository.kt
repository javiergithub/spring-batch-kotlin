package aws.test.springbatchkotlin.dao.mysql2

import aws.test.springbatchkotlin.component.mysql2.Mysql2Data
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface Mysql2DataRepository: CrudRepository<Mysql2Data, Long> {
    fun findFirstByName(name: String): Mysql2Data?
}