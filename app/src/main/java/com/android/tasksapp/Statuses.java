package com.android.tasksapp;

public enum Statuses {

    TO_DO, IN_PROGRESS, COMPLETED, NOT_DECIDED;

    static Statuses getStatus(String status){

        Statuses statusReturn;

        switch (status){
            case "To do":
                statusReturn = TO_DO;
                break;
            case "In Progress":
                statusReturn = IN_PROGRESS;
                break;
            case "Completed":
                statusReturn = COMPLETED;
                break;
            default:
                statusReturn = NOT_DECIDED;
        }

        return statusReturn;
    }
}
