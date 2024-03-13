package com.ctempconverter.tempconverter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
public class TempConverterController {
    @GetMapping("/")
    public ModelAndView Load(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("TempConverter");
        return modelAndView;
    }

    @PostMapping("/Converter")
    public String converte(
            @RequestParam("temp1") double temp1,
            @RequestParam("type1") String type1,
            @RequestParam("type2") String type2,
            Model model
    ){
        double converter = 0;

        if(Objects.equals(type1, "Celsius")){
            if (Objects.equals(type2, "Fahrenheit")){
                converter = (temp1 * 9 / 5) + 32;
            }else{
                converter = temp1 + 273.15;
            }
        }else if(Objects.equals(type1, "Fahrenheit")){
            if(Objects.equals(type2, "Celsius")){
                converter = (temp1 - 32) * 5/9;
            }else{
                converter = (temp1 - 32) * 5/9 + 273.15;
            }
        }else if(Objects.equals(type1, "Kelvin")){
            if (Objects.equals(type2, "Celsius")) {
                converter = temp1 - 273.15;
            }else {
                converter = (temp1 - 273.15) * 9/5 + 32;
            }
        }

        model.addAttribute("converter", converter);
        return "TempConverter";
    }
}
