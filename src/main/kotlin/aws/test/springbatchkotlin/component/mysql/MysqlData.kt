package aws.test.springbatchkotlin.component.mysql

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "mysql_data")
data class MysqlData(@Id @GeneratedValue val id:Long?=-1, var name : String="")
