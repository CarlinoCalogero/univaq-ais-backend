package it.univaq.aisbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Generated;

import java.io.Serializable;

public class Interaction implements Serializable {
    @JsonIgnore
    public static final Long serializableId = Long.MAX_VALUE;
    private boolean rotateX;
    private boolean rotateY;
    private boolean rotateZ;
    private boolean transformX;
    private boolean transformY;
    private boolean transformZ;

    @Generated
    public Interaction() {
    }

    @Generated
    public boolean isRotateX() {
        return this.rotateX;
    }

    @Generated
    public boolean isRotateY() {
        return this.rotateY;
    }

    @Generated
    public boolean isRotateZ() {
        return this.rotateZ;
    }

    @Generated
    public boolean isTransformX() {
        return this.transformX;
    }

    @Generated
    public boolean isTransformY() {
        return this.transformY;
    }

    @Generated
    public boolean isTransformZ() {
        return this.transformZ;
    }

    @Generated
    public void setRotateX(final boolean rotateX) {
        this.rotateX = rotateX;
    }

    @Generated
    public void setRotateY(final boolean rotateY) {
        this.rotateY = rotateY;
    }

    @Generated
    public void setRotateZ(final boolean rotateZ) {
        this.rotateZ = rotateZ;
    }

    @Generated
    public void setTransformX(final boolean transformX) {
        this.transformX = transformX;
    }

    @Generated
    public void setTransformY(final boolean transformY) {
        this.transformY = transformY;
    }

    @Generated
    public void setTransformZ(final boolean transformZ) {
        this.transformZ = transformZ;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Interaction)) {
            return false;
        } else {
            Interaction other = (Interaction) o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.isRotateX() != other.isRotateX()) {
                return false;
            } else if (this.isRotateY() != other.isRotateY()) {
                return false;
            } else if (this.isRotateZ() != other.isRotateZ()) {
                return false;
            } else if (this.isTransformX() != other.isTransformX()) {
                return false;
            } else if (this.isTransformY() != other.isTransformY()) {
                return false;
            } else {
                return this.isTransformZ() == other.isTransformZ();
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof Interaction;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isRotateX() ? 79 : 97);
        result = result * 59 + (this.isRotateY() ? 79 : 97);
        result = result * 59 + (this.isRotateZ() ? 79 : 97);
        result = result * 59 + (this.isTransformX() ? 79 : 97);
        result = result * 59 + (this.isTransformY() ? 79 : 97);
        result = result * 59 + (this.isTransformZ() ? 79 : 97);
        return result;
    }

    @Generated
    public String toString() {
        boolean var10000 = this.isRotateX();
        return "Interaction(rotateX=" + var10000 + ", rotateY=" + this.isRotateY() + ", rotateZ=" + this.isRotateZ() + ", transformX=" + this.isTransformX() + ", transformY=" + this.isTransformY() + ", transformZ=" + this.isTransformZ() + ")";
    }
}
