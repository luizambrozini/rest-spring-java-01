package br.tec.lvconsult.controllers;

import br.tec.lvconsult.exceptions.UnsuportedMathOperationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/sum/{num1}/{num2}")
    public Double sum(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) {
        if(!isNumeric(num1) || !isNumeric(num2)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(num1) + convertToDouble(num2);
    }

    @GetMapping("/sub/{num1}/{num2}")
    public Double sub(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) {
        if(!isNumeric(num1) || !isNumeric(num2)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(num1) - convertToDouble(num2);
    }

    @GetMapping("/mult/{num1}/{num2}")
    public Double mult(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) {
        if(!isNumeric(num1) || !isNumeric(num2)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(num1) * convertToDouble(num2);
    }

    @GetMapping("/div/{num1}/{num2}")
    public Double div(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) {
        if(!isNumeric(num1) || !isNumeric(num2)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        if(convertToDouble(num2) == 0) {
            throw new UnsuportedMathOperationException("Division by zero is not allowed!");
        }
        return convertToDouble(num1) / convertToDouble(num2);
    }

    @GetMapping("/avg/{num1}/{num2}")
    public Double avg(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) {
        if(!isNumeric(num1) || !isNumeric(num2)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return (convertToDouble(num1) + convertToDouble(num2)) / 2;
    }

    @GetMapping("/sqrt/{num}")
    public Double sqrt(
            @PathVariable("num") String num
    ) {
        if(!isNumeric(num)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return Math.sqrt(convertToDouble(num));
    }

    @GetMapping("/mean/{num1}/{num2}")
    public Double mean(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) {
        if(!isNumeric(num1) || !isNumeric(num2)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return (convertToDouble(num1) + convertToDouble(num2)) / 2;
    }

    private Double convertToDouble(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
