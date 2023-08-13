package com.chubanova.ioc;

import com.chubanova.Command;
import com.chubanova.Movable;
import com.chubanova.adapter.Loadable;
import lombok.RequiredArgsConstructor;


import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

@RequiredArgsConstructor
public class LoadAdapterCommand implements Command {
    private static final String PATH_CLASSES = Movable.class
            .getProtectionDomain()
            .getCodeSource().getLocation().getPath();
    private final Loadable loadable;
    private final Object[] classNames;

    @Override
    public void execute() {
        String className = String.valueOf(classNames[0]);
        Class returnClass = null;

        try {
            File file = new File(PATH_CLASSES);

            URL url = file.toURI().toURL();
            URL[] urls = new URL[]{url};

            ClassLoader cl = new URLClassLoader(urls);

            returnClass = cl.loadClass(className);
        } catch (Exception e) {
            e.printStackTrace();
        }

        loadable.setClasses(
                new Object[]{
                        returnClass
                }
        );

    }
}
