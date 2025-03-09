package br.tec.lvconsult.applications.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class LvMathImpl implements ILvMath {

    @Autowired
    @Qualifier("lvNumberImpl")
    private ILvNumber lvNumber;

    @Override
    public Double sum(String num1, String num2) {
        return lvNumber.convertToDouble(num1) + lvNumber.convertToDouble(num2);
    }

    @Override
    public Double sub(String num1, String num2) {
        return lvNumber.convertToDouble(num1) - lvNumber.convertToDouble(num2);
    }

    @Override
    public Double mult(String num1, String num2) {
        return lvNumber.convertToDouble(num1) * lvNumber.convertToDouble(num2);
    }

    @Override
    public Double div(String num1, String num2) {
        return lvNumber.convertToDouble(num1) / lvNumber.convertToDouble(num2);
    }

    @Override
    public Double avg(String num1, String num2) {
        return (lvNumber.convertToDouble(num1) + lvNumber.convertToDouble(num2)) / 2;
    }

    @Override
    public Double sqrt(String num1) {
        return Math.sqrt(lvNumber.convertToDouble(num1));
    }

    @Override
    public Double mean(String num1, String num2) {
        return (lvNumber.convertToDouble(num1) + lvNumber.convertToDouble(num2)) / 2;
    }

    @Override
    public Double sum(Double num1, Double num2) {
        return num1 + num2;
    }

    @Override
    public Double sub(Double num1, Double num2) {
        return num1 - num2;
    }

    @Override
    public Double mult(Double num1, Double num2) {
        return num1 * num2;
    }

    @Override
    public Double div(Double num1, Double num2) {
        return num1 / num2;
    }

    @Override
    public Double avg(Double num1, Double num2) {
        return (num1 + num2) / 2;
    }

    @Override
    public Double sqrt(Double num1) {
        return Math.sqrt(num1);
    }

    @Override
    public Double mean(Double num1, Double num2) {
        return (num1 + num2) / 2;
    }
}
