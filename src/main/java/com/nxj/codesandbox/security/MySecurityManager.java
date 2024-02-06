package com.nxj.codesandbox.security;

import java.io.File;
import java.io.IOException;
import java.security.Permission;

public class MySecurityManager extends SecurityManager {

    // 检查所有的权限
    @Override
    public void checkPermission(Permission perm) {
    }

    // 检测程序是否可执行文件
    @Override
    public void checkExec(String cmd) {
        throw new SecurityException("checkExec 权限异常：" + cmd);
    }

    // 检测程序是否允许读文件
    @Override
    public void checkRead(String file) {
        // 允许读取JVM内部资源
        if (file.startsWith("/Users/tivvvv/Library/Java/JavaVirtualMachines")) {
            return;
        }
        // 允许读取的安全目录，应调整为实际用于存放提交代码和必要资源的目录
        String allowedDirectory = "/Users/tivvvv/IdeaProjects/online-judge-sandbox/code/";

        // 确保请求的文件路径确实位于允许的目录下
        try {
            // 获取规范路径，以处理相对路径等情况
            String canonicalPath = new File(file).getCanonicalPath();
            System.out.println(canonicalPath);
            if (canonicalPath.startsWith(allowedDirectory)) {
                return;
            }
        } catch (IOException e) {
            // 处理获取规范路径时可能发生的异常
            throw new SecurityException("检查文件访问时出错：" + file, e);
        }

        // 对于所有其他路径，抛出安全异常
        System.out.println(file);
        throw new SecurityException("checkRead 权限异常：" + file);
    }


    // 检测程序是否允许写文件
    @Override
    public void checkWrite(String file) {
        throw new SecurityException("checkWrite 权限异常：" + file);
    }

    // 检测程序是否允许删除文件
    @Override
    public void checkDelete(String file) {
        throw new SecurityException("checkDelete 权限异常：" + file);
    }

    // 检测程序是否允许连接网络
    @Override
    public void checkConnect(String host, int port) {
        throw new SecurityException("checkConnect 权限异常：" + host + ":" + port);
    }
}
