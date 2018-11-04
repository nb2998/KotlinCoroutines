import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.*

fun main() = runBlocking {
    println("Start")
    val job = GlobalScope.launch {
        delay(1000)
        println("Launch")
    }
    println("End")
    job.join()          // waits for the job to complete in a non-blocking way
}