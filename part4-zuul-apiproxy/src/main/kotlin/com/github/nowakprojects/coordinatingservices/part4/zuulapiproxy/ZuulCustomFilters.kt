package com.github.nowakprojects.coordinatingservices.part4.zuulapiproxy

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import org.springframework.stereotype.Component
import java.time.Duration
import java.time.Instant
import java.time.temporal.ChronoUnit

@Component
internal class ProxyFilter : ZuulFilter() {

    override fun run(): Any? {
        println("calling a filter")
        return null
    }

    override fun shouldFilter(): Boolean {
        val context = RequestContext.getCurrentContext()
        val param = context.request.getParameter("source")
        return param?.equals("mobile") ?: false
    }

    override fun filterType(): String = "pre"

    override fun filterOrder(): Int  = 1

}

@Component
internal class StartPreFilter : ZuulFilter(){
    override fun run(): Any? {
        val context = RequestContext.getCurrentContext()
        context.set("starttime", Instant.now())
        return null;
    }

    override fun shouldFilter(): Boolean  = true

    override fun filterType(): String  = "pre"

    override fun filterOrder(): Int  = 1

}


@Component
internal class StopPostFilter : ZuulFilter(){
    override fun run(): Any? {
        val stop = Instant.now()
        val context = RequestContext.getCurrentContext()
        val start = context["starttime"] as Instant
        val secondsDifference = ChronoUnit.MILLIS.between(start,stop)
        println("Call took $secondsDifference milliseconds")
        return null;
    }

    override fun shouldFilter(): Boolean  = true

    override fun filterType(): String  = "post"

    override fun filterOrder(): Int  = 1

}
