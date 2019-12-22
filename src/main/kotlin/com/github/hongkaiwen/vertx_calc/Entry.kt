package com.github.hongkaiwen.vertx_calc

import com.github.hongkaiwen.vertx_calc.calc.CalcVerticle
import io.vertx.core.Vertx

fun main() {
    var vertx = Vertx.vertx()
    vertx.deployVerticle(CalcVerticle())
}