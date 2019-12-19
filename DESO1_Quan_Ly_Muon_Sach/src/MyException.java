/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tienanh
 */
public class MyException extends Exception{
    private int id;

    public MyException(int id) {
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
}
