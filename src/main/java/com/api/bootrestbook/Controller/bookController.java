package com.api.bootrestbook.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class bookController {
    @RequestMapping(value = "/books" , method = RequestMethod.GET)
    @ResponseBody
    public String getBooks()
    {
        return "This is testing book first";
    }
}
