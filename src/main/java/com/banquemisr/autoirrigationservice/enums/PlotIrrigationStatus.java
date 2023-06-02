package com.banquemisr.autoirrigationservice.enums;

public enum PlotIrrigationStatus {
    RUNNING("RUNNING"),
    SENSOR_NOT_RESPONDING("SENSOR_NOT_RESPONDING"),
    FINISHED("FINISHED");

    private final String status;

    PlotIrrigationStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
