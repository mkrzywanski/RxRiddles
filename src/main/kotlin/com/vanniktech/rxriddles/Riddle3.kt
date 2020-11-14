package com.vanniktech.rxriddles

import io.reactivex.rxjava3.core.Observable

object Riddle3 {
  /**
   * Don't emit odd numbers from the [source] Observable.
   *
   * Use case: You want to filter certain items out.
   */
  fun solve(source: Observable<Int>): Observable<Int> {
    return source.filter {v ->  v % 2 == 0}
  }
}
