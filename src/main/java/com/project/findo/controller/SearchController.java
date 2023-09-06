package com.project.findo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    
     /*
      * api/homeposts/?amount=amount -> get all post of found things and wanted things by
      */

      @GetMapping("/homeposts/{amount}")
      public String getHomePostsForAmount(@RequestParam int amount){
         return "dsdfsd";
       }
}
