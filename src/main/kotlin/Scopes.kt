import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    launch {                // not Global, belongs to scope
//        delay(1000)
        println("From runblocking")
    }

    coroutineScope {
        launch {
//            delay(3000)
            println("From nested launch")
        }

//        delay(2000)
        println("From coroutine scope")
    }

    println("Coroutine scope over")
}

//Instead of launching coroutines in the GlobalScope, just like we usually do with threads
// (threads are always global), we can launch coroutines in the specific scope of the operation we are performing.