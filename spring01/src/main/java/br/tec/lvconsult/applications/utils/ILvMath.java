package br.tec.lvconsult.applications.utils;

public interface ILvMath {
    Double sum(String num1, String num2);
    Double sub(String num1, String num2);
    Double mult(String num1, String num2);
    Double div(String num1, String num2);
    Double avg(String num1, String num2);
    Double sqrt(String num1);
    Double mean(String num1, String num2);

    Double sum(Double num1, Double num2);
    Double sub(Double num1, Double num2);
    Double mult(Double num1, Double num2);
    Double div(Double num1, Double num2);
    Double avg(Double num1, Double num2);
    Double sqrt(Double num1);
    Double mean(Double num1, Double num2);
}
