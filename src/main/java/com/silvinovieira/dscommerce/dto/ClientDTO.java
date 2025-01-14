package com.silvinovieira.dscommerce.dto;

import ch.qos.logback.core.net.server.Client;
import com.silvinovieira.dscommerce.entities.User;

public class ClientDTO {
    private Long id;
    private String name;

    public ClientDTO() {
    }

    public ClientDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ClientDTO(User user) {
        id = user.getId();
        name = user.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
