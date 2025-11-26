package com.stelios.bankmanagementsystem.Models;

import com.stelios.bankmanagementsystem.Views.ViewFactory;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;

    public Model() {
        this.viewFactory = new ViewFactory();
    }


    public static synchronized Model getInstance() {
        if(model == null){
            model = new Model();
        }
        return model;
    }
}
