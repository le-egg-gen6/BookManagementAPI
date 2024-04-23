package com.myproject.bookmanagementsystem.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${api.prefix}" + "${api.version}" + "/admin")
public abstract class AbstractAdminController {
}
