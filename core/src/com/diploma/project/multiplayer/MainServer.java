package com.diploma.project.multiplayer;

import com.diploma.project.multiplayer.Utils.Constants;
import com.diploma.project.multiplayer.server.Server;


public class MainServer {
    public static void main(String[] args) throws Exception {
        Server.getInstance().start(Constants.PORT);
    }
}
