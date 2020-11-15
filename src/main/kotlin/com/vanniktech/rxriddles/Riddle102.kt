package com.vanniktech.rxriddles

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.schedulers.Schedulers

object Riddle102 {
  /**
   * Execute both [first] and [second] Single's in parallel and provide both results as a pair.
   *
   * Use case: Execute two network requests in parallel and wait for each other and process the combined data.
   */
  fun solve(first: Single<Int>, second: Single<Int>): Single<Pair<Int, Int>> {
    val firstAsync = first.subscribeOn(Schedulers.io())
    val secondAsync = second.subscribeOn(Schedulers.io())
    return firstAsync.zipWith(secondAsync, BiFunction { t1, t2 -> t1 to t2 })
  }
}
