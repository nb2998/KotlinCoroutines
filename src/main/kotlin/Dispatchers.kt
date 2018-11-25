import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    launch {
        println("I'm working in thread ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Default) {
        println("I'm working in thread ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Unconfined) {
        println("I'm working in thread ${Thread.currentThread().name}")
    }
    launch(newSingleThreadContext("New Thread")) {
        println("I'm working in thread ${Thread.currentThread().name}")
    }
}