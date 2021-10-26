package codes.recursive.controller;

import codes.recursive.AutoCommand;
import codes.recursive.WhatToDoCommand;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.views.ModelAndView;
import io.micronaut.views.View;

import java.util.Map;

@Controller("/")
public class DefaultController {

    private String status = "green";
    private int speed = 0;
    private Boolean gimme = false;

    @Get(uri="/", produces= MediaType.TEXT_HTML)
    @View("index")
    public ModelAndView index() {
        return new ModelAndView("index", CollectionUtils.mapOf());
    }

    @Get(value = "/candy", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<Map<String, Object>> getCandy() {
        this.gimme = true;
        return HttpResponse.ok(
                CollectionUtils.mapOf(
                        "status", status
                )
        );
    }

    @Get(value = "/query", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<Map<String, Object>> query() {
        this.gimme = true;
        return HttpResponse.ok(
                CollectionUtils.mapOf(
                        "status", status,
                        "speed", speed
                )
        );
    }

    @Post(value = "auto", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public HttpResponse<Map<String, Object>> auto(AutoCommand autoCommand) {

        speed = autoCommand.getSpeed();
        return HttpResponse.ok(
                CollectionUtils.mapOf("status", true)
        );
    }

    @Post(value = "whattodo", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public HttpResponse<Map<String, Object>> auto(WhatToDoCommand whatToDoCommand) {
        status = whatToDoCommand.getStatus();
        Map gimmeMap = CollectionUtils.mapOf("gimme", this.gimme);
        gimme = false;
        return HttpResponse.ok(gimmeMap);
    }

}