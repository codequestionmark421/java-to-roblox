package com.codequestionmark;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class findjava {
    public findjava() throws URISyntaxException {

    }

    Path pathtojar = Paths.get(Main.class.getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .toURI())
            .getParent();
    File javafilefolder = pathtojar.resolve("JavaFiles").toFile();

    public File[] getjavafiles() {
        return javafilefolder.listFiles();
    }
}
