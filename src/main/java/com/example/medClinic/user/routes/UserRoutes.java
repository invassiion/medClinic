package com.example.medClinic.user.routes;

import com.example.medClinic.base.routes.BaseRoutes;

public class UserRoutes {

    private final static String ROOT = BaseRoutes.API + "/client";
    public final static String REGISTRATION = BaseRoutes.NOT_SECURED + "/v1/registration";
    public final static String EDIT = ROOT;
    public final static String BY_ID = ROOT + "/{id}";
    public final static String SEARCH = ROOT;
    public final static String INIT = BaseRoutes.NOT_SECURED + "/init";
    public final static String CLIENT = ROOT + "/me";

}
