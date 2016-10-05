package com.davidkoudela.confluence.controlledpm.cloud.connect;

import com.davidkoudela.confluence.controlledpm.context.ControlledPMCloudContextProvider;

import java.io.*;
import java.nio.charset.StandardCharsets;
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
    private static final String CONTEXT_PATH = "/bptemplates/context";

    public static List<String> getResources() throws IOException {
        final File jarFile = new File(ControlledPMResourceManager.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        final String[] filters = { "bptemplates", "images" };
        List<String> resources = new LinkedList<String>();
        resources.add(CONTEXT_PATH);
        if (jarFile.isFile()) { // Executed from JRE directly
            final JarFile jar = new JarFile(jarFile);
            final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
            while(entries.hasMoreElements()) {
                final String name = entries.nextElement().getName();
                for (String filter : filters) {
                    if (name.startsWith(filter) && (0 != name.compareTo(filter + '/'))) {
                        resources.add('/' + name);
                    }
                }
            }
            jar.close();
        } else { // Executed from IDE
            for (File file : jarFile.listFiles()) {
                for (String filter : filters) {
                    if (0 == file.getName().compareTo(filter)) {
                        for (File file2 : file.listFiles()) {
                            resources.add('/' + file.getName() + '/' + file2.getName());
                        }
                    }
                }
            }
        }
        return resources;
    }

    public static InputStream getResourceStream(String resource) throws IOException {
        if (0 == resource.compareTo(CONTEXT_PATH)) {
            try {
                byte[] bytes = ControlledPMCloudContextProvider.retriveContext().getBytes(StandardCharsets.UTF_8);
                InputStream in = new ByteArrayInputStream(bytes);
                return in;
            } catch (Throwable t){
                System.out.println(t);
            }
            return null;
        } else {
            String resourcePath = resource.substring(1, resource.length());
            InputStream in = ControlledPMResourceManager.class.getClassLoader().getResourceAsStream(resourcePath);
            return in;
        }
    }
}
