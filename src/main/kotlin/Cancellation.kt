import kotlinx.coroutines.*

fun main() = runBlocking{
    val job = launch {
        repeat(5000) {
            println("Iteration number $it")
            delay(500)
        }
    }

    delay(1500)
    println("Waiting")
//    job.cancel()
//    job.join()
    job.cancelAndJoin()
    println("End")
}