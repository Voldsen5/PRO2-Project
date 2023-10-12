package ex01;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class Ex01Test {

    @org.junit.jupiter.api.Test
    void calculateFine() {
        //Arrange
        Ex01 libary = new Ex01();
        //Act
        int actualResult = libary.calculateFine(LocalDate.of(22,9,20),LocalDate.of(22,9,30),true);
        //Assert
        assertEquals(60,actualResult);




    }
}