package structure.agent.project.utils;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

public class ClassUtil {

    private static final String class_suffix = ".class";


    public static List<Class> getAllClassByAnnotation(Class clazz,String packageName) {

        try {

            List<Class> allClass = getAllClass(packageName);

            return allClass.stream().filter((a)->{return a.isAnnotationPresent(clazz);}).collect(Collectors.toList());

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }


    private static List<Class> getAllClass(String packageName) {

        List<String> classNameList = getClassPathsByPackage(packageName);

        List<Class> list=classNameList.stream().map((b)->{

            try {
                return Class.forName(b);
            } catch (Throwable e) {
                return null;
            }

        }).filter(Objects::nonNull).distinct().collect(Collectors.toList());

        return list;

    }


    public static List<String> getClassPathsByPackage(String packageName) {

        List<String> fileNames = null;

        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        String packagePath = packageName.replace(".", "/");

        URL url = loader.getResource(packagePath);

        if (url != null) {

            String type = url.getProtocol();

            if (type.equals("file")) {

                String fileSearchPath = url.getPath();

                fileSearchPath = fileSearchPath.substring(0,fileSearchPath.indexOf("/classes"));

                fileNames = getClassPathsByFile(fileSearchPath);

            } else if (type.equals("jar")) {

                try{

                    JarURLConnection jarURLConnection = (JarURLConnection)url.openConnection();

                    JarFile jarFile = jarURLConnection.getJarFile();

                    fileNames = getClassPathsByJar(jarFile);

                }catch (IOException e){

                    throw new RuntimeException("open Package URL failed："+e.getMessage());

                }

            }else{

                throw new RuntimeException("file system not support! cannot load MsgProcessor！");

            }

        }

        return fileNames;

    }

    private static List<String> getClassPathsByFile(String filePath) {

        List<String> classPaths = new ArrayList<String>();

        try {

            Files.walkFileTree(Paths.get(new File(filePath).getAbsolutePath()), new SimpleFileVisitor<Path>() {

                @Override

                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                    String filePath = file.toFile().getPath();

                    if (filePath.endsWith(class_suffix)) {

                        filePath = filePath.substring(filePath.indexOf(File.separator + "classes") + 9, filePath.lastIndexOf("."));

                        filePath = filePath.replace(File.separator, ".").replace("/", ".").replace("\\", ".");

                        classPaths.add(filePath);

                    }

                    return super.visitFile(file, attrs);

                }

            });

        } catch (Exception e) {

            throw new RuntimeException("walk files error!", e);

        }

        return classPaths;
    }


    private static List<String> getClassPathsByJar(JarFile jarFile) {

        List<String> myClassName = new ArrayList<String>();

        try {

            Enumeration<JarEntry> entrys = jarFile.entries();

            while (entrys.hasMoreElements()) {

                JarEntry jarEntry = entrys.nextElement();

                String entryName = jarEntry.getName();

                if (entryName.endsWith(class_suffix)) {

                    entryName = entryName.replace(File.separator, ".").replace("/", ".").replace("\\", ".").substring(0, entryName.lastIndexOf("."));

                    myClassName.add(entryName);

                }

            }

        } catch (Exception e) {

            throw new RuntimeException("发生异常:" + e.getMessage());

        }

        return myClassName;

    }
}
