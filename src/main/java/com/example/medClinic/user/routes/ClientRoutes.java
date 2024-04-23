package com.example.medClinic.user.routes;

import com.example.medClinic.base.routes.BaseRoutes;

public class ClientRoutes {

    private final static String ROOT = BaseRoutes.API + "/client";
    public final static String REGISTRATION = BaseRoutes.NOT_SECURED + "/v1/registration";
    public final static String ME = ROOT + "/me";

}
