package com.web.security;


public class Endpoints {
    public static final String front_end_host = "https://hoang1807.github.io";

    //    public static final String front_end_host = "https://myprojectfe.vercel.app";
    public static final String[] PUBLIC_GET_ENDPOINS = {
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/api/v1/user/{id}",
            "/api/v1/phim/{id}",
            "/api/v1/phim/random",
            "/api/v1/phim/search",
            "/api/v1/phim/byTheLoai/{id}",
            "/api/v1/tapphim/tapphimmoi",
            "/api/v1/tapphim/byPhim/{id}",
            "/api/v1/tapphim/byTheLoai/{id}",
            "/api/v1/tapphim/{id}",
            "/api/v1/theloaiphim/{id}",
            "/api/v1/theloai/{id}",
            "/api/v1/theloai/random",
            "/api/v1/phim/phimmoi",
            "/api/v1/yeuthich/count/{id}"
    };

    public static final String[] PUBLIC_POST_ENDPOINS = {
    		"/api/v1/user/login",
    		"/api/v1/user/register",   		
    };

    public static final String[] PUBLIC_PUT_ENDPOINS = {
    		 "/api/v1/tapphim/updateView/{id}",
    };

    public static final String[] ADMIN_GET_ENDPOINS = {
    		"/api/v1/user/**",
    		"/api/v1/theloai/**",
    		"/api/v1/phim/**",
    		"/api/v1/theloaiphim/**",
    		"/api/v1/tapphim/**",
    };

    public static final String[] ADMIN_POST_ENDPOINS = {
    		"/api/v1/user/**",
    		"/api/v1/theloai/**",
    		"/api/v1/phim/**",
    		"/api/v1/theloaiphim/**",
    		"/api/v1/tapphim/**"
    };

    public static final String[] ADMIN_PUT_ENDPOINS = {
    		"/api/v1/user/**",
    		"/api/v1/theloai/**",
    		"/api/v1/phim/**",
    		"/api/v1/theloaiphim/**",
    		"/api/v1/tapphim/**"
    };

    public static final String[] ADMIN_DELETE_ENDPOINS = {
    		"/api/v1/user/**",
    		"/api/v1/theloai/**",
    		"/api/v1/phim/**",
    		"/api/v1/theloaiphim/**",
    		"/api/v1/tapphim/**"
    };


    public static final String[] USER_GET_ENDPOINS = {
    		"/api/v1/account/**"
    };
    
    public static final String[] USER_POST_ENDPOINS = {
    };
    
    public static final String[] USER_DELETE_ENDPOINS = {
    };
    
    public static final String[] USER_ADMIN_GET_ENDPOINS = {
    		"/api/v1/yeuthich/**",
    };
    public static final String[] USER_ADMIN_POST_ENDPOINS = {
    		"/api/v1/yeuthich/**",
    };
    public static final String[] USER_ADMIN_DELETE_ENDPOINS = {
    		"/api/v1/yeuthich/**",
    };
}
