/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.model;

/**
 *
 * @author sebastianmahlke
 */
public enum Rating {
    
    VERY_GOOD(5),
    GOOD(4),
    OK(3),
    BAD(2),
    HORRIBLE(1);
    
    private int value;
    
    Rating (int rating) {
        this.value = rating;
    }
    
    public static Rating getRatingForValue(int value) {
        switch (value) {
            case 5:
                return Rating.VERY_GOOD;
            case 4:
                return Rating.GOOD;
            case 3:
                return Rating.OK;
            case 2:
                return Rating.BAD;
            case 1:
                return Rating.HORRIBLE;
        }
        return null;
    }
    
    public int getValue() {
        return this.value;
    }
    
}
