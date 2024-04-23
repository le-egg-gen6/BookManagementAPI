package com.myproject.bookmanagementsystem.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${api.prefix}" + "${api.version}" + "/manager")
public class AbstractManagerController {
}
