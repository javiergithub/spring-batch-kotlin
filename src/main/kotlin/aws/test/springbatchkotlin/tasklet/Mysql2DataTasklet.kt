package aws.test.springbatchkotlin.tasklet

import aws.test.springbatchkotlin.component.DataGetter
import aws.test.springbatchkotlin.component.SharedData
import aws.test.springbatchkotlin.component.mysql2.Mysql2Data
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.stereotype.Component

@Component
class Mysql2DataTasklet (
    private val dataGetter: DataGetter,
    private val sharedData: SharedData
) : Tasklet {
    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus {
        var mysql2Data : Mysql2Data? = dataGetter.getDataFromMysql2DB()
        if (mysql2Data == null){
            mysql2Data = Mysql2Data(null,"Mysql2")
        }
        sharedData.addMysql2Data(mysql2Data)
        return RepeatStatus.FINISHED
    }
}