package com.vanniktech.rxriddles

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.schedulers.Schedulers

object Riddle6 {
  /**
   * Execute both [first] and [second] Single's in parallel and provide both results as a pair.
   * Assume both [first] and [second] will execute on a different thread already.
   * This is a slightly simpler version of [Riddle102], where no schedulers are applied by default.
   *
   * Use case: Execute two network requests in parallel and wait for each other and process the combined data.
   */
  fun solve(first: Single<Int>, second: Single<Int>): Single<Pair<Int, Int>> {
    val firstAsync = first.observeOn(Schedulers.io())
    val secondAsync = second.observeOn(Schedulers.io())
    return Single.zip(firstAsync, secondAsync, BiFunction { t1, t2 ->  Pair(t1, t2)})
  }
}
