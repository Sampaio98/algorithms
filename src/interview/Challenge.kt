// Kotlin Live Coding Challenge
// ------------------------------------------------------
// PART A / Transaction Processing
// ------------------------------------------------------
/*
Implement the function below that validates, groups, and summarizes
a list of transactions.

DATA MODELS:

    data class RawTxn(
        val id: String,
        val merchantId: String?,
        val amount: BigDecimal?
    )

    sealed class Result {
        data class Summary(
            val merchantId: String,
            val total: BigDecimal,
            val count: Int
        ) : Result()

        data class Error(
            val id: String,
            val reason: Reason
        ) : Result()
    }

    enum class Reason { BAD_ID, BAD_MERCHANT, BAD_AMOUNT }

TASK:
    fun process(txns: List<RawTxn>): List<Result>

VALIDATION RULES:
    - id is blank. Reason.BAD_ID
    - merchantId is null or blank. Reason.BAD_MERCHANT
    - amount is null or ≤ 0. Reason.BAD_AMOUNT

VALID TXN RULES:
    1. Group by merchantId
    2. Produce a Summary(total = BigDecimal sum, count = number of items)
    3. Sort summaries by total descending

FINAL OUTPUT ORDER:
    1. Summaries first (sorted)
    2. Errors after (any order)

SAMPLE INPUT FOR TESTING:

    val sample = listOf(
        RawTxn("t1", "m1", BigDecimal("100.00")),
        RawTxn("t2", "m1", BigDecimal("50.00")),
        RawTxn("t3", "m2", BigDecimal("200.00")),
        RawTxn("", "m3", BigDecimal("10.00")),
        RawTxn("t5", null, BigDecimal("15.00")),
        RawTxn("t6", "m4", BigDecimal("-5.00"))
    )
*/

// Your implementation here:
// fun process(txns: List<RawTxn>): List<Result> { }

// (txns: List<RawTxn>): List<Result> { }


// ------------------------------------------------------
// PART B / TTL Cache
// ------------------------------------------------------
/*
Implement a simple in-memory TTL cache with expiration.

API TO IMPLEMENT:

    class TtlCache<K, V>(private val ttlMs: Long) {

        fun put(key: K, value: V)

        /**
         * Returns the value if it exists AND has not expired.
         * Reading (get) must refresh the TTL for that key.
         */
        fun get(key: K): V?
    }

FUNCTIONAL REQUIREMENTS:
    - Store value + last access time for each key
    - A key expires when (currentTime - lastAccessTime) > ttlMs
    - get() returns null if expired
    - get() refreshes TTL
    - No background cleanup required
    - Use System.currentTimeMillis()

EXAMPLE TEST:

    val cache = TtlCache<String, String>(1000)
    cache.put("a", "hello")
    println(cache.get("a"))
    Thread.sleep(1200)
    println(cache.get("a"))  // expected: null
*/

// Your implementation here:
// class TtlCache<K, V>(private val ttlMs: Long) {
//     fun put(key: K, value: V) { }
//     fun get(key: K): V? { return null }
// }
//     fun get(key: K): V? { return null }

package interview

import java.math.BigDecimal
import java.util.Optional

class Challenge {

    companion object {
        val sample = listOf(
            RawTxn("t1", "m1", BigDecimal("100.00")),
            RawTxn("t2", "m1", BigDecimal("50.00")),
            RawTxn("t3", "m2", BigDecimal("200.00")),
            RawTxn("", "m3", BigDecimal("10.00")),
            RawTxn("t5", null, BigDecimal("15.00")),
            RawTxn("t6", "m4", BigDecimal("-5.00"))
        )

        @JvmStatic
        fun main(args: Array<String>) {
            //-------------------------------
            //PART A / Transaction Processing
            //-------------------------------
            println(Challenge().process(sample))

            //-------------------------------
            //PART B / TTL Cache
            //-------------------------------

            val cache = TtlCache<String, String>(1000)
            cache.put("a", "hello")
            println(cache.get("a"))
            Thread.sleep(1200)
            println(cache.get("a"))  // expected: null
        }
    }

// Kotlin Live Coding Challenge
// ------------------------------------------------------
// PART A / Transaction Processing
// ------------------------------------------------------

    data class RawTxn(
        val id: String,
        val merchantId: String?,
        val amount: BigDecimal?
    )

    sealed class Result {
        data class Summary(
            val merchantId: String,
            val total: BigDecimal,
            val count: Int
        ) : Result()

        data class Error(
            val id: String,
            val reason: Reason
        ) : Result()
    }

    enum class Reason { BAD_ID, BAD_MERCHANT, BAD_AMOUNT }


    fun process(txns: List<RawTxn>): List<Result> {
        val result = mutableListOf<Result>()

        txns.forEach { it ->
            val reason = validateItem(it)
            if (reason.isPresent) result.add(Result.Error(it.id, reason.get()))
            else addSummary(it, result)
        }

        val orderedSummaries = result
            .filterIsInstance<Result.Summary>()
            .sortedByDescending { it.total }

        return orderedSummaries + result.filterIsInstance<Result.Error>()
    }

    private fun validateItem(item: RawTxn): Optional<Reason> {
        if (item.id.isBlank()) {
            return Optional.of(Reason.BAD_ID)
        }
        if (item.merchantId.isNullOrBlank()) {
            return Optional.of(Reason.BAD_MERCHANT)
        }
        if (item.amount == null || item.amount <= BigDecimal.ZERO) {
            return Optional.of(Reason.BAD_AMOUNT)
        }
        return Optional.empty()
    }

    private fun addSummary(txn: RawTxn, result: MutableList<Result>) {
        val amount = txn.amount!!
        val merchantId = txn.merchantId!!

        result.filter { it is Result.Summary }.forEachIndexed { index, it ->
            it as Result.Summary
            if (it.merchantId == merchantId) {
                val count = it.count + 1
                val amount: BigDecimal = amount.plus(it.total)
                result[index] = it.copy(total = amount, count = count)
            } else {
                result.add(Result.Summary(merchantId, amount, 1))
                return
            }
        }
        if (result.isEmpty()) result.add(Result.Summary(merchantId, amount, 1))
    }


// ------------------------------------------------------
// PART B / TTL Cache
// ------------------------------------------------------

    /**
     * Returns the value if it exists AND has not expired.
     * Reading (get) must refresh the TTL for that key.
     */

    class TtlCache<K, V>(private val ttlMs: Long) {
        val dataList = mutableMapOf<K, V>()
        var lastAccessTime = System.currentTimeMillis()

        fun put(key: K, value: V) {
            if (get(key) == null) {
                dataList[key] = value
            }
        }

        fun get(key: K): V? {
            if (System.currentTimeMillis() - lastAccessTime > this.ttlMs) return null
            lastAccessTime = System.currentTimeMillis()
            return dataList[key]
        }
    }
}



