package com.geodis.rt.zenith.portal.webui.controller.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
