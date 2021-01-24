package io.github.floyd.design.command;

/**
 * 此类的主要功能是： <br/>
 * 1. 处理<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.design.command
 * Company: com.yinhai
 * date 2020/9/9
 */
public abstract class Command {

    protected Barbecuer receiver;

    public Command(Barbecuer receiver) {
        this.receiver = receiver;
    }

    /**
     * 执行
     */
    public abstract void executeCommand();
}
