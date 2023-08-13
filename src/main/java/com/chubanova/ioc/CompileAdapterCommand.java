package com.chubanova.ioc;

import com.chubanova.Command;
import com.chubanova.adapter.Compilable;
import lombok.RequiredArgsConstructor;
import lombok.Value;


import javax.tools.*;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

//n
@RequiredArgsConstructor
public class CompileAdapterCommand implements Command {
    private static final String ADAPTER_PACKAGE ="com.chubanova.adapter.impl." ;
    private final Compilable compilable;
    private final Object[] javaFilesPath;

    @Override
    public void execute() {
        String javaFilePath = String.valueOf(javaFilesPath[0]);

        try {
            List<File> files = new ArrayList<>();
            files.add(Path.of(javaFilePath).toFile());


            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

            StandardJavaFileManager fileManager = compiler.getStandardFileManager(
                    null
                    , null
                    , null
            );

            Iterable<? extends JavaFileObject> javaFiles = fileManager.getJavaFileObjectsFromFiles(files);

            DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();

            JavaCompiler.CompilationTask task = compiler.getTask(
                    null,
                    fileManager,
                    diagnostics,
                    null,
                    null,
                    javaFiles
            );



            String compileFileName = ADAPTER_PACKAGE +
                    javaFilePath.substring(javaFilePath.lastIndexOf("/") + 1)
                            .replace(".java", "");


            compilable.setCompileFiles(
                    new Object[]{
                            compileFileName
                    }
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
