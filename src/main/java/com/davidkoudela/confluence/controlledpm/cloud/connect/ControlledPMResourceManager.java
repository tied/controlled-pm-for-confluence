package com.davidkoudela.confluence.controlledpm.cloud.connect;

import java.io.*;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Description: Resource Manager
 *              Right now it is for testing purposes
 * Copyright (C) 2016 David Koudela
 *
 * @author dkoudela
 * @since 2016-10-01
 */
public class ControlledPMResourceManager {
    public static List<String> getResources() throws IOException {
        final File jarFile = new File(ControlledPMResourceManager.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        final String[] filters = { "bptemplates", "images" };
        List<String> resources = new LinkedList<String>();
        if (jarFile.isFile()) { // Executed from JRE directly
            final JarFile jar = new JarFile(jarFile);
            final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
            while(entries.hasMoreElements()) {
                final String name = entries.nextElement().getName();
                for (String filter : filters) {
                    if (name.startsWith(filter)) {
                        System.out.println(name);
                    }
                }
            }
            jar.close();
        } else { // Executed from IDE
            for (File file : jarFile.listFiles()) {
                for (String filter : filters) {
                    if (0 == file.getName().compareTo(filter)) {
                        for (File file2 : file.listFiles()) {
                            System.out.println("Content : " + file2.getAbsolutePath());
                            resources.add('/' + file.getName() + '/' + file2.getName());
                        }
                    }
                }
            }
        }
        return resources;
    }

    public static InputStream getResourceStream(String resource) throws FileNotFoundException {
        final File jarFile = new File(ControlledPMResourceManager.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        InputStream in = null;
        if (jarFile.isFile()) { // Executed from JRE directly
        } else { // Executed from IDE
            File theResourceFile = new File(jarFile.getAbsolutePath() + resource);
            in = new FileInputStream(theResourceFile);
        }
        return in;
    }
}
