package com.vanniktech.rxriddles

import io.reactivex.rxjava3.core.Single
import java.lang.IllegalArgumentException

object Riddle14 {
  /**
   * Try the given [source] up to three times unless an [IllegalArgumentException] has been emitted.
   *
   * Use case: Retry an operation for a number of times or until a valid error occurred.
   */
  fun solve(source: Single<Unit>): Single<Unit> =
    source.retry(2) { it !is IllegalArgumentException }

}
