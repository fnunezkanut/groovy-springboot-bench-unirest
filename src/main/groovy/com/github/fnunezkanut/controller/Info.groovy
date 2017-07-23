package com.github.fnunezkanut.controller

import com.mashape.unirest.http.HttpResponse
import com.mashape.unirest.http.JsonNode
import com.mashape.unirest.http.Unirest
import com.mashape.unirest.request.HttpRequestWithBody
import groovy.json.JsonSlurper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody



@Controller
@EnableAutoConfiguration
class Info {


	@RequestMapping(
		value = "/info",
		method = RequestMethod.GET,
		produces = "application/json"
	)
	@ResponseBody
	HashMap<String, String> info() {

		final Logger logger = LoggerFactory.getLogger(Info.class)
		final String url = 'http://10.0.0.13:8080/info'
		
		final HttpResponse<String> response = Unirest.get( url ).asString()

		final String body = response.body

		final HashMap<String, String> message = new JsonSlurper().parseText( body ) as HashMap<String,String>

		return message
	}

}
