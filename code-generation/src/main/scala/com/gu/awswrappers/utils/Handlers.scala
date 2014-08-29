package com.gu.awswrappers.utils

import com.amazonaws.handlers.AsyncHandler

import scala.concurrent.Promise
import scala.util.{Failure, Success}

object Handlers {
  def createHandler[A <: com.amazonaws.AmazonWebServiceRequest, B]() = {
    val promise = Promise[B]()

    val handler = new AsyncHandler[A, B] {
      override def onSuccess(request: A, result: B): Unit = promise.complete(Success(result))

      override def onError(exception: Exception): Unit = promise.complete(Failure(exception))
    }

    (promise.future, handler)
  }
}
