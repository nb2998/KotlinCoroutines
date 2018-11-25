import kotlinx.coroutines.*

fun main() = runBlocking{
    val job = launch {
        withTimeout(8000) {
            repeat(5000) {
                println("Iteration number $it")
                delay(100)
            }
        }
    }

//    delay(5000)
    println("Waiting")
//    job.cancel()
//    job.join()
//    job.cancelAndJoin()
    println("End")
}