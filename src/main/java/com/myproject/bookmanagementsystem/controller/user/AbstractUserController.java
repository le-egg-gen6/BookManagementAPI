package com.myproject.bookmanagementsystem.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${api.prefix}" + "${api.version}" + "/user")
public abstract class AbstractUserController {
}
