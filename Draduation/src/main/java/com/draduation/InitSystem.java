package com.draduation;

import com.draduation.interfaces.OpeFatch;
import com.draduation.interfaces.OpeStu;
import com.draduation.utils.Utils;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class InitSystem implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        System.out.println("比赛系统启动成功");
    }
}
