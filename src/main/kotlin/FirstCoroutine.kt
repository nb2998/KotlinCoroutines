import kotlinx.coroutines.*

fun main(args: Array<String>) {
    println("Start")

    GlobalScope.launch {
        delay(1000)
        println("Inside launch")
    }

    Thread.sleep(2000) // required
    println("End")

    println("Start 2")

    runBlocking {
        println("Inside run blocking")
    }

//    Thread.sleep(2000) // not required
    println("End")

}
