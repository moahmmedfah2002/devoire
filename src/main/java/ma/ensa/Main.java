package ma.ensa;

import com.fasterxml.jackson.databind.ObjectMapper;
import ma.ensa.entity.Custumer;
import ma.ensa.thread.ThreadIn;
import ma.ensa.thread.ThreadOut;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
//
        Object mutex = new Object();

        ThreadIn threadIn = new ThreadIn(mutex);
        ThreadOut threadOut = new ThreadOut(mutex);

        threadIn.start();
        threadOut.start();

    }
}