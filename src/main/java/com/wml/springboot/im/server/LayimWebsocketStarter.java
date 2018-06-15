package com.wml.springboot.im.server;

import com.wml.springboot.im.server.config.LayimServerConfig;
import com.wml.springboot.im.server.handler.LayimMsgHandler;
import com.wml.springboot.im.util.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.tio.server.ServerGroupContext;

import java.io.IOException;

/**
 * @author fyp
 * @crate 2017/11/19 18:32
 * @project SpringBootLayIM
 */
@Component
public class LayimWebsocketStarter {
    private static Logger logger = LoggerFactory.getLogger(LayimWebsocketStarter.class);

    private LayimServerStarter layimServerStarter;
    private ServerGroupContext serverGroupContext;

    public LayimWebsocketStarter(LayimServerConfig layimServerConfig) throws Exception {
        layimServerStarter = new LayimServerStarter(layimServerConfig, new LayimMsgHandler());
        serverGroupContext = layimServerStarter.getServerGroupContext();
    }

    public LayimServerStarter getWsServerStarter() {
        return layimServerStarter;
    }

    public void start() throws IOException {
        layimServerStarter.start();
        MessageUtil.groupContext = getServerGroupContext();
    }

    /**

     * @return the serverGroupContext

     */
    public ServerGroupContext getServerGroupContext() {
        return serverGroupContext;
    }

}
