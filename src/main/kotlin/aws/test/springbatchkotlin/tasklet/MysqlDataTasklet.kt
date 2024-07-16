package aws.test.springbatchkotlin.tasklet

import aws.test.springbatchkotlin.component.DataGetter
import aws.test.springbatchkotlin.component.SharedData
import aws.test.springbatchkotlin.component.mysql.MysqlData
import aws.test.springbatchkotlin.component.mysql2.Mysql2Data
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.stereotype.Component

@Component
class MysqlDataTasklet (
    private val dataGetter: DataGetter,
    private val sharedData: SharedData
) : Tasklet {
    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus {
        var mysqlData : MysqlData? = dataGetter.getDataFromMysqlDB()
        if (mysqlData == null){
            mysqlData = MysqlData(null,"Mysql")
        }
        sharedData.addMysqlData(mysqlData)
        return RepeatStatus.FINISHED
    }
}