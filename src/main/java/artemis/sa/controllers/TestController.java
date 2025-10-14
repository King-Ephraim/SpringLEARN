/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package artemis.sa.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author code
 */
@RestController
@RequestMapping(path = "test")
public class TestController {
    
    @GetMapping(path = "string")
    public String getString(){
        return "chaine de caretere de SA" ;
    }
    
}
