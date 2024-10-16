package com.manuellarrota.crudfeatures.entity;


import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

/**
 * Superclase Generica con atributos generales que son reusados como singleton para las
 * obtenerEspecificacion clases entidades relacionales del sistema.
 *
 * @author Manuel Larrota
 */
@MappedSuperclass
public class Domain implements Serializable {

    protected Boolean visible = true;
    protected Boolean enable = true;
    protected Date lastUpdate;
    protected Date dateCreated;
    protected Date dateDisabled;

    @PrePersist
    @PreUpdate
    protected void beforeUpdate() {
        if (enable == null) {
            enable = true;
        }
        if (visible == null) {
            visible = true;
        }
        if (dateCreated == null) {
            setDateCreated(Date.from(Instant.now()));
        }
        setLastUpdate(Date.from(Instant.now()));
        if (enable == false) {
            setDateDisabled(Date.from(Instant.now()));
        }
    }

    public Boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean isDisponible() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Boolean getVisible() {
        return visible;
    }

    public Boolean getEnable() {
        return enable;
    }

    public Date getDateDisabled() {
        return dateDisabled;
    }

    public void setDateDisabled(Date dateDisabled) {
        this.dateDisabled = dateDisabled;
    }
}
