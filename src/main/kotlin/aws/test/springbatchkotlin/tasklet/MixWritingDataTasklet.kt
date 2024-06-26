package aws.test.springbatchkotlin.tasklet

import aws.test.springbatchkotlin.component.DataGetter
import aws.test.springbatchkotlin.component.SharedData
import aws.test.springbatchkotlin.service.DataProcessor
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.stereotype.Component

@Component
class MixWritingDataTasklet (
    private val sharedData: SharedData,
    private val dataProcessor: DataProcessor
) : Tasklet {
    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus {
        dataProcessor.combineData(sharedData.getMysql2Data(),  sharedData.getMysqlData())
        return RepeatStatus.FINISHED
    }
}