package com.github.hongkaiwen.vertx_calc.calc

import io.vertx.core.AbstractVerticle
import io.vertx.core.Promise
import io.vertx.ext.web.Router

const val PORT = 7777

class CalcVerticle : AbstractVerticle(){

    override fun start(promise: Promise<Void>) {
        var router = Router.router(vertx)
        router.get("/add").handler {
            var a = it.request().getParam("a")?.toInt() ?: 0
            var b = it.request().getParam("b")?.toInt() ?: 0
            it.request().response().end("${a + b}")
        }

        router.get("/sub").handler {
            var a = it.request().getParam("a")?.toInt() ?: 0
            var b = it.request().getParam("b")?.toInt() ?: 0
            it.request().response().end("${a - b}")
        }

        var server = vertx.createHttpServer()

        server.requestHandler(router).listen(PORT){
            if (it.succeeded()) {
                promise.complete()
                println("listen on $PORT")
            } else {
                promise.fail(it.cause())
            }
        }

    }

}