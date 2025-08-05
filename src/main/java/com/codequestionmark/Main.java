package com.codequestionmark;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

import com.codequestionmark.findjava;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {
        Main newmain = new Main();

        newmain.init();
    }

    public void init() {
        try {
            findjava folderfind = new findjava();

            File[] files = folderfind.getjavafiles();
            if (files == null) { System.out.print("no files found"); return; }

            for (int i = 0; i < files.length; i++) {
                parsefile(files[i]);
            }
        } catch (URISyntaxException e) {
            System.out.print("parsing failed");
            e.printStackTrace();
        }
    }

    private void parsefile(File path) {
        try {
            CompilationUnit cu = StaticJavaParser.parse(path);


            cu.findAll(ClassOrInterfaceDeclaration.class).forEach(c -> {
                System.out.println("Class: " + c.getName());
                c.getMethods().forEach(m -> System.out.println("  Method: " + m.getName()));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
