package com.gu.awswrappers.macros

import com.amazonaws.handlers.AsyncHandler

import scala.language.experimental.macros
import scala.reflect.macros._

object AwsClientWrapper {
  def wrapImpl[A: c.WeakTypeTag](c: whitebox.Context)(a: c.Expr[A]): c.Expr[Object] = {
    import c.universe._

    val className = TermName(c.freshName())

    val typ = weakTypeOf[A]

    val generatedMethods = for {
      method <- typ.members.filter(_.isMethod).map(_.asMethod)
      paramList <- method.paramLists
      if paramList.lastOption.exists(_.typeSignature =:= c.typeOf[AsyncHandler[_, _]])
    } yield {
      val methodName = method.name.decodedName
      val futureMethodName = TermName(methodName + "Future")
      val params = paramList.init
      val handlerParam = paramList.last

      val requestType :: resultType :: Nil = handlerParam.typeSignature.typeArgs

      def paramName(s: Symbol) = TermName(s.name.decodedName.toString)

      val futureMethodParams = params map { param =>
        q"""${paramName(param)}: ${param.typeSignature}"""
      }

      val paramNames = params.map(paramName(_))

      val methodTermName = TermName(methodName.toString)

      q"""
        def $futureMethodName($futureMethodParams) {
          val (future, handler) = com.gu.awswrappers.Handlers.createHandler[$requestType, $resultType]()
          $className.$methodTermName(..$paramNames, handler)
          future
        }
      """
    }

    if (generatedMethods.isEmpty) {
      c.abort(c.enclosingPosition, s"${a.actualType.getClass.getName} does not have any methods that " +
        "take an AsyncHandler as a parameter.")
    } else {
      c.Expr[Object](q"""
        {
          val $className = $a

          new {
            ..$generatedMethods
          }
        }
      """)
    }
  }

  def wrap[A](a: A) = macro wrapImpl[A]
}
