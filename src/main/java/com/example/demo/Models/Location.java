package com.example.demo.Models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Location {
    private int shellNumber;
    private int binNumber;

    public int getShellNumber() {
        return shellNumber;
    }

    public void setShellNumber(int shellNumber) {
        this.shellNumber = shellNumber;
    }

    public int getBinNumber() {
        return binNumber;
    }

    public void setBinNumber(int binNumber) {
        this.binNumber = binNumber;
    }

    @Override
    public String toString() {
        return "Location{" +
                "shellNumber=" + shellNumber +
                ", binNumber=" + binNumber +
                '}';
    }
}
