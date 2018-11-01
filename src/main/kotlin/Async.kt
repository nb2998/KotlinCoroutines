import kotlinx.coroutines.*

fun main() {
    val deferred = (1..1_000_000).map { x ->
        GlobalScope.async {
            x
        }
    }

    GlobalScope.async {
        calculateSum(deferred)
    }
}

suspend fun calculateSum(deferred: List<Deferred<Int>>) {
    val sum = deferred.sumBy { it.await() }
    delay(1000)
    println(sum)
}

/*
IMPORTANT DIFF bw Async and launch
launch is used to fire and forget coroutine. It is like starting a new thread.
If the code inside the launch terminates with exception, then it is treated like uncaught exception in a thread
 -- usually printed to stderr in backend JVM applications and crashes Android applications.
  join is used to wait for completion of the launched coroutine and it does not propagate its exception.
  However, a crashed child coroutine cancels its parent with the corresponding exception, too.
async is used to start a coroutine that computes some result.
 The result is represented by an instance of Deferred and you must use await on it.
 An uncaught exception inside the async code is stored inside the resulting Deferred
 and is not delivered anywhere else, it will get silently dropped unless processed.
 You MUST NOT forget about the coroutine you’ve started with async.
 */
