package com.daou.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * com.daou.test.controller
 *
 * @DATE 2023-03-22
 * @Author daou
 * @Version 1.0
 */

@Controller
@Slf4j
public class ApiController {

  @RequestMapping(value = "/login", method = {RequestMethod.GET}, produces = "text/html; charset=utf-8")
  public String login(Model model){
    return "login.html";
  }

}
