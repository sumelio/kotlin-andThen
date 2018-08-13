import org.springframework.boot.autoconfigure.SpringBootApplication
import java.util.function.Function


@SpringBootApplication
object Application {
/*
    fun beforeTotalSales(pointCut: JoinPoint, correlationId: UUID, repaymentId: UUID, accountId: Int, retryContext: RetryContext) {

        logger.info("correlationId:{}, retry:{}, Methods : {}", correlationId, retryContext.retryCount, pointCut.signature.toShortString())

        val request = "accountId=$accountId, retryContext=$retryContext"
        val startTime = LocalDateTime.now()

        recordLog(pointCut, pointCut.args[0], repaymentId, request, retryContext, startTime)
    }
*/

    fun doTransfers(s: String): String {

        print("doTransfers s=$s")

        val out = "%s%s".format(s, s)

        print(" out s=$out, ")
        return out
    }

    fun isTransfersAccreditation(s: String): String {

        print("input s=$s")

        val out = "%s%s".format(s, s)

        print(" out s=$out, ")
        return out
    }


    fun withRetryGetTotalSales(s: String): Int {

        println("[withRetryGetTotalSales s=$s")

        val out = s.length

        print(" out s=$out],  ")
        //throw RuntimeException("Fin")
        return out
    }


    fun calculateRepayment(s: Int): String {

        print("[calculateRepayment s=$s")

        val out = "$s"

        print(" out s=$out],  ")
        return out
    }

    val getTotalSales = { it: String ->
        println("[withRetryGetTotalSales s=$it")

        val out = it.length

        print(" out s=$out],  ")

        out

    }

    val calculateRepaymenta = ::calculateRepayment

    infix fun <F : (T1) -> T2, T1, T2, T3> F.andThen(n: (T2) -> T3): (T1) -> T3 = { n(this(it)) }

    @JvmStatic
    fun main(args: Array<String>) {

        val byName = { o1: String, o2: String -> o1.toString().compareTo(o2.toString()) }


        //print("test " + byName("a" , "dos"))


        //val funcYouUp = JavaFunc.uptown(func)

        // this, as well as something akin to Java's Function.compose, should probably be built into Standard.kt


        infix fun <T, R, V> ((T) -> R).isOkThen(other: (R) -> V): ((T) -> V) = { other(this(it)) }


        // the Java code is doing the equivalent of this line here
        /*  fun <T,F> uptown(funkYouUp: (T)->T,
                                addB: (T)-> F) =*/

        val refrain = "Casilda"

        val executeRepayment =
                getTotalSales andThen
                        calculateRepaymenta andThen
                                getTotalSales andThen
                                      calculateRepaymenta


        val repaymentFLowExecute =
                (::withRetryGetTotalSales
                        andThen ::calculateRepayment
                        andThen ::doTransfers
                        andThen ::isTransfersAccreditation
                        )

        System.out.println(repaymentFLowExecute(refrain));

        System.out.println(executeRepayment(refrain));

        //  SpringApplication.run(Application::class.java, args)
    }
}


object JavaFunc {
    fun <T> uptown(funkYouUp: Function<T, T>): Function<T, T> {
        return funkYouUp.andThen(funkYouUp).andThen(funkYouUp)
    }
}