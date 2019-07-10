package com.ms.appservice.controller;


import com.ms.appservice.model.Skill;
import com.ms.appservice.service.SkillService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "${app.url}" + "/skill")
public class SkillController extends BaseController<SkillService, Skill> {

}
