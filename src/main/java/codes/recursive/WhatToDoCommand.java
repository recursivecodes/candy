package codes.recursive;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class WhatToDoCommand {
    private String status;

    public WhatToDoCommand(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
