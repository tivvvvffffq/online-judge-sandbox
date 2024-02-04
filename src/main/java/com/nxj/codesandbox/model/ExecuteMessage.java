package com.nxj.codesandbox.model;

import lombok.Data;

/**
 * 进程执行信息
 */
@Data
public class ExecuteMessage {

    /**
     * 退出码
     */
    private Integer exitValue;

    /**
     * 正常输出信息
     */
    private String message;

    /**
     * 异常输出信息
     */
    private String errorMessage;

    /**
     * 执行时间
     */
    private Long time;

    /**
     * 消耗内存
     */
    private Long memory;
}
