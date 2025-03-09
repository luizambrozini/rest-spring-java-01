package br.tec.lvconsult.controllers;

import br.tec.lvconsult.applications.utils.ILvMath;
import br.tec.lvconsult.applications.utils.ILvNumber;
import br.tec.lvconsult.exceptions.UnsuportedMathOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/math")
public class MathController {


    @Autowired
    @Qualifier("lvMathImpl")
    private ILvMath lvMath;

    @Autowired
    @Qualifier("lvNumberImpl")
    private ILvNumber lvNumber;


    @GetMapping("/sum/{num1}/{num2}")
    public Double sum(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) {
        if(!lvNumber.isNumeric(num1) || !lvNumber.isNumeric(num2)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return lvMath.sum(num1, num2);
    }

    @GetMapping("/sub/{num1}/{num2}")
    public Double sub(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) {
        if(!lvNumber.isNumeric(num1) || !lvNumber.isNumeric(num2)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return lvMath.sub(num1,num2);
    }

    @GetMapping("/mult/{num1}/{num2}")
    public Double mult(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) {
        if(!lvNumber.isNumeric(num1) || !lvNumber.isNumeric(num2)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return lvMath.mult(num1,num2);
    }

    @GetMapping("/div/{num1}/{num2}")
    public Double div(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) {
        if(!lvNumber.isNumeric(num1) || !lvNumber.isNumeric(num2)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        if(lvNumber.convertToDouble(num2) == 0) {
            throw new UnsuportedMathOperationException("Division by zero is not allowed!");
        }
        return lvMath.div(num1, num2);
    }

    @GetMapping("/avg/{num1}/{num2}")
    public Double avg(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) {
        if(!lvNumber.isNumeric(num1) || !lvNumber.isNumeric(num2)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return lvMath.avg(num1, num2);
    }

    @GetMapping("/sqrt/{num}")
    public Double sqrt(
            @PathVariable("num") String num
    ) {
        if(!lvNumber.isNumeric(num)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return lvMath.sqrt(num);
    }

    @GetMapping("/mean/{num1}/{num2}")
    public Double mean(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) {
        if(!lvNumber.isNumeric(num1) || !lvNumber.isNumeric(num2)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return lvMath.mean(num1, num2);
    }



}
