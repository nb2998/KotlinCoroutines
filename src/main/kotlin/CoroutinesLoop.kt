import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicInteger

fun main(args: Array<String>) {
    val c = AtomicInteger()

    for(i in 0..1_000_000){
        GlobalScope.launch {
            c.addAndGet(i)
        }
    }

    println(c.get())
}